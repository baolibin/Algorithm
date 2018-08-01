package libin.general._09_sort;
/**
 * 基数排序
 * @author baolibin
 */
public class _08_radixSort {
	public static void main(String[] args) {
		int[] tmpNum={54,23,8,187,56,21,341,17,6,23,4,88,33,40,39,73,15};
		radixSort radixsort = new radixSort(tmpNum);
		radixsort.radix_Sort(tmpNum,3); //开始基数排序
		radixsort.fnPrint();
	}
}
/**
 * 
 * @author Administrator
 *
 */
class radixSort{
	private int[] tmpNum; //带排序的数组
	private int radix=10; //指0~9,像邻接链表的左侧竖着显示的数组
	private int[] bucket_offset_right;//一共10位，每个值代表着，在bucket数组，的对应桶，的末尾的下标。 以及每个桶存储的个数
	private int[] bucket; ////原本邻接链表的结构用数组进行存储，每个桶在对应范围下标进行存储。
	public radixSort(int[] tmpNum) {
		this.tmpNum=tmpNum;
		bucket_offset_right=new int[radix]; //代表着每个桶的个数以及在bucket桶数组中的存储下标
		bucket=new int[tmpNum.length];
	}
    /**
     *  基数排序部分
     * @param tmpNum 待排序的数组
     * @param low_index 数组的开始下标
     * @param high_index 数组的结尾下标
     * @param max_Num_length 数组中最大元素的位置
     */
    public void radix_Sort(int[] tmpNum,int max_length){
    	for (int i = 1; i <= max_length; i++) {
			for (int j = 0; j < radix; j++) { //各个桶存储的个数置为0
				bucket_offset_right[j]=0;
			}
			int countNum=0;
			for (int j = 0; j < tmpNum.length; j++) {  //统计每个桶要装入的数据的个数
				countNum=tmpNum[j]/((int) Math.pow(10, i-1))%10;
//				System.out.println("countNum="+countNum);
				bucket_offset_right[countNum]++;
			}
			for (int j = 1; j < radix; j++) { //存储每个桶截止本桶一共装的个数，存的值对应桶数组下标，方便进行每个桶快速定位进行存储
				bucket_offset_right[j]=bucket_offset_right[j]+bucket_offset_right[j-1];
			}
			for (int j = tmpNum.length-1; j >=0; j--) { //将数据依次存入桶中
				countNum=tmpNum[j]/((int) Math.pow(10, i-1))%10;
				bucket[bucket_offset_right[countNum]-1]=tmpNum[j];  //将数据存储到对应桶的指定数组位置，倒着进行存储
				bucket_offset_right[countNum]--; //对应桶存储位置指针，从桶的末尾往前移一位
			}
			for (int j = 0; j < tmpNum.length; j++) {
				tmpNum[j]=bucket[j];
			}
//			fnPrint();
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
