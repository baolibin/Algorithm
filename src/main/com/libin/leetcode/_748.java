package libin.leetcode;

/**
 * Copyright (c) 2019/04/02. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose :
 */
public class _748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        char[] chars = licensePlate.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar >= 'a' && aChar <= 'z')
                sb.append(aChar);
        }
        System.out.println(sb.toString());
        int index = 0;
        int minLen = Integer.MAX_VALUE;
        char[] charArray = sb.toString().toCharArray();
        for (int j = 0; j < words.length; j++) {
            String tmp = words[j].toLowerCase();
            int tmpLen = tmp.length();
            int k = 0;
            for (k = 0; k < charArray.length; k++) {
                if (tmp.contains(String.valueOf(charArray[k]))) {
                    tmp = tmp.replaceFirst(String.valueOf(charArray[k]), "");
                    System.out.println(tmp);
                } else break;
            }
            if (k == charArray.length && minLen > tmpLen) {
                minLen = tmpLen;
                index = j;
            }
        }
        return words[index];
    }
}
