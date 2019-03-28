package libin.leetcode;

import java.util.HashSet;

/**
 * Copyright (c) 2019/03/25. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 将句子转换成Goat Latin
 * 如果单词以元音开头(a,e,i,o,u)，则在单词后面加ma
 * 如果单词以辅音开头，则把第一个单词移至末尾，并加上ma
 * 根据单词在句子中的索引，后面加上若干个a
 */
public class _824_Goat_Latin {
    public static void main(String[] args) {
        String s = new _824_Goat_Latin().toGoatLatin("I speak Goat Latin");
        System.out.println(s);
    }

    public String toGoatLatin(String S) {
        String[] str = S.split(" ");
        HashSet<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int index = 1;
        for (int i = 0; i < str.length; i++) {
            char[] chars = str[i].toCharArray();
            if (set.contains(chars[0])) {
                str[i] = str[i] + "ma";
            } else {
                str[i] = str[i].substring(1, str[i].length()) + chars[0] + "ma";
            }
            for (int j = 0; j < index; j++) {
                str[i] = str[i] + 'a';
            }
            index += 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str[0]);
        for (int i = 1; i < str.length; i++) {
            sb.append(" ").append(str[i]);
        }
        return sb.toString();
    }
}
