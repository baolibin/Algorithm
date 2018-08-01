package libin.general._09_sort;
/**
 * 交换排序之冒泡排序
 * @author baolibin
 */
public class _03_bubbleSort {
	public static void main(String[] args) {
		int[] tmpNum={54,23,8,87,56,21,34,17,6,23,4};
		bubbleSort bubbleSort = new bubbleSort(tmpNum);
		bubbleSort.bullble_Sort();
		bubbleSort.fnPrint();
	}
}
class bubbleSort{
	private int[] tmpNum;
	public bubbleSort(int[] tmpNum){
		this.tmpNum=tmpNum;
	}
	/**
	 * 冒泡排序函数
	 */
	public void bullble_Sort(){
		int tmp=0;
		for (int i = 0; i < tmpNum.length-1; i++) {
			for (int j = i+1; j < tmpNum.length; j++) {
				if(tmpNum[j]<tmpNum[i]){
					tmp=tmpNum[i];
					tmpNum[i]=tmpNum[j];
					tmpNum[j]=tmp;
				}
			}
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
