package me.hbu.frank.archives;
/**
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
 */
import me.hbu.frank.utils.NumberUtils;

public class Problem010 {

	public static void main(String[] args) {
		long sum = 0;
		for (long i = 1; i < 2000000; i++) {
			if (NumberUtils.isPrimeNumber(i)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
