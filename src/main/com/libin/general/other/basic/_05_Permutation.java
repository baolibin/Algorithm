package libin.general.other.basic;
/**
 * 全排列
 * @author baolibin
 */
public class _05_Permutation {
	public static void main(String[] args) {
		//String str="abcde";
		String str1="ada";
		permutation permutation = new permutation(str1);
		permutation.countPermumation(permutation.str,permutation.str.length,0);
		permutation.allLen(); //打印全排列个数
		
		String str2="232";
		permutation permutation2 = new permutation(str2);
		permutation2.countPermumation_2(permutation2.str,permutation2.str.length,0);
		permutation2.allLen(); //打印全排列个数
	}
}
class permutation{
	char[] str;
	int count;
	public permutation(String str){
		this.str=str.toCharArray();
		count=0;
	}
	/**
	 * 求全排列函数
	 */
	public void countPermumation(char[] str,int length,int currentIndex){
		if(currentIndex==length-1){
			count++;
			print(str,length);
			return;
		}
		for (int i = currentIndex; i < length; i++) { //currentIndex左侧以及排列过
			if(repetition(str, currentIndex, i)){
				char tmp=str[currentIndex];//第currentIndex个元素与右侧任一元素交换
	            str[currentIndex]=str[i];
	            str[i]=tmp;
	            countPermumation(str,length,currentIndex+1);//第currentIndex个元素不断与currentIndex的右侧元素交换
	            str[i]=str[currentIndex];//第currentIndex个元素与右侧任一元素再换回来
	            str[currentIndex]=tmp;
			}
		}
	}
	/**
	 * 去掉重复元素交换
	 * @param str 字符数组
	 * @param currentIndex 当前元素下标
	 * @param slip 右侧待交换的元素下标
	 * @return
	 */
	public boolean repetition(char[] str,int currentIndex,int slip){
		while (currentIndex<slip) {  //扫描当前点与待交换点之间，待交换的是否有重复元素
			if(str[currentIndex]==str[slip]){ 
				return false;
			}
			currentIndex++;
		}
		return true;
	}
	/**
	 * 打印所有的结果
	 */
	public void print(char[] str,int length){
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]);
		}
		System.out.println("");
	}
	/**
	 * 打印全排列个数
	 */
	public void allLen(){
		System.out.println("全排列个数为："+count);
	}
	
	/**
	 * 空间换时间
	 * 全排序
	 */
	public void countPermumation_2(char[] str,int length,int currentIndex){
		if(currentIndex==length-1){
			count++;
			print(str,length);
			return;
		}
		int[] flag=new int[100];
		for (int i = 0; i < flag.length; i++) {
			flag[i]=0;
		}
		for (int i = currentIndex; i < length; i++) { //currentIndex左侧以及排列过
			if(flag[Integer.parseInt(String.valueOf(str[i]))]!=1){
				flag[Integer.parseInt(String.valueOf(str[i]))]=1;
				char tmp=str[currentIndex];//第currentIndex个元素与右侧任一元素交换
				str[currentIndex]=str[i];
				str[i]=tmp;
				countPermumation(str,length,currentIndex+1);//第currentIndex个元素不断与currentIndex的右侧元素交换
				str[i]=str[currentIndex];//第currentIndex个元素与右侧任一元素再换回来
				str[currentIndex]=tmp;
			}
		}
	}
}