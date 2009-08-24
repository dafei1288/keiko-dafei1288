package net.fly78.dafei1288.util.math.algorithm.sort;

public class QuicklySort {
	public static int[] QuickSort(int[] number) {
		QuickSort(number, 0, number.length - 1);
		return number;
	}

	private static void QuickSort(int[] number, int left, int right) {
		int stmp;
		if (left < right) {
			System.out.println(left + " | " + right + " | " + (left + right)
					/ 2);
			int s = number[(left + right) / 2];
			int i = left - 1;
			int j = right + 1;
			while (true) {
				// 向右找
				while (number[++i] > s)
					;
				// 向左找
				while (number[--j] < s)
					;
				if (i >= j)
					break;
				stmp = number[i];
				number[i] = number[j];
				number[j] = stmp;
			}
			QuickSort(number, left, i - 1); // 对左边进行递回
			QuickSort(number, j + 1, right); // 对右边进行递回
		}
	}
	
	
	public static void main(String[] args){
		for(int i : QuicklySort.QuickSort(new int[]{1,3,63,12,65,23,676,3243,5,3434,332,23})){
			System.out.println(i);
		}
	}
}
