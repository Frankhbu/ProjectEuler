package me.hbu.frank.archives;

import java.math.BigInteger;

import me.hbu.frank.utils.NumberUtils;

/**
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class Problem034 {

	public static void main(String[] args) {

		BigInteger result = BigInteger.ZERO;
		BigInteger current = new BigInteger("145");
		while (true) {
			char[] digits = current.toString().toCharArray();
			BigInteger tempSum = BigInteger.ZERO;
			for (int i = 0; i < digits.length; i++) {
				BigInteger currentDigit = new BigInteger(digits[i]+"");
				tempSum = tempSum.add(NumberUtils.factorial(currentDigit));
			}
			if (tempSum.equals(current)) {
				result = result.add(current);
				System.out.println(result);
			}
			current = current.add(BigInteger.ONE);
		}
	}

}
