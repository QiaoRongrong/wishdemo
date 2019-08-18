package org.qr.purejava.tools;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Spliterators;

public class BaseParser {

    static String designer = "印刷打印职员\t电商设计师\t美工\t插画原画师\t动漫游戏\t平面设计师\t网页UI设计师\tUE\tUX设计师\t产品\t工业设计师\t摄影\t摄像师\t后期\t动画\t特效师\t三维\t模型设计师\t建筑\t园林\t空间设计师\t宴会\t婚礼\t舞美设计师\t服装设计师\t工艺\t珠宝设计师\t设计专业学生\t艺术教育工作者\t其他\t待定区域";
    static String nonDesigner = "企业管理者 /在校学生（非设计） /教师/培训师 /顾问/咨询师/分析师 /新媒体运营 /互联网运营/产品/研发 /市场/营销/推广/品牌 /编辑/文案/策划 /博主/主播/网红/KOL /HR/人力资源/财会/出纳 /行政/秘书/客服/后勤 /销售/商务BD/中介 /服务员/普通工人/配送员 /政府机关/公务员/NGO职员 /编剧/作家/书画家/记者 /主持/演员/导演/模特/经纪人 /医护/律师/导游/文体从业者 /化妆/造型/发型/美甲师 /农林牧渔劳动者 /个体户/承包商 /自由职业者 /其他（手填） /待定区域";
    public static void main(String[] args) {
        //StringUtils.isNumeric();

        System.out.println(StringUtils.isAlpha("@#$"));


//        String trimed = StringUtils.trim(designer);
//        String[] designerArray = StringUtils.split(trimed, "\t");

//        String[] splitted = splitAndTrim();
//
//        for (String s : splitted) {
//            System.out.println(s);
//        }
    }

    public static String[] getForDesigner() {
        return splitAndTrim(designer, "\t");
    }

    public static String[] getForNonDesigner() {
        return splitAndTrim(nonDesigner, "/");
    }

    public static String[] splitAndTrim(final String raw, final String splitBy) {
        return Arrays.stream(raw.split(splitBy))
                    .map(String::trim)
                    .toArray(String[]::new);
    }


}
