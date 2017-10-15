package libin.offer;

/**
 * 面试题55：字符流中第一个不重复的字符
 * 题目描述
 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 输出描述:
 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class _55_first_num {
    public static void main(String[] args){
        Solution55 solution55 = new Solution55();
        solution55.Insert('g');
        solution55.Insert('o');
        solution55.Insert('o');
        solution55.Insert('g');
        solution55.Insert('l');
        solution55.Insert('e');
        System.out.println(solution55.FirstAppearingOnce());
    }
}
class Solution55 {
    //Insert one char from stringstream
    int index=0;  //所有出现一次字符顺序
    int[] ascll=new int[256]; //存一共256个ascll码字符
    public Solution55(){
        for(int i=0;i<256;i++){
            ascll[i]=-1;
        }
    }
    public void Insert(char ch) {
        if(ascll[ch]==-1){
            ascll[ch]=index;
            index++;
        }else if(ascll[ch]>-1){
            ascll[ch]=-2;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int resultNum=Integer.MAX_VALUE;
        int resultIndex=-3;
        for(int i=0;i<256;i++){
            if(ascll[i]==-2||ascll[i]==-1){
                continue;
            }
            if(resultNum>ascll[i]){
                resultNum=ascll[i];
                resultIndex=i;
            }
        }
        if(resultIndex==-3){
            return '#';
        }
        return (char)resultIndex;
    }
}