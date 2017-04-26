package me.hbu.frank.archives;

/**
2^15 = 32768 and the sum of its digits is 
3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
 */
import me.hbu.frank.utils.NumberUtils;

public class Problem016 {

	public static void main(String[] args) {
		
		String result = "1";
		for (int i = 0; i < 1000; i++) {
			result = NumberUtils.mutiply(result, "2");
		}
		char[] chars = (result+"").toCharArray();
		int sum = 0;
		for (int i = 0; i < chars.length; i++) {
			sum += Integer.parseInt(chars[i]+"");
		}
		System.out.println(sum);
	}

}
