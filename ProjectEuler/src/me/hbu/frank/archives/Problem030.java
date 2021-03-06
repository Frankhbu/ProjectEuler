package me.hbu.frank.archives;

import java.math.BigInteger;

/**
Surprisingly there are only three numbers that can be written as the sum of fourth powers 
of their digits:

1634 = 1^4 + 6^4 + 3^4 + 4^4
8208 = 8^4 + 2^4 + 0^4 + 8^4
9474 = 9^4 + 4^4 + 7^4 + 4^4
As 1 = 1^4 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers 
of their digits.
 */
public class Problem030 {

	public static void main(String[] args) {
		BigInteger result = BigInteger.ZERO;
		BigInteger current = new BigInteger("2");
		while (true) {
			char[] digits = current.toString().toCharArray();
			BigInteger tempSum = BigInteger.ZERO;
			for (int i = 0; i < digits.length; i++) {
				tempSum = tempSum.add(new BigInteger(digits[i]+"").pow(5));
			}
			if (tempSum.equals(current)) {
				result = result.add(current);
				System.out.println(result);
			}
			current = current.add(BigInteger.ONE);
		}
	}

}
