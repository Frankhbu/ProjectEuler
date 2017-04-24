package me.hbu.frank.archives;

import me.hbu.frank.utils.NumberUtils;

/**
The number, 197, is called a circular prime because all rotations of the digits: 
197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?
 */
public class Problem035 {

	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i < 1000000; i++) {
			if (isCirclePrime(i)) {
				count++;
			}
		}
		System.out.println(count);
	}

	/** 判断i是否是循环质数
	 * @param i
	 * @return
	 */
	private static boolean isCirclePrime(int i) {
		boolean result = NumberUtils.isPrimeNumber(i);
		if (result) {
			char[] chars = (i+"").toCharArray();
			for (int j = 0; j < chars.length - 1; j++) {
				char temp = chars[0];
				for (int k = 0; k < chars.length - 1; k++) {
					chars[k] = chars[k+1];
				}
				chars[chars.length - 1] = temp;
				String num = new String(chars);
				if (!NumberUtils.isPrimeNumber(Integer.parseInt(num))) {
					result = false;
					return result;
				}
			}
		}
		return result;
	}

}
