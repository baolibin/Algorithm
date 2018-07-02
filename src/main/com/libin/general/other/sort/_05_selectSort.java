package libin.general.other.sort;
/**
 * 选择排序之简单选择排序
 * @author baolibin
 * 参考网址：http://www.cnblogs.com/jingmoxukong/p/4303289.html
 */
public class _05_selectSort {
	public static void main(String[] args) {
		int[] tmpNum={54,23,8,87,56,21,34,17,6,23,4};
		selectSort selectSort = new selectSort(tmpNum);
		selectSort.select_Sort();
		selectSort.fnPrint();
	}
}
class selectSort{
	private int[] tmpNum;
	public selectSort(int[] tmpNum){
		this.tmpNum=tmpNum;
	}
	/**
	 * 简单选择排序
	 */
	public void select_Sort(){
		int tmp=0,index=0;
		for (int i = 0; i < tmpNum.length-1; i++) {
			index=i;
			for (int j = i+1; j < tmpNum.length; j++) {
				if(tmpNum[index]>tmpNum[j]){
					index=j;
				}
			}
			tmp=tmpNum[i];
			tmpNum[i]=tmpNum[index];
			tmpNum[index]=tmp;
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

