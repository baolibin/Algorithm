package libin.general._09_sort;
/**
 * 插入排序之希尔排序
 * @author baolibin
 */
public class _06_shellSort {
	public static void main(String[] args) {
		int[] tmpNum={54,23,8,87,56,21,34,17,6,23,4};
		shellSort shellSort = new shellSort(tmpNum);
		shellSort.shell_Sort();
		shellSort.fnPrint();
	}
}
class shellSort{
	private int[] tmpNum;
	public shellSort(int[] tmpNum){
		this.tmpNum=tmpNum;
	}
	/**
	 * 希尔排序
	 */
	public void shell_Sort(){
		int step=tmpNum.length/2;
		while (1<=step) {
			this.fnPrint();
			//遍历所有得的组
			for (int i = step; i < tmpNum.length; i++) {
				int j=i-step;
				//保存要插入的数据
				int tmp=tmpNum[i];
				while(j>=0&&tmp<tmpNum[j]){
					tmpNum[j+step]=tmpNum[j];
					j=j-step;
				}
				tmpNum[j+step]=tmp;
			}
			step=step/2;
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
