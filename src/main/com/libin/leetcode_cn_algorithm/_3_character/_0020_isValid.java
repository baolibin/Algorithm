package libin.leetcode_cn_algorithm._3_character;

import java.util.HashMap;
import java.util.Stack;

/**
 * Copyright (c) 2021/4/10. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 */
public class _0020_isValid {
	public boolean isValid(String s) {
		HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
		hashMap.put(')', '(');
		hashMap.put('}', '{');
		hashMap.put(']', '[');
		Stack<Character> stack = new Stack<Character>();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (hashMap.containsKey(chars[i])) {
				char c = stack.isEmpty() ? '#' : stack.pop();
				if (c != hashMap.get(chars[i])) {
					return false;
				}
			} else {
				stack.push(chars[i]);
			}
		}
		return stack.size() == 0;
	}
}
