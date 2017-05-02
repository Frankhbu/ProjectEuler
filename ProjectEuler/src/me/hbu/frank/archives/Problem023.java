package me.hbu.frank.archives;



/**
 perfect number is a number for which the sum of 
 its proper divisors is exactly equal to the number. 
 For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, 
 which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors 
is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, 
the smallest number that can be written as the sum of two abundant numbers is 24. 
By mathematical analysis, it can be shown that all integers greater than 28123 
can be written as the sum of two abundant numbers. However, 
this upper limit cannot be reduced any further by analysis even though 
it is known that the greatest number that cannot be expressed as 
the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as 
the sum of two abundant numbers.
 */
public class Problem023 {

	public static void main(String[] args) {
		long sum = 0;
		boolean flag = false;
		for (int i = 1; i <= 28123; i++) {
			for (int j = 1; j <= i / 2; j++) {
				int k = i - j;
				if (isAbundant(j) && isAbundant(k)) {
					flag = true;
					break;
				}
			}
			if (!flag) {				
				sum += i;
			}
			flag = false;
		}
		System.out.println(sum);
//		for (int i = 1; i < 20; i++) {
//			System.out.println(i + ":" + isAbundant(i));
//		}
	}


	private static boolean isAbundant(int n) {
		
		int sum = 0;
		for (int i = 1; i <= Math.sqrt(n) ; i++) {
			if (n % i == 0) {
				sum += i;
				int j = n / i;
				if (i != j && j < n) {
					sum += j;
				}
			}
		}
		if (sum > n) {
			return true;
		}else {			
			return false;
		}
	}
}
