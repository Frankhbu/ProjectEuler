package me.hbu.frank.utils;

public class NumberUtils {

	/**
	 * �ж�ĳ�����Ƿ�Ϊ����
	 * @param a
	 * @return
	 */
	public static boolean isPrimeNumber(int a){
		return isPrimeNumber((long)a);
	}
	
	/**
	 * �ж�ĳ���������Ƿ�Ϊ����
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
	 * ����������a��b�ĳ˻�
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
	 * ������ת�ã�������ת�ú���ַ�����ȥǰ��0��
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
	 * ���������ת��
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
	 * ���ַ�����ת��Ϊ��������
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

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			if(isPrimeNumber(i)){
				System.out.println(i);
			}
		}
	}
}
