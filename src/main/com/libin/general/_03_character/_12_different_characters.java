package libin.general._03_character;

/**
 * Copyright (c) 2018/7/2. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose :
 * 确定字符互异
 * 题目描述
 请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
 给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。保证字符串中的字符为ASCII字符。
 字符串的长度小于等于3000。
 测试样例：
 "aeiou"
 返回：True
 "BarackObama"
 返回：False
 */

public class _12_different_characters {
    public static void main(String[] args){
        Different1 different1 = new Different1();
        System.out.println(different1.checkDifferent2("acbdbesy"));
    }
}
class Different1 {
    public boolean checkDifferent(String iniString) {
        if(iniString.length()>256){
            return false;
        }
        boolean[] char_set=new boolean[256];
        for(int i=0;i<iniString.length();i++){
            int val=iniString.charAt(i);
            if(char_set[val]){
                return false;
            }
            char_set[val]=true;
        }
        return true;
    }
    public boolean checkDifferent2(String iniString) {
        if(iniString.length()>256){
            return false;
        }
        for(int i=0;i<iniString.length()-1;i++){
            for(int j=i+1;j<iniString.length();j++){
                if(iniString.charAt(i) == iniString.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
