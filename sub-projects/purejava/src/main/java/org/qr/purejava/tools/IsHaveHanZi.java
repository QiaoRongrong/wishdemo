package org.qr.purejava.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsHaveHanZi {
 
	public static boolean isHaveHanZi(String str){
 
		boolean flag=true;
		int count = 0;
		String regEx = "[\\u4e00-\\u9fa5]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		
		while (m.find()) {
			for (int i = 0; i <= m.groupCount(); i++) {
				count = count + 1;
			}
		}
		
		if(count==0){
			flag=false;
		}
			return flag;
		}
 
	public static void main(String[] args) {
		System.out.println(isHaveHanZi("12张"));
	}
}

//---------------------
//作者：hacker1520
//来源：CSDN
//原文：https://blog.csdn.net/hacker1520/article/details/80167153
//版权声明：本文为博主原创文章，转载请附上博文链接！