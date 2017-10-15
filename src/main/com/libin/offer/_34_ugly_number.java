package libin.offer;
/**
 * 面试题34：丑数
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class _34_ugly_number {
	public static void main(String[] args) {
		Solution34 solution34 = new Solution34();
		System.out.println(solution34.GetUglyNumber_Solution(12));
	}
}
class Solution34 {
    public int GetUglyNumber_Solution(int index) {
    	if(index<=0){
    		return 0;
    	}
    	int[] result=new int[index];
    	result[0]=1; //第一个丑数为1
    	int currentIndex=1;
    	int cur2=0;
    	int cur3=0;
    	int cur5=0;
    	while(currentIndex<index){
    		int min=getMin(result[cur2]*2, result[cur3]*3, result[cur5]*5);
    		result[currentIndex]=min;
    		while(result[cur2]*2<=min){
    			cur2++;
    		}
    		while(result[cur3]*3<=min){
    			cur3++;
    		}
    		while(result[cur5]*5<=min){
    			cur5++;
    		}
    		currentIndex++;
    	}
        return result[currentIndex-1];
    }
    public int getMin(int num2,int num3,int num5){
    	int min=(num2<num3)?num2:num3;
    	min=(min<num5)?min:num5;
    	return min;
    }
}
