package me.hbu.frank.utils;

import java.util.List;

public class NumberUtils {

	/**
	 * 判断某整形数是否为回文数
	 * @param l
	 * @return
	 */
	public static boolean isPalindromicNumber(int i){
		return isPalindromicNumber((long)i);
	}
	/**
	 * 判断某长整形数是否为回文数
	 * @param l
	 * @return
	 */
	public static boolean isPalindromicNumber(long l){
		boolean result = true;
		char[] array = (l+"").toCharArray();
		for (int i = 0; i < array.length / 2; i++) {
			if (array[i] != array[array.length - 1 - i]) {
				result = false;
			}
		}		
		return result;
	}
	/**
	 * 判断某整数是否为质数
	 * @param a
	 * @return
	 */
	public static boolean isPrimeNumber(int a){
		return isPrimeNumber((long)a);
	}
	
	/**
	 * 判断某长整形数是否为质数
	 * @param a
	 */
	public static boolean isPrimeNumber(long a) {
		boolean result = true;
		if (a < 2) {
			return false;
		}else {
			for (int i = 2; i <= Math.sqrt(a) ; i++) {
				if ( a % i == 0) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
	/**
	 * 计算两个数a和b的乘积
	 * @param a
	 * @param b
	 * @return c
	 */
	public static String mutiply(String a,String b){
		
		int lengthA = a.length();
		int lengthB = b.length();
		
		char[] charArrayA = a.toCharArray();
		char[] charArrayB = b.toCharArray();
		
		int[] intArrayA = getIntArray(charArrayA);
		int[] intArrayB = getIntArray(charArrayB);
		intArrayA = transposition(intArrayA);
		intArrayB = transposition(intArrayB);
		
		int lengthC = lengthA + lengthB;
		int[] intArrayC = new int[lengthC];
		
		for (int i = 0; i < intArrayB.length; i++) {
			for (int j = 0; j < intArrayA.length; j++) {
				int temp = intArrayB[i] * intArrayA[j];
				temp += intArrayC[i+j];
				if (temp > 9) {
					intArrayC[i+j] = temp % 10;
					intArrayC[i+j+1] += temp / 10; 
				}else {
					intArrayC[i+j] = temp;
				}
			}
		}
		
		return getTranspositionedString(intArrayC);
	}

	/**
	 * 计算a和b两个数的和
	 * @param a
	 * @param b
	 * @return
	 */
	public static String add(String a,String b){
		int lengthA = a.length();
		int lengthB = b.length();
		
		char[] charArrayA = a.toCharArray();
		char[] charArrayB = b.toCharArray();
		
		int[] intArrayA = getIntArray(charArrayA);
		int[] intArrayB = getIntArray(charArrayB);
		intArrayA = transposition(intArrayA);
		intArrayB = transposition(intArrayB);
		
		int lengthC = (lengthA > lengthB) ? lengthA + 1:lengthB + 1;
		int[] intArrayC = new int[lengthC];
		
		int longger = (lengthA >= lengthB) ? lengthA : lengthB;
		int shorter = (lengthA >= lengthB) ? lengthB : lengthA;
		
		for (int i = 0; i < shorter; i++) {
			int temp = intArrayA[i] + intArrayB[i] + intArrayC[i];
			if (temp > 9) {
				intArrayC[i] = temp % 10;
				intArrayC[i+1] = temp / 10;
			}else {
				intArrayC[i] = temp;
			}
		}
		if (longger > shorter) {
			if (lengthA > lengthB) {
				for (int i = shorter; i < longger; i++) {
					int temp = intArrayA[i] + intArrayC[i];
					if (temp > 9) {
						intArrayC[i] = temp % 10;
						intArrayC[i+1] = temp / 10;
					}else{
						intArrayC[i] = temp;
					}
				}
			}else {
				for (int i = shorter; i < longger; i++) {
					int temp = intArrayB[i] + intArrayC[i];
					if (temp > 9) {
						intArrayC[i] = temp % 10;
						intArrayC[i+1] = temp / 10;
					}else{
						intArrayC[i] = temp;
					}
				}
			}
		}
		
		return getTranspositionedString(intArrayC);
	}
	/**
	 * 将数组转置，并返回转置后的字符串（去前导0）
	 * @param array
	 * @return
	 */
	private static String getTranspositionedString(int[] array) {
		StringBuffer sb = new StringBuffer();
		for (int i = array.length - 1; i >= 0; i--) {			
			sb.append(array[i]);
		}
		return sb.toString().replaceFirst("^0+", "");
	}


	/**
	 * 对数组进行转置
	 * @param intArrayA
	 * @return
	 */
	private static int[] transposition(int[] intArrayA) {
		int len = intArrayA.length;
		int[] intArray = new int[len];
		for (int i = 0; i < intArrayA.length; i++) {
			intArray[i] = intArrayA[len - 1 - i];
		}
		return intArray;
	}

	/**
	 * 将字符数组转换为整形数组
	 * @param charArrayA
	 * @return
	 */
	private static int[] getIntArray(char[] charArrayA) {
		int len = charArrayA.length;
		int[] intArray = new int[len];
		for (int i = 0; i < charArrayA.length; i++) {
			intArray[i] = charArrayA[i] - 48;
		}
		return intArray;
	}

	/**
	 * 获取m和n的最大公约数
	 * @param m
	 * @param n
	 * @return
	 */
	public static long getGreatestCommonDivisor(long m,long n){
		long bigger = (m >= n)? m : n ;
		long smaller = (m > n)? n : m ;
		long max = 1;
		for (int i = 1; i <= smaller; i++) {
			if (smaller % i == 0 && bigger % i == 0 && i > max) {
				max = i;
			}
		}
		return max;
	}
	
	/**
	 * 计算数组array的全排列
	 * @param array 待排列数组
	 * @param index 开始index
	 * @param result 最终结果
	 */
	public static void arrange(Integer[] array,int index, List<Integer[]> result){
	
		if (index == array.length - 1) {
			Integer[] temp = new Integer[array.length];
			for (int i = 0; i < array.length; i++) {
				temp[i] = array[i];
			}
			result.add(temp);
		}else {
			for (int i = index; i < array.length; i++) {				
				Integer t = array[i];
				array[i] = array[index];
				array[index] = t;
				
				arrange(array, index + 1,result);
				
				t = array[i];
				array[i] = array[index];
				array[index] = t;
			}	
		}
	}
	
	/**
	 * 对数组array从startIndex开始进行排序
	 * @param array
	 * @param startIndex
	 */
	
	public static void sort(Integer[] array,int startIndex){
		for (int i = 0; i < array.length - startIndex - 1 ; i++) {
			for (int j = startIndex ; j < array.length - i - 1; j++) {
				if (array[j] > array[j+1]) {					
					Integer t = array[j];
					array[j] = array[j+1];
					array[j+1] = t;
				}
			}
		}
	}
	
	/**
	 * 计算a的b次幂
	 * @param a 底数
	 * @param b 指数
	 * @return c 结果
	 */
	public static String power(String a,String b){
		long long_b = Long.parseLong(b);
		String result = "1";
		if (long_b == 0) {
			return "1";
		}
		for (int i = 1; i <= long_b; i++) {
			result = mutiply(result, a);
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(power("2", "8"));
	}
}
