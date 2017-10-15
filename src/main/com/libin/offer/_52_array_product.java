package libin.offer;
/**
 * 面试题52：构建成绩数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class _52_array_product {
	public static void main(String[] args) {
		Solution52 solution52 = new Solution52();
		int[] A={1,2,3,4,5};
		int[] multiply = solution52.multiply(A);
		for(Integer spl:multiply){
			System.out.print(spl+"、");
		}
	}
}
class Solution52 {
    public int[] multiply(int[] A) {
    	int[] B=new int[A.length];
    	for(int i=0;i<A.length;i++){
    		int left=1;
    		int right=1;
    		if(i-1>0){
    			left=getFirstElement(A,i-1);
    		}
    		if(i+1<A.length){
    			right=getLastElement(A,i+1);
    		}
    		B[i]=left*right;
    	}
    	return B;
    }
    public int getFirstElement(int[] A,int index){
    	if(index==0){
    		return A[index];
    	}
    	return getFirstElement(A,index-1)*A[index];
    }
    public int getLastElement(int[] A,int index){
    	if(index==A.length-1){
    		return A[index];
    	}
    	return getLastElement(A,index+1)*A[index];
    }
}

