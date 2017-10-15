package libin.offer;

import java.util.Arrays;

/**
 * 面试题32：从1到n整数中1出现的次数 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */
public class _32_num_1_times {
	public static void main(String[] args) {
		Solution32 solution32 = new Solution32();
		System.out.println(solution32.NumberOf1Between1AndN_Solution(11));
	}
}

class Solution32 {
	public int NumberOf1Between1AndN_Solution(int n) {
		if (n <= 0) {
			return 0;
		}
		int[] num = getNum(n);
		return getNumTimes(num);
	}

	public int[] getNum(int n) { // 数字转换位数组
		int len = String.valueOf(n).length();
		int[] num = new int[len];
		int index = len - 1;
		while (n > 0) {
			int tmp = n % 10;
			num[index--] = tmp;
			n = n / 10;
		}
		return num;
	}

	public int getNumTimes(int[] num) { // 递归函数
		if (num.length == 0) {
			return 0;
		}
		if (num[0] < 0 || num[0] > 9) {
			return 0;
		}
		int len = num.length;
		int head = num[0];
		if (len == 1 && head == 0) {
			return 0;
		}
		if (len == 1 && head == 1) {
			return 1;
		}
		int headNum = 0;
		// 以21345为例
		// 万位个数
		if (head > 1) {
			headNum = (int) Math.pow(10, len - 1);
		} else if (head == 1) {
			int tmp = 0;
			for (int j = 1; j < len; j++) {
				tmp = tmp * 10 + num[j];
			}
			System.out.println("tmp=" + tmp);
			headNum = tmp + 1;
		}
		System.out.println("headNum=" + headNum);
		int deleteHeadNum = 0;
		// 万位剩下4位个数
		deleteHeadNum = head * (len - 1) * ((int) Math.pow(10, len - 2));
		// 递归千位
		int numRecursion = getNumTimes(Arrays.copyOfRange(num, 1, len));
		return headNum + deleteHeadNum + numRecursion;
	}
}
