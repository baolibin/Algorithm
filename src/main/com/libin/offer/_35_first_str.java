package libin.offer;

import java.util.HashMap;

/**
 * 面试题35：第一个只出现一次的字符
 * 在一个字符串(1<=字符串长度<=10000，全部由大写字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class _35_first_str {
	public static void main(String[] args) {
		Solution35 solution35 = new Solution35();
		String ch="googgle";
		System.out.println(solution35.FirstNotRepeatingChar(ch));
	}
}
class Solution35 {
    public int FirstNotRepeatingChar(String str) {
    	char[] charArray = str.toCharArray();
    	HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
    	for(int i=0;i<charArray.length;i++){
    		if(hashMap.containsKey(charArray[i])){
    			int tmp=hashMap.get(charArray[i]);
    			hashMap.put(charArray[i], ++tmp);
    		}else{
    			hashMap.put(charArray[i], 1);
    		}
    	}
    	char tmp = 0;
    	for(int i=0;i<charArray.length;i++){
    		if(hashMap.get(charArray[i])==1){
    			tmp=charArray[i];
    			break;
    		}
    	}
        return str.indexOf(tmp);
    }
}

