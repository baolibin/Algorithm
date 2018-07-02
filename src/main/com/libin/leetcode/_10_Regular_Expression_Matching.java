package libin.leetcode;

/**
 * 10. Regular Expression Matching
 */
public class _10_Regular_Expression_Matching {
    public static void main(String[] args){

    }
}
class Solution10 {
    public boolean isMatch(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return getMatch(str.toCharArray(), pattern.toCharArray(), 0, 0);
    }

    public boolean getMatch(char[] str, char[] pattern, int index1, int index2) {
        if ((index1 == str.length && index2 == pattern.length)) {
            return true;
        }
        if (index1 != str.length && index2 == pattern.length) {
            return false;
        }
        if (index2 + 1 < pattern.length && pattern[index2 + 1] == '*') {
            if ((str.length != index1 && str[index1] == pattern[index2])
                    || ((str.length != index1 && pattern[index2] == '.'))) {
                return 	getMatch(str, pattern, index1, index2 + 2)
                        || getMatch(str, pattern, index1 + 1, index2 + 2)
                        || getMatch(str, pattern, index1 + 1, index2);
            } else {
                return getMatch(str, pattern, index1, index2 + 2);
            }
        }
        if (index1 < str.length && (str[index1] == pattern[index2] || (pattern[index2] == '.'))) {
            return getMatch(str, pattern, index1 + 1, index2 + 1);
        }
        return false;
    }
}

