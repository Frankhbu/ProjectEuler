package me.hbu.frank.archives;

/**
If we list all the natural numbers below 10 that are multiples of 3 or 5,
we get 3, 5, 6 and 9. The sum of these multiples is 23.
Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem001 {

	public static void main(String[] args) {
		int limit = 1000;
		int[] seeds = new int[]{3,5};
		int sum = getSumBySeedsUnderLimit(limit,seeds);
		System.out.println(sum);
	}
	/**
	 * 求limit下，所有seeds任意元素倍数的和
	 * @param limit
	 * @param seeds
	 * @return
	 */
	private static int getSumBySeedsUnderLimit(int limit, int[] seeds) {
		int sum = 0;
		for (int i = 0; i < limit ; i++) {
			if (isMultiples(i,seeds)) {
				sum += i;
			}
		}
		return sum;
	}

	/**
	 * 判断i是否是seeds中任意元素的倍数
	 * @param i
	 * @param seeds
	 * @return
	 */
	private static boolean isMultiples(int i, int[] seeds) {
		for (int j : seeds) {
			if (i % j == 0) {
				return true;
			}
		}
		return false;
	}

}
