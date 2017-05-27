package me.hbu.frank.archives;
/**
The fraction 49/98 is a curious fraction(·ÖÊý), as an inexperienced mathematician in attempting 
to simplify it may incorrectly believe that 49/98 = 4/8, 
which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, 
less than one in value, and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, 
find the value of the denominator.
 */
public class Problem033 {

	public static void main(String[] args) {

		int[][] fractions = new int[4][2];
		int fracionsCount = 0;
		for (int a = 10; a < 100; a++) {
			for (int b = a + 1; b < 100; b++) {
				String stringA = a+"";
				String stringB = b+"";
				char[] arrayA = (a+"").toCharArray();
				char[] arrayB = (b+"").toCharArray();
				int commonDigitCount = 0;
				int digitIndexA = 0;
				int digitIndexB = 0;
				for (int i = 0; i < arrayA.length; i++) {
					for (int j = 0; j < arrayB.length; j++) {
						if (arrayA[i] == arrayB[j]) {
							digitIndexA = i;
							digitIndexB = j;
							commonDigitCount++;
						}
					}
				}
				if(commonDigitCount == 1 && digitIndexA != digitIndexB){
					if (a * Integer.parseInt(stringB.replaceAll(arrayB[digitIndexB]+"", ""))
						== 
						b * Integer.parseInt(stringA.replaceAll(arrayA[digitIndexA]+"", ""))) {
						fractions[fracionsCount][0] = a;
						fractions[fracionsCount][1] = b;
						fracionsCount++;
					}
				}
			}
		}
		int fenzi = fractions[0][0] * fractions[1][0] * fractions[2][0] * fractions[3][0];
		int fenmu = fractions[0][1] * fractions[1][1] * fractions[2][1] * fractions[3][1];
		System.out.println(fenzi + "/" + fenmu);
	}

}
