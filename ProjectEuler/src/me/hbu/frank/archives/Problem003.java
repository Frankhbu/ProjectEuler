package me.hbu.frank.archives;

import me.hbu.frank.utils.NumberUtils;

/**
 * 
The prime factors of 13195 are 5, 7, 13 and 29.
What is the largest prime factor of the number 600851475143 ?
 */
public class Problem003 {
	
	public static void main(String[] args) {
		long result = getMaxPrimeFactor(600851475143l);
		System.out.println(result);
	}

	private static long getMaxPrimeFactor(long l) {
		long max = 0l;
		for (long i = 1; i <= l / 2 ; i++) {
			if (l % i == 0) {
				if (NumberUtils.isPrimeNumber(l/i)) {
					if (l/i > max) {
						max = l/i;
					}else {
						break;
					}
				}
			}
		}
		return max;
	}

}
