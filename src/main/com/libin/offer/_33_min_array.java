package libin.offer;

/**
 * 面试题33：把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class _33_min_array {
	public static void main(String[] args) {
		Solution33 solution33 = new Solution33();
		int[] numbers={3,32,321};
		System.out.println(solution33.PrintMinNumber(numbers));
	}
}
class Solution33 {
    public String PrintMinNumber(int [] numbers) {
    	StringBuilder sb1=new StringBuilder("");
    	if(numbers.length==0){
    		return sb1.toString();
    	}
    	StringBuilder sb2=new StringBuilder("");
    	StringBuilder result=new StringBuilder();
    	for(int i=0;i<numbers.length-1;i++){
    		for(int j=i+1;j<numbers.length;j++){
    			sb1.append(numbers[i]);
    			sb1.append(numbers[j]);
    			sb2.append(numbers[j]);
    			sb2.append(numbers[i]);
    			if(sb1.toString().compareTo(sb2.toString())>0){
    				int tmp=numbers[i];
    				numbers[i]=numbers[j];
    				numbers[j]=tmp;
    			}
    			sb1.delete(0, sb1.length());
    			sb2.delete(0, sb2.length());
    		}
    	}
    	for(int k=0;k<numbers.length;k++){
    		result.append(numbers[k]);
    	}
    	return result.toString();
    }
}
