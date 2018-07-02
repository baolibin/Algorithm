package libin.general.other.basic;
/**
 * 二分查找
 * @author baolibin
 */
public class _01_binarySearch {
	public static void main(String[] args) {
		int[] tmpNum={2,4,7,9,12,18,25,28,67,89,345,625};
		binarySearch binarysearch = new binarySearch(tmpNum);
		int reault;
		reault=binarysearch.binary_sort(18);
		if(reault==-1){
			System.out.println("非递归未找到！");
		}else {
			System.out.println("非递归找到了！在第"+reault+"位");
		}
		
		reault=binarysearch.binary_sort(18,0,tmpNum.length-1);
		if(binarysearch.binary_sort(18)==-1){
			System.out.println("非递归未找到！");
		}else {
			System.out.println("非递归找到了！在第"+reault+"位");
		}
	}
}
class binarySearch{
	private int[] tmpNum;
	public binarySearch(int[] tmpNum){
		this.tmpNum=tmpNum;
	}
	/**
	 * 二分查找--非递归
	 */
	public int binary_sort(int search){
		int low=0;
		int high=tmpNum.length-1;
		while (low<=high) {
			int middle=(low+high)/2;
			if (tmpNum[middle]==search) {
				return middle;
			}else if (tmpNum[middle]<search) {
				high=middle-1;
			}else {
				low=middle+1;
			}
		}
		return -1;
	}
	/**
	 * 二分查找--递归
	 */
	public int binary_sort(int search,int low,int high){
		int middle=(low+high)/2;
		if(low>high){
			return -1;
		}
		if (tmpNum[middle]<search) {
			return binary_sort(search,low,middle-1);
		}else if (tmpNum[middle]>search){
			return binary_sort(search,middle+1,high);
		}else{
			return middle;
		}
	}
}
