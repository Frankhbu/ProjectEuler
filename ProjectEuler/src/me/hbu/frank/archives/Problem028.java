package me.hbu.frank.archives;

/**
Starting with the number 1 and moving to the right in a clockwise direction 
a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral 
formed in the same way?
 */
public class Problem028 {

	public static void main(String[] args) {

		long[][] array = new long[3][3];
		long sum = initArrayAndGetSumOfTheDiagnals(array);
		System.out.println(sum);
	}

	private static long initArrayAndGetSumOfTheDiagnals(long[][] array) {
		int current = 1;
		long sum = 0;
		int lastX = 0;
		int lastY = 0;
		int[][] directions = new int[][]{
				{0,1},{1,0},{0,-1},{-1,0}
		};
		int currentDirection = 0;
		int step = 1;
		int currentStep = 0;
		int stepRepeat = 0;
		while (current <= array.length * array[0].length) {
			if (current == 1) {
				lastY = (array.length - 1) / 2;
				lastX = (array[0].length -1) / 2;
				array[lastX][lastY] = current;
			}else {
				
				lastX = lastX + directions[currentDirection][0];
				lastY = lastY + directions[currentDirection][1];
				
				array[lastX][lastY] = current;				

				currentStep ++;
				if(currentStep >= step){					
					currentStep = 0;
					currentDirection = (currentDirection + 1) % directions.length;
					stepRepeat ++;
				}
			}
			if (stepRepeat == 2) {
				stepRepeat = 0;
				currentStep = 0;
				step ++;
			}
			if (lastX == lastY || lastX + lastY == array.length - 1) {
				sum += current;
			}
			current ++;
		}
		printArray(array);
		return sum;
	}

	private static void printArray(long[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]+",");
			}
			System.out.println();
		}
	}
}
