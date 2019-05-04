package libin.leetcode;

/**
 * Copyright (c) 2019/04/22. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 判断一个字符串是否是另一个字符串乱序得到的。
 * 乱序指对字符串进行二叉树拆分，然后交换非叶子节点，重新组合生成的新字符串。
 * <p>
 * 使用一个3维数组res[len][len][len+1]，其中第一维为s1的起始索引，第二维为s2的起始索引，第三维为子串的长度。
 * res[i][j][k]表示的是以i和j分别为s1和s2起点的长度为k的字符串是不是互为scramble。
 * <p>
 * 我们首先是把当前s1[i...i+len-1]字符串劈一刀分成两部分，然后分两种情况：
 * 第一种是左边和s2[j...j+len-1]左边部分是不是scramble，以及右边和s2[j...j+len-1]右边部分是不是scramble
 * 第二种情况是左边和s2[j...j+len-1]右边部分是不是scramble，以及右边和s2[j...j+len-1]左边部分是不是scramble
 * 如果以上两种情况有一种成立，说明s1[i...i+len-1]和s2[j...j+len-1]是scramble的
 * <p>
 * 对于s1[i...i+len-1]我们有len-1种劈法，在这些劈法中只要有一种成立，那么两个串就是scramble的
 * <p>
 * 递推式是res[i][j][len] = || (res[i][j][k]&&res[i+k][j+k][len-k] || res[i][j+len-k][k]&&res[i+k][j][len-k])
 * 对于所有1<=k<len，也就是对于所有len-1种劈法的结果求或运算
 */
public class _87 {
    public boolean isScramble(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        boolean[][][] booleans = new boolean[l1][l2][l1 + 1];
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                booleans[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int len = 2; len <= l1; len++) { //子串长度
            for (int i = 0; i <= l1 - len; i++) { // 字符串s1的起始索引
                for (int j = 0; j <= l2 - len; j++) { // 字符串s2的起始索引
                    for (int k = 1; k < len; k++) {
                        booleans[i][j][len] |=
                                booleans[i][j][k] & booleans[i + k][j + k][len - k] ||
                                        booleans[i][j + len - k][k] & booleans[i + k][j][len - k];
                    }
                }
            }
        }
        return booleans[0][0][l1];
    }
}
