package libin.general._09_sort;
/**
 * 归并排序
 * @author baolibin
 */
public class _07_mergeSort {
	public static void main(String[] args) {
		int[] tmpNum={54,23,8,87,56,21,34,17,6,23,4};
		mergeSort mergesort = new mergeSort(tmpNum);
		mergesort.sortProgress();
		mergesort.fnPrint();
	}
}
class mergeSort {
	private int[] tmpNum;
	public mergeSort(int[] tmpNum) {
		this.tmpNum=tmpNum;
	}
	/**
	 * 归并排序
	 * @param tmpNum 待排序的数组
	 * @param low 第一段数组的起始下标
	 * @param middle 第一段数组的末尾下标
	 * @param high 第二段数组的末尾下标
	 */
	public void merge_Sort(int[] tmpNum, int low, int middle, int high) {
		int first = low; // 存放第一段序列下标
		int second = middle + 1; // 存放第二段序列下标
		int tmpkey = 0; // 存放合并数组的下标
		int tmp[] = new int[high - low + 1]; // 存放合并数组用的
		while (first <= middle && second <= high) {
			if (tmpNum[first] < tmpNum[second]) {
				tmp[tmpkey] = tmpNum[first];
				first++;
				tmpkey++;
			} else {
				tmp[tmpkey] = tmpNum[second];
				second++;
				tmpkey++;
			}
		}
		// 第一个段数组没有遍历完
		while (first <= middle) {
			tmp[tmpkey] = tmpNum[first];
			first++;
			tmpkey++;
		}
		// 第二个段数组没有遍历完
		while (second <= high) {
			tmp[tmpkey] = tmpNum[high];
			second++;
			tmpkey++;
		}
		int k=low;
		//将合并的数组拷贝到原始的数组中
		for (int i = 0; i < tmp.length; i++) {
			tmpNum[k]=tmp[i];
			k++;
		}
	}
	public void sortProgress(){
		//进行每趟归并，改变字表的长度
		for (int step = 1; step < tmpNum.length; step=2*step) {
			int i=0;
			//进行每趟归并排序,归并长度为step的两个相邻的子表
			for(i=0;i+2*step-1<tmpNum.length;i=i+2*step){
				merge_Sort(tmpNum, i, i+step-1, i+2*step-1);
			}
			//剩下单独的一个子表
			if (i+step-1<tmpNum.length) {
				merge_Sort(tmpNum, i, i+step-1, tmpNum.length-1);
			}
		}
	}
	/**
	 * 打印函数
	 */
	public void fnPrint() {
		for (int i = 0; i < tmpNum.length; i++) {
			if (i == tmpNum.length - 1) {
				System.out.println(tmpNum[i]);
			} else {
				System.out.print(tmpNum[i] + "、");
			}
		}
	}
}
