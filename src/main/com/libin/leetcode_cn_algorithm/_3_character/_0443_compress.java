package libin.leetcode_cn_algorithm._3_character;

/**
 * Copyright (c) 2021/4/10. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 443. 压缩字符串
 * 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 * 示例 1：
 * 输入：
 * ["a","a","b","b","c","c","c"]
 * 输出：
 * 返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
 * 说明：
 * "aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
 * 示例 2：
 * 输入：
 * ["a"]
 * 输出：
 * 返回 1 ，输入数组的前 1 个字符应该是：["a"]
 * 解释：
 * 没有任何字符串被替代。
 * 示例 3：
 * 输入：
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：
 * 返回 4 ，输入数组的前4个字符应该是：["a","b","1","2"]。
 * 解释：
 * 由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
 * 注意每个数字在数组中都有它自己的位置。
 */
public class _0443_compress {
	/**
	 * 基本原理：
	 * 我们使用两个指针 read 和 write 分别标记读和写的位置。读写操作均从左到右进行：读入连续的一串字符，然后将压缩版写到数组中。最终，write 将指向输出答案的结尾。
	 * 保留指针 anchor，指向当前读到连续字符串的起始位置。
	 * 从左到右进行读取。当读到最后一个字符，或者下一个下一个字符与当前不同时，则到达连续区块的结尾。
	 * 当我们到达连续区块的结尾时，就从 write 写入压缩的结果。chars[anchor] 为字符，read - anchor + 1 （若大于 1）为长度。
	 */
	public int compress(char[] chars) {
		int write = 0, anchor = 0;
		for (int read = 0; read < chars.length; read++) {
			if (read + 1 == chars.length || chars[read] != chars[read + 1]) {
				chars[write++] = chars[anchor];
				if (read > anchor) { // 不加这个判断，["a"]会报错。
					for (char c : ("" + (read - anchor + 1)).toCharArray()) {
						chars[write++] = c;
					}
				}
				anchor = read + 1;
			}
		}
		return write;
	}
}
