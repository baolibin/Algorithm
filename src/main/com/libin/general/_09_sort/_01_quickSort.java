package libin.general._09_sort;

/**
 * 8大内部排序算法之一：交换排序之快速排序
 * author：baolibin
 */
public class _01_quickSort {
	public static void main(String[] args) {
		// int[] tmpNum = {32, 12, 76, 3, 9, 26, 72, 9, 2, 54, 3, 23}; //待排序的数组
		int[] tmpNum = {1, 2, 3, 2};
		Sort sort = new Sort(tmpNum);
		sort.sortScheduler(0, tmpNum.length - 1, tmpNum);
		sort.print();
	}
}

class Sort {
	private int[] sortTmp;

	public Sort(int[] sortTmp) {
		this.sortTmp = sortTmp;
	}

	/**
	 * 递归调用进行排序
	 * @param low    左指针
	 * @param hight  右指针
	 * @param tmpNum 数组
	 */
	public void sortScheduler(int low, int hight, int[] tmpNum) {
		if (low < hight) {
			int middle = sortNum(low, hight, tmpNum);
			//if (middle > low && middle < hight) {
				sortScheduler(low, middle - 1, tmpNum);
				sortScheduler(middle + 1, hight, tmpNum);
			//}
		}
	}

	/**
	 * @param low    左指针
	 * @param hight  右指针
	 * @param tmpNum 数组
	 * @return 基准元素插入的位置
	 */
	public int sortNum(int low, int hight, int[] tmpNum) {
		int tmp = tmpNum[low];
		while (low < hight) {
			while (low < hight && tmp <= tmpNum[hight]) {
				hight--;
			}
			tmpNum[low] = tmpNum[hight];
			while (low < hight && tmpNum[low] <= tmp) {
				low++;
			}
			tmpNum[hight] = tmpNum[low];
		}
		tmpNum[low] = tmp;
		return low;
	}

	/**
	 * 进行结果的打印
	 */
	public void print() {
		for (int i = 0; i < sortTmp.length; i++) {
			if (i == sortTmp.length - 1) {
				System.out.print(sortTmp[i]);
			} else {
				System.out.print(sortTmp[i] + "、");
			}
		}
	}
}

