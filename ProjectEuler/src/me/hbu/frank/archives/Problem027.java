package me.hbu.frank.archives;

import me.hbu.frank.utils.NumberUtils;

/**
Euler discovered the remarkable quadratic formula:

n^2+n+41

It turns out that the formula will produce 40 primes for the consecutive 
integer values 0<=n<=39. 
However, when n=40,40^2+40+41=40(40+1)+41 is divisible by 41, 
and certainly when n=41,41^2+41+41 is clearly divisible by 41.

The incredible formula n^2-79n+1601 was discovered, 
which produces 80 primes for the consecutive values 0<=n<=79. 
The product of the coefficients, -79 and 1601, is -126479.

Considering quadratics of the form:

n^2+an+b, where |a|<1000 and |b|<=1000

where |n| is the modulus/absolute value of n
e.g. |11|=11 and |-4|=4
Find the product of the coefficients, a and b, 
for the quadratic expression that produces the maximum number of primes 
for consecutive values of n, starting with n=0.
consecutive£ºÁ¬ÐøµÄ
 */
public class Problem027 {

	public static void main(String[] args) {

		long resultA = 0;
		long resultB = 0;
		long maxPrimeCount = 0;
		for (long a = -999 ; a < 1000; a++) {
			for (long b = -999; b < 1000; b++) {
				long primeCount = 0;
				for (long n = 0; n <= Math.abs(a); n++) {
					long temp = n * n + a * n + b;
					if (NumberUtils.isPrimeNumber(temp)) {
						primeCount ++;
					}else {
						break;
					}
				}
				if (primeCount > maxPrimeCount) {
					resultA = a;
					resultB = b;
					maxPrimeCount = primeCount;
				}
			}
		}
		System.out.println(resultA*resultB);
	}

}
