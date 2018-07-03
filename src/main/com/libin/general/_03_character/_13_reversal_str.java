package libin.general._03_character;

/**
 * Copyright (c) 2018/7/2. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose :原串翻转
 */

public class _13_reversal_str {
}
class Reverse {
    public String reverseString(String iniString) {
        if(iniString==null||iniString.length()==0){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=iniString.length()-1;i>=0;i--){
            sb.append(iniString.charAt(i));
        }
        return sb.toString();
    }
}