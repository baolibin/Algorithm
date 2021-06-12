package libin.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 面试题65：滑动数组的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class _65_slip_num_max {
	public static void main(String[] args) {
	}
}

class Solution65 {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		if (num == null || num.length == 0 || size == 0 || size > num.length) {
			return arrayList;
		}
		int[] tmp = new int[size];
		for (int i = 0; i < size; i++) {
			tmp[i] = num[i];
		}
		Arrays.sort(tmp);
		arrayList.add(tmp[size - 1]);
		for (int j = size; j < num.length; j++) {
			for (int k = 0; k < size; k++) {
				if (tmp[k] == (num[j - size])) {  // 从tmp数组中找出要滑动丢弃元素
					tmp[k] = num[j];  // 把要滑动加入的元素加到tmp数组中
					break;
				}
			}
			Arrays.sort(tmp);
			arrayList.add(tmp[size - 1]);
		}
		return arrayList;
	}
}
