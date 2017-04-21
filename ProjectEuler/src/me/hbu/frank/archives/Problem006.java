package me.hbu.frank.archives;

/**
The sum of the squares of the first ten natural numbers is,

12 + 22 + ... + 102 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)2 = 552 = 3025
Hence the difference between the sum of the squares of 
the first ten natural numbers and the square of the sum is 3025 - 385 = 2640.

Find the difference between the sum of the squares of 
the first one hundred natural numbers and the square of the sum.
 */
public class Problem006 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long sum1 = 0;
		int temp = 0;
		for (int i = 1; i <= 100; i++) {
			sum1 += Math.pow(i, 2);
			temp += i;
		}
		System.out.println((long)(Math.pow(temp, 2) - sum1));
	}

}
