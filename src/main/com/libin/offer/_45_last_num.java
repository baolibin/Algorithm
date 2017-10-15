package libin.offer;

/**
 * 面试题45：圆圈中最后剩下的数字
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,
 * 继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class _45_last_num {
	public static void main(String[] args) {
		Solution45 solution45 = new Solution45();
		System.out.println(solution45.LastRemaining_Solution(2, 0));
	}
}
class Solution45 {
    public int LastRemaining_Solution(int n, int m) {
    	if(n==0||m==0){
    		return -1;
    	}
    	int[] child=new int[n];
    	int len=child.length; //设置循环变量长度
    	int result=0;
    	int index=0; //下标
    	while(len>0){
    		int num=0;  //每次寻找需要m次
    		while(num<m){
    			if(child[index]==1){
    				index++;
    			}else {
    				num++;
    				result=index;
    				index++;
				}
    			if(index==n){
    				index=0;
    			}
    		}
    		child[result]=1;
    		len--;
    	}
        return result;
    }
}
