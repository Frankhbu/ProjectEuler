package me.hbu.frank.archives;

/**
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.Find the product abc.
 */
public class Problem009 {

	public static void main(String[] args) {
		for (int a = 1; a < 1000; a++) {
			for (int b = a + 1; b < 1000; b++) {
				int c = 1000 - a - b;
				if (c > 0 && c < 1000) {
					if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)){
						System.err.println("a="+a);
						System.err.println("b="+b);
						System.err.println("c="+c);
						System.out.println("a*b*c="+a*b*c);
					}
				}
			}
		}
	}

}
