package libin.leetcode;
public class _28_Implement_strStr {
    public static void  main(String[] args){
        Solution28 solution28 = new Solution28();
        System.out.println(solution28.strStr("asdasd","asd"));
    }
}
class Solution28 {
    public int strStr(String haystack, String needle){
        int i=0,j=0;
        char[] matchingStr = haystack.toCharArray(); // 主串
        char[] patternStr = needle.toCharArray(); // 模式串
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
}