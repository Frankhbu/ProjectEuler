package me.hbu.frank.archives;

import me.hbu.frank.utils.NumberUtils;

/**
n! means n ¡Á (n - 1) ¡Á ... ¡Á 3 ¡Á 2 ¡Á 1

For example, 10! = 10 ¡Á 9 ¡Á ... ¡Á 3 ¡Á 2 ¡Á 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
 */
public class Problem020 {

	public static void main(String[] args) {
		String temp = "1";
		for (int i = 1; i <= 100; i++) {
			temp = NumberUtils.mutiply(temp, i+"");
		}
		char[] digits = temp.toCharArray();
		int sum = 0;
		for (int i = 0; i < digits.length; i++) {
			sum += Integer.parseInt(digits[i]+"");
		}
		System.out.println(sum);
	}

}
