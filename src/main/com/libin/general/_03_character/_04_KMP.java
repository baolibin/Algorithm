package libin.general._03_character;
/**
 * KMP算法
 * @author baolibin
 * KMP算法时间复杂度 o(m+n)
 */
public class _04_KMP {
	public static void main(String[] args) {
		System.out.println("暴力求解：");
		String str1="asdasdhhasdasdasd";
		String str2="dhh";
		kmp kmps = new kmp(str1,str2);
		int kmpViolence = kmps.kmpViolence();
		System.out.println("子串第一个匹配职位下标为："+kmpViolence);
		
		System.out.println("\nKMP求解：");
		String str3="asdasdhhasdasdasd";
		String str4="dhh";
		kmp kmps2 = new kmp(str3,str4);
		kmps2.printMatch();
		kmps2.getNext();
		kmps2.printNext();
		int judgeKmp = kmps2.judgeKmp();
		System.out.println("\njudgeKmp="+judgeKmp);
	}
}
class kmp{
	private char[] matchingStr; //匹配串
	private char[] patternStr; //模式串
	private int[] next; //next数组
	public kmp(String matchingStr, String patternStr) {
		this.matchingStr = matchingStr.toCharArray();
		this.patternStr = patternStr.toCharArray();
		this.next=new int[matchingStr.length()];
	}
	/**
	 * 暴力求解(Brute Force)
	 * 时间复杂度：o(m*n)
	 * 空间复杂度：o(1)
	 * 子串匹配
	 */
	public int kmpViolence(){
		int i=0,j=0;
		int patternLen=patternStr.length;
		int matLen=matchingStr.length-patternLen;
		while (i<=matLen&&j<patternLen) {
			if(matchingStr[i+j]==patternStr[j]){ //匹配成功，匹配位置后移
				j++;
			}else { //匹配失败，模式串回溯到首位
				i++;
				j=0;
			}
		}
		if (j>=patternLen) {//模式串每一位均匹配到，返回匹配首位下标
			return i;
		}
		return -1;
	}
	/**
	 * KMP求解 
	 * 时间复杂度：o(m+n)
	 * 空间复杂度：o(m)
	 * 求next数组
	 * =======================================================
	 *     |K               j-1|j
	 * ||||||||||||||||||||||||||||||||
	 * | K |               | K |
	 * 
	 * 若p[k]=p[j],则 next[j+1]=next[j]+1;
	 * 
	 *               |K                       j-1|j
	 * ||||||||||||||||||||||||||||||||||||||||||||||
	 * |h |       |h |              |     K      |
	 * |    k        |
	 * 
	 * 若p[k]!=p[j],则h=next[K];若p[h]==p[j],则next[j+1]=h+1;
	 * =======================================================
	 */
	public void getNext(){
		int mLength=matchingStr.length;
		next[0]=-1;
		int pre=-1; //next[current-1]
		int current=0;
		while (current<mLength-1) { //pre表示前缀,current表示后缀
			if (pre==-1||matchingStr[current]==matchingStr[pre]) { //若p[k]=p[j],则 next[j+1]=next[j]+1;
				++pre;
				++current;
				next[current]=pre;
				/*
				 ---------------------------------------------------
				   优化部分：
				 next[j]=k,若p[j]==p[k],则next[j]可以直接赋值为next[j]==next[k]。
				 ---------------------------------------------------
				if (matchingStr[current]==matchingStr[pre]) {
					next[current]=next[pre];
				} else {
					next[current]=pre;
				}
				*/
			} else { //匹配失败时，继续递归计算前缀matchingStr[next(pre)]
				pre=next[pre]; //若p[k]!=p[j],则h=next[K];若p[h]==p[j],则next[j+1]=h+1;
			}
		}
	}
	/**
	 * 返回第一个匹配的下标
	 * 没有匹配成功返回-1
	 * @return
	 */
	public int judgeKmp(){
		int matchLen=matchingStr.length;
		int patternLen=patternStr.length;
		int startIndex=-1;
		int i=0,j=0;
		while (i<matchLen) {
			if (j==-1||matchingStr[i]==patternStr[j]) {
				++i;
				++j;
			}
			/**                   |i
			 * ||||||||||||||||||||||||||||||||||||     next
			 * 
			 * |   next[i]=k      |
			 * | k |          | k |i --> t[i]
			 * ||||||||||||||||||||||||||||||||||||     文本串text
			 *  
			 *   |q 
			 * | k |j --> p[j]
			 * ||||||||  模式串pattern
			 * 
			 * 若：t[i]!=p[j]
			 * 此时就需要滑动指针j到模式串指定位置开始匹配
			 * 因为next[i]=k,所以k==j(k为长度,j为下标值),在范围为k的文本串里继续寻求可滑动的最大长度,不断迭代next数组相应的值。
			 * 若有可滑动的值：
			 *    比如上图存在next[k]=q,则p[q]和t[i]进行比较；
			 * 若没有可滑动的值：
			 *    next[k]=0,则模式串从p[0]与t[i]开始比较;
			 */
			else { //滑动位置，从模式串的指定位置开始与文本串匹配
				/**
				 * t[i]!=t[k]
				 * 为啥不是j=next[i],因为这就是j==next[i]的比较结果
				 * 在范围K里面继续寻找可以滑动的位置,k==j,所以next[j]就是next[k];
				 */
				j=next[j];
			}
			if (j==patternLen) {
				startIndex=i-patternLen;
				break;
			}
		}
		return startIndex;
	}
	/**
	 * 打印匹配字符串
	 */
	public void printMatch(){
		System.out.print("匹配字符串为：    ");
		for (int i = 0; i < matchingStr.length; i++) {
			System.out.print(matchingStr[i]+"、");
		}
		System.out.print("\n");
	}
	/**
	 * 打印next数组
	 */
	public void printNext(){
		System.out.print("next数组为： ");
		for (int i = 0; i < next.length; i++) {
			System.out.print(next[i]+"、");
		}
	}
}
