package me.hbu.frank.archives;

import me.hbu.frank.utils.NumberUtils;

/**
A palindromic number reads the same both ways. The largest palindrome made from 
the product of two 2-digit numbers is 
9009 = 91 ¡Á 99.
Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem004 {

	public static void main(String[] args) {
		int max = 0;
		for (int i = 999; i > 100; i--) {
			for (int j = 999; j > 100; j--) {
				if (NumberUtils.isPalindromicNumber(i*j)) {
					if (i*j > max) {
						max = i*j;
					}else {
						break;
					}
				}
			}
		}
		System.out.println(max);
	}

}
