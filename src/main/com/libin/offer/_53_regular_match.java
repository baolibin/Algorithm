package libin.offer;

/**
 * 面试题53：正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class _53_regular_match {
	public static void main(String[] args) {
		Solution53 solution53 = new Solution53();
		System.out.println(solution53.match("".toCharArray(), ".*".toCharArray()));
	}
}

class Solution53 {
	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		}
		return getMatch(str, pattern, 0, 0);
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