package me.hbu.frank.archives;

import me.hbu.frank.utils.NumberUtils;

/**
2520 is the smallest number that can be divided by each of the numbers 
from 1 to 10 without any remainder.

What is the smallest positive number that is evenly 
divisible by all of the numbers from 1 to 20?

����˼·���������ĳ˻������������������Լ������С�������Ļ�
 */
public class Problem005 {

	public static void main(String[] args) {
		long result = 1;
		for (int i = 1; i <= 20; i++) {
			result = i * result / NumberUtils.getGreatestCommonDivisor(i, result);
		}
		System.out.println(result);
	}
}
