package me.hbu.frank.utils;

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
		
		int lengthC = lengthA + lengthB - 1;
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
	 * 判断某数是否是全质数
	 * @param l
	 * @return
	 */
	public static boolean isCircularPrime(long l){
		String str = l+"";
		char[] digits = str.toCharArray();
		
		return false;
	}
	
	public static void main(String[] args) {
		
		System.out.println(getGreatestCommonDivisor(4l, 5l));
	}
}
