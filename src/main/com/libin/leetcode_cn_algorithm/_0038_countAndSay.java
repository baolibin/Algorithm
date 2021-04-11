package libin.leetcode_cn_algorithm;

/**
 * Copyright (c) 2021/4/11. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 38. 外观数列
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
 */
public class _0038_countAndSay {
	/**
	 * 解题思路：
	 * 比较字符串的当前位 i 与上一位 i - 1 是否相等，StringBuffer对象sb表示描述结果，
	 * 以“区间”表示每一段由连续相同字符组成的字符串：
	 * 1、相等：计数器num加1。特殊情况：若已到达字符串最后一位，此时还需执行将num和当前字符加入res的操作。
	 * 2、不相等：说明上一段区间已遍历完成，需要把上一段区间的num和字符加入res。特殊情况：若已到达字符串最后一位，
	 */
	public String countAndSay(int n) {
		String res = "1";
		if (n == 1) return res;
		for (int i = 1; i < n; i++) {
			res = countAndSaySub(res);
		}
		return res;
	}

	String countAndSaySub(String res) {
		StringBuilder sb = new StringBuilder();
		int len = res.length();
		if (len == 1) {
			sb.append("1");
			sb.append(res);
			return sb.toString();
		}
		int count = 1;
		for (int i = 1; i < len; i++) {
			if (res.charAt(i) == res.charAt(i - 1)) {
				count++;
			} else {
				sb.append(count);
				sb.append(res.charAt(i - 1));
				count = 1;
			}
			if (i == len - 1) {
				sb.append(count);
				sb.append(res.charAt(i));
			}
		}
		return sb.toString();
	}
}
