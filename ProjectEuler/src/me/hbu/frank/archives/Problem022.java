package me.hbu.frank.archives;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
Using names.txt (right click and 'Save Link/Target As...'), 
a 46K text file containing over five-thousand first names, 
begin by sorting it into alphabetical order. 
Then working out the alphabetical value for each name, 
multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, 
COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. 
So, COLIN would obtain a score of 938 ¡Á 53 = 49714.

What is the total of all the name scores in the file?
 */
public class Problem022 {

	private static Map<Character, Integer> letters = new HashMap<Character, Integer>();
	
	public static void main(String[] args) {
		initLettersMap();
		String namesStr = getNamesFromFile();
		String[] names = namesStr.split(",");
		sortByAlphabeticalOrder(names);
		long sum = 0;
		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			name = name.replaceAll("\"", "");
			char[] letterArray = name.toCharArray();
			int temp = 0;
			for (char c : letterArray) {
				temp += letters.get(c);
			}
			sum += temp * (i + 1);
		}
		System.out.println(sum);
	}

	private static void sortByAlphabeticalOrder(String[] names) {
		for (int i = 0; i < names.length; i++) {
			for (int j = names.length - 1; j > i; j--) {
				if (names[j].compareTo(names[j-1]) < 0) {
					String temp;
					temp = names[j-1];
					names[j-1] = names[j];
					names[j] = temp;
				}
			}
		}
	}

	private static String getNamesFromFile() {
		try {
			InputStream inputStream = Problem022.class.getResourceAsStream("/p022_names.txt");
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			byte[] temp = new byte[1024];
			int length = 1;
			try {
				while ((length = inputStream.read(temp)) != -1) {
					byteArrayOutputStream.write(temp,0,length);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			byteArrayOutputStream.close();
			inputStream.close();
			return byteArrayOutputStream.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void initLettersMap() {
		for (int i = 1; i <= 26; i++) {			
			letters.put((char)(64 + i), i);
		}
	}
}
