package libin.leetcode_cn_algorithm._3_character;

/**
 * Copyright (c) 2021/4/1. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * Purpose :551. 学生出勤记录 I
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 * 示例 1:
 * 输入: "PPALLP"
 * 输出: True
 * 示例 2:
 * 输入: "PPALLL"
 * 输出: False
 */
public class _0551_checkRecord {
	public boolean checkRecord(String s) {
		char[] chars = s.toCharArray();
		int countA = 0;
		for (int i = 0; i < chars.length && countA < 2; i++) {
			if (chars[i] == 'A') countA++;
			if (i < chars.length - 2 && chars[i] == 'L' && chars[i + 1] == 'L' && chars[i + 2] == 'L')
				return false;
		}
		return countA < 2;
	}
}
