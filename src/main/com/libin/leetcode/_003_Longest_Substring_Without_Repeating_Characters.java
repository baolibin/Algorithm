package libin.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
https://leetcode.com/problems/longest-substring-without-repeating-characters/
3. Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.

Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Subscribe to see which companies asked this question
 */
public class _003_Longest_Substring_Without_Repeating_Characters {
	public static void main(String[] args) {
		Solution3 solution3 = new Solution3();
		String s="abcdaca";
		int len=solution3.lengthOfLongestSubstring(s);
		System.out.println(len);
	}
}
/**
 * 求最长无重复子串问题
 */
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
    	//len为最长无重复子串长度，left为当前子串左边位置(非最大)，cur为遍历字符串当前位置
    	int len=0,left=0,cur=0;
    	HashSet<Character> strs=new HashSet<Character>();
    	while (cur<s.length()) {
    		if(!strs.contains(s.charAt(cur))){
    			/**
    			 * 把遍历到的不重复的字符依次加入到hashset中。
    			 */
    			strs.add(s.charAt(cur++));
    			len=Math.max(len, strs.size());
    		}else{
    			/**
    			 * 若当前字符存在于hashset中的话，按原字符串出现依次删除hashset中重复的字符。
    			 * 比如：abcc
    			 * 若遍历到第四个c，hashset是存在c的，则依次删除a、b、c，再把第四个c加入到hashset中。
    			 */
    			strs.remove(s.charAt(left++));
    		}
		}
		return len;
    }
    /**
     * 解法2
     */
    public int lengthOfLongestSubstring1(String s) {
        int[] m = new int[256];
        Arrays.fill(m, -1);
        int res = 0, left = -1;
        for (int i = 0; i < s.length(); ++i) {
            left = Math.max(left, m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            res = Math.max(res, i - left);
        }
        return res;
    }
}






