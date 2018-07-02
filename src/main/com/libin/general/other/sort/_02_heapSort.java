package libin.general.other.sort;
/**
 * 选择排序之堆排序
 * @author baolibin
 * 
 * 参考网址：
 * http://www.cnblogs.com/jingmoxukong/p/4303826.html
 * http://www.cnblogs.com/mengdd/archive/2012/11/30/2796845.html
 */
public class _02_heapSort {
	public static void main(String[] args) {
		int[] tmpNum={32,5,76,9,23,43,12,4,56}; //声明的静态数组
		heapSort heapsort=new heapSort(tmpNum);
		heapsort.heapScheduler(tmpNum);
		heapsort.sortPtint();
	}
}
class heapSort{
	private int[] tmpNum;
	public heapSort(int[] tmpNum){
		this.tmpNum=tmpNum;
	}
	/**进行堆调整
	 * @param tmpNum 数组
	 * @param parent 选择开始调整的父节点存储的数组下标
	 * @param length 待排序数组的下标长度
	 */
	public void heapAdjust(int[] tmpNum,int parent,int length){
		//先保存当前父节点的值
		int tmp=tmpNum[parent];
		//选取当前父节点的左孩子
		int child=2*parent+1;
		while(child<length){
			//选取右孩子的条件：存在右节点且右节点的值大于左节点的值
			if (child+1<=length&&tmpNum[child]<tmpNum[child+1]) {
				child++;
			}
			//当父节点的值大于孩子节点的时候，直接结束
			if (tmp>=tmpNum[child]) {
				break;
			}
			tmpNum[parent]=tmpNum[child];
			
			//从孩子节点的左孩子开始继续往下筛选
			parent=child;
			child=2*child+1;
		}
		tmpNum[parent]=tmp;
	}
	
	public void heapScheduler(int[] tmpNum){
		//建堆
		//本程序建立大顶堆，保证所有的父节点都比孩子节点大
		for(int i=tmpNum.length/2;i>=0;i--){
			heapAdjust(tmpNum, i, tmpNum.length-1);
		}
		sortPtint();
		//进行排序
		int tmp=0;
		for (int i=tmpNum.length-1;i>0;i--) {
			//最后一个元素和第一个元素进行交换
			tmp=tmpNum[i];
			tmpNum[i]=tmpNum[0];
			tmpNum[0]=tmp;
			/**
			 按堆的定义将数组R[0..n]调整为堆（这个过程称为创建初始堆），交换R[0]和R[n]；
			然后，将R[0..n-1]调整为堆，交换R[0]和R[n-1]；
			如此反复，直到交换了R[0]和R[1]为止。
			 */
			heapAdjust(tmpNum, 0, i);
			System.out.println("第"+(tmpNum.length-i)+"趟");
		}
	}
	/**
	 * 打印堆的数据
	 * 用数组存储的堆
	 */
	public void sortPtint(){
		for(int i=0;i<tmpNum.length;i++){
			if(i==tmpNum.length-1){
				System.out.print(tmpNum[i]);
			}else {
				System.out.print(tmpNum[i]+"、");
			}
		}
	}
}

