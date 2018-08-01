package libin.general._09_sort;

/**
 * 插入排序之直接插入排序
 * @author baolibin
 */
public class _04_insertSort {
	public static void main(String[] args) {
		int[] tmpNum={54,23,8,87,56,21,34,17,6,23,4};
		insertSort insertSort = new insertSort(tmpNum);
		insertSort.insert_Sort();
		insertSort.fnPrint();
	}
}
class insertSort{
	private int[] tmpNum;
	public insertSort(int[] tmpNum){
		this.tmpNum=tmpNum;
	}
	/**
	 * 直接插入排序
	 */
	public void insert_Sort(){
		int tmp=0,j=0;
		for (int i = 1; i < tmpNum.length; i++) {
//			fnPrint();
			tmp=tmpNum[i];
			j=i;
			while (j>0&&tmpNum[j-1]>tmp) {
				tmpNum[j]=tmpNum[j-1];
				j--;
			}
			tmpNum[j]=tmp;
		}
	}
	/**
	 * 打印函数
	 */
	public void fnPrint(){
		for (int i = 0; i < tmpNum.length; i++) {
			if (i==tmpNum.length-1) {
				System.out.println(tmpNum[i]);
			}else {
				System.out.print(tmpNum[i]+"、");
			}
		}
	}
}
