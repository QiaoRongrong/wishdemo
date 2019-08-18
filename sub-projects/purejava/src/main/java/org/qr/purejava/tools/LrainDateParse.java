package org.qr.purejava.tools;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class LrainDateParse {
    static final String basePath = "F:\\dev\\workspace\\wishdemo\\sub-projects\\";
    static final String inputFilePath = "purejava\\src\\main\\java\\org\\qr\\purejava\\tools\\back_carrer.txt";

    static final String outputFilePath = "5-invalid.txt";

    static final String filePath = basePath + inputFilePath;

    public static void main(String[] args) throws IOException {
        final List<String> all = readAll(filePath);

        //1、行业规则:
//        StringBuilder result = extractHoutaiHangye(all);

//        2、设计师职业规则:
//        同表头
        //StringBuilder result = extractDesigner(all);

//        3、非设计师职业规则:
//        同表头

        //5. 全部符号数字
        String invalid = extractInvalid(all);
        //System.out.println(invalid);


        FileUtils.write(new File(outputFilePath), invalid, "UTF-8");

    }

    private static String extractInvalid(List<String> all) {
        return all.stream()
                .filter(it-> !IsHaveHanZi.isHaveHanZi(it))
                .collect(Collectors.joining("\n"));

    }

    private static StringBuilder extractDesigner(List<String> all) {
        StringBuilder result = new StringBuilder("");
//        String[] designerArray = BaseParser.getForDesigner();
        String[] designerArray = BaseParser.getForNonDesigner();
        Arrays.stream(designerArray).forEach(
                it -> {
                    System.out.println("------" + it);
                    result.append("------" + it + "\n");

                    String collect = all.stream()
                            .filter(allIt -> StringUtils.contains(allIt, it))
                            .collect(Collectors.joining("\n"));

                    System.out.println( collect + "\n\n\n");
                    result.append(collect + "\n\n\n");
                }
        );


        return result;
    }

    /**
     * 1、行业规则:
     */
    private static StringBuilder extractHoutaiHangye(List<String> all) {
        StringBuilder result = new StringBuilder("");
        hangyeMap.forEach(
                (key, value) -> {
                    System.out.println("\t-------" + key + " : ");
                    result.append("\t-------" + key + " : ");

                    String[] strings = StringUtils.split(value, "/");
                    Arrays.stream(strings).forEach(
                            it -> {
                                System.out.println("\t\t-------" + it + " : ");
                                result.append("\t\t-------" + it + " : ");

                                String collect = all.stream()
                                        .filter(allIt -> StringUtils.contains(allIt, it))
                                        .collect(Collectors.joining("\n"));

                                System.out.println(collect + "\n\n\n");
                                result.append(collect + "\n\n\n");

                            }
                    );



                }
        );
        return result;
    }

    private static List<String> readAll(String filePath) {
        List<String> lines = Collections.emptyList();
        try {
            lines = FileUtils.readLines(new File(filePath), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("rows: " + lines.size());
//        lines.stream().forEach(
//                it -> System.out.println(it)
//        );

        return lines;
    }

    static Map<String , String> hangyeMap = new TreeMap<>();
    static {
        hangyeMap.put("互联网/游戏/IT/通信/电子", "互联网/游戏/IT/通信/电子");
        hangyeMap.put("电子商务", "电子商务/淘宝/天猫/京东/网店");
        hangyeMap.put("印刷/出版/包装", "印刷/出版/包装");
        hangyeMap.put("广告/公关/会展/媒体/影视/传媒", "广告/公关/会展/媒体/影视/传媒");
        hangyeMap.put("教育/培训/科研/院校/体育", "教育/培训/科研/院校/体育/学生/老师/讲师/培训师");
        hangyeMap.put("金融/保险/银行/证券/信托/会计", "金融/保险/银行/证券/信托/会计");
        hangyeMap.put("地产/建筑/家装/物业", "地产/建筑/家装/物业");
        hangyeMap.put("咨询/法律/中介/外包服务", "咨询/法律/中介/外包服务");
        hangyeMap.put("酒店/餐饮/旅游", "酒店/餐饮/旅游");
        hangyeMap.put("贸易/批发/零售/租赁业", "贸易/批发/零售/租赁业");
        hangyeMap.put("生产/制造/加工/机械/化工", "生产/制造/加工/机械/");
        hangyeMap.put("交通/运输/物流/仓储", "交通/运输/物流/仓储");
        hangyeMap.put("医疗/护理/美容/保健/卫生服务", "医疗/护理/美容/保健/卫生服务/医美");
        hangyeMap.put("能源/矿产/环保/电力/水利", "能源/矿产/环保/电力/水利");
        hangyeMap.put("政府/公共事业/非盈利机构", "政府/公共事业/非盈利机构");
        hangyeMap.put("农/林/牧/渔", "农/林/牧/渔");

    }





}
