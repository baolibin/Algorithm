package libin.leetcode;

/**
 Problem:
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 Example:
 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example:
 Input: "cbbd"
 Output: "bb"
 */
public class _5_Longest_Palindromic_Substring {
    public static void main(String[] args) {
        Solution5 sl = new Solution5();
        String str1="sdsdaadhgh";
        String str2="asdghgasd";
        String str3="";
        System.out.println(sl.longestPalindrome(str3));
    }
}
class Solution5 {
    public String longestPalindrome(String s) {
        int len=s.length();
        if(len==0){
            return "";
        }
        String str1,str2;
        String outStr=s.substring(0,1);
        for (int i=0;i<len-1;i++){
            str1=getLongStr(s,i,i);
            if(str1.length()>outStr.length()){
                outStr=str1;
            }
            str2=getLongStr(s,i,i+1);
            if(str2.length()>outStr.length()){
                outStr=str2;
            }
        }
        return outStr;
    }
    public String getLongStr(String str,int start,int end){
        int l=str.length();
        while (start>=0&&end<l&&str.charAt(start)==str.charAt(end)) {
            start--;
            end++;
        }
        return str.substring(++start,end);
    }
}