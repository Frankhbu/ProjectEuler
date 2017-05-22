package me.hbu.frank.archives;

import java.util.HashSet;
import java.util.Set;

import me.hbu.frank.utils.NumberUtils;

/**
Consider all integer combinations of ab for 2 �� a �� 5 and 2 �� b �� 5:

22=4, 23=8, 24=16, 25=32
32=9, 33=27, 34=81, 35=243
42=16, 43=64, 44=256, 45=1024
52=25, 53=125, 54=625, 55=3125
If they are then placed in numerical order, with any repeats removed, 
we get the following sequence of 15 distinct terms:

4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125

How many distinct terms are in the sequence generated by ab for 2 �� a �� 100 and 2 �� b �� 100?
 */
public class Problem029 {

	public static void main(String[] args) {
		Set<String> result = new HashSet<String>();
		for (int a = 2; a <= 100; a++) {
			for (int b = 2; b <= 100; b++) {
				String temp = NumberUtils.power(a+"", b+"");
				result.add(temp);
			}
		}
		System.out.println(result.size());
	}
}
