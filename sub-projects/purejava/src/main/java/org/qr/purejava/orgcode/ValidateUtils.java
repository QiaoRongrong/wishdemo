package org.qr.purejava.orgcode;




public class ValidateUtils {

	public static void main(String[] args) {
		System.out.println(isValidEntpCode("MA5AP9ET-5"));
	}


	/**
	 * 验证企业代码是否正确
	 * 
	 * @param code 企业组织机构代码
	 * @return
	 */
	static final boolean isValidEntpCode(String code) {
		int[] ws = { 3, 7, 9, 10, 5, 8, 4, 2 };
		String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String regex = "^([0-9A-Z]){8}-[0-9|X]$";

		if (!code.matches(regex)) {
			return false;
		}
		int sum = 0;
		for (int i = 0; i < 8; i++) {
			sum += str.indexOf(String.valueOf(code.charAt(i))) * ws[i];
		}
//		System.out.println("sum is " + sum);
//		System.out.println("sum % 11 is " + sum % 11);

		int c9 = 11 - (sum % 11);

		String sc9 = String.valueOf(c9);
		if (11 == c9) {
			sc9 = "0";
		} else if (10 == c9) {
			sc9 = "X";
		}
		//System.out.println("sc9 is " + sc9);
		return sc9.equals(String.valueOf(code.charAt(9)));
	}


}
