package me.hbu.frank.archives;

import java.util.Arrays;

import me.hbu.frank.utils.NumberUtils;

/**

	A permutation is an ordered arrangement of objects. For example, 
	3124 is one possible permutation of the digits 1, 2, 3 and 4. 
	If all of the permutations are listed numerically or alphabetically, 
	we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
	
	012   021   102   120   201   210
	
	What is the millionth lexicographic permutation of the digits 
	0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

 */
public class Problem024 {

	private static long count = 0;
	
	public static void main(String[] args) {
		Integer[] array = new Integer[]{0,1,2,3,4,5,6,7,8,9};
		NumberUtils.sort(array, 0);
		arrange(array, 0);
		//2783915460
	}
	
	public static void arrange(Integer[] array,int index){
		
		if (index == array.length - 1) {
			count ++;
			if (1000000 == count) {
				for (int i = 0; i < array.length; i++) {
					System.out.print(array[i]);
				}
			}
		}else {
			for (int i = index; i < array.length; i++) {
				
				Integer[] temp = new Integer[array.length];
				temp = Arrays.copyOf(array, array.length);
				
				NumberUtils.sort(temp, index);
				
				swape(temp,i,index);
				
				arrange(temp, index + 1);
				
				swape(temp,i,index);
				
			}
		}
	}

	private static void swape(Integer[] temp, int i, int j) {
		Integer t = temp[i];
		temp[i] = temp[j];
		temp[j] = t;
	}
}
