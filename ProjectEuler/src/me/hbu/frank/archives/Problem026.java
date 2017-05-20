package me.hbu.frank.archives;

import java.util.ArrayList;
import java.util.List;

/**
A unit fraction contains 1 in the numerator. The decimal representation of the 
unit fractions with denominators 2 to 10 are given:

1/2		= 	0.5
1/3		= 	0.(3)
1/4		= 	0.25
1/5		= 	0.2
1/6		= 	0.1(6)
1/7		= 	0.(142857)
1/8		= 	0.125
1/9		= 	0.(1)
1/10	= 	0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. 
It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle 
in its decimal fraction part.
 */
public class Problem026 {

	public static void main(String[] args) {
		int maxLength = 0;
		for (int i = 1; i < 1000; i++) {
			int currentLength = getRecurringCycleLenthOfReciprocal(i);
			if(currentLength > maxLength){
				maxLength = currentLength;
			}
		}
		System.out.println(maxLength);
	}

	/**
	 * 获取i的倒数的循环节长度
	 * @param i
	 * @return
	 */
	private static int getRecurringCycleLenthOfReciprocal(int i) {
		String result = devide(1, i);
		if (i == 983) {
			System.out.println(result);
		}
		if(result.contains("(") && result.contains(")")){
			return result.indexOf(')') - result.indexOf('(');
		}else {
			return 0;
		}
	}

	/**
	 * 计算两数相除的商
	 * @param dividend 被除数
	 * @param divisor 除数
	 * @return 商
	 */
	public static String devide(int dividend,int divisor){
		String result = "";
		List<Integer> remainders = new ArrayList<Integer>();
		int temp = dividend / divisor;
		result += temp+".";
		int remainder = dividend % divisor;
		dividend = remainder * 10;
		remainders.add(dividend);
		int startIndex = 0;
		while (true) {
			temp = dividend / divisor;
			result += temp;
			remainder = dividend % divisor;
			dividend = remainder * 10;				
			if (remainder == 0) {
				return result;
			}
			if (remainders.contains(dividend)) {
				startIndex = remainders.indexOf(dividend);
				break;
			}else {
				remainders.add(dividend);
			}
		}
		return result.substring(0,2+startIndex)+"("+result.substring(2+startIndex)+")";
	}
}
