/**
 *	把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *	输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *	例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *
 *	Author: matao
 */

public class MinNumberInRotatedArray {
	// 非递减排序，即可能存在重复数字
	public static int minNumberInRotateArray(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		int start = 0, end = array.length-1;

		// 首尾相同，故无法折半
		if(array[start] == array[end]) {
			int min = array[0];
			for (int i = 1; i < array.length; i++) {
				if(min > array[i]) {
					min = array[i];
				}
			}
			return min;
		} else if (array[start] < array[end]) {  //顺序正确，旋转过0个位置
			return array[start];
		} else {
			while(start + 1 < end) {
				int mid = start + (end - start) / 2;
				if(array[mid] > array[start]) { //前半顺序正常
					start = mid;
				} else if(array[mid] < array[start]) {
					end = mid;
				}
			}
			if(array[start] > array[end]) {
				return array[end];
			} else {
				return array[start];
			}
		}
	}

	public static void main(String[] args) {
		int[] array1 = {3, 4, 5, 1, 2};
		System.out.println(minNumberInRotateArray(array1));

		int[] array2 = {1, 2, 5, 1, 1};
		System.out.println(minNumberInRotateArray(array2));

		int[] array3 = {1, 2, 3, 4, 5};
		System.out.println(minNumberInRotateArray(array3));
	}
}