package libin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class _49_Group_Anagrams {
    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        String[] strings={"eat","tea","tan", "ate", "nat", "bat"};
        List<List<String>> li=solution49.groupAnagrams(strings);
        for (List<String> list : li) {
            for (String string : list) {
                System.out.print(string+"\t");
            }
            System.out.println();
        }
    }
}
class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<List<String>>();
        HashMap<String, List<String>> hMap=new HashMap<String, List<String>>();
        String tmpStr="";
        //添加到辅助结构 hashMap<String,List<String>>
        for(int i=0;i<strs.length;i++){
            char[] tmp=strs[i].toCharArray();
            Arrays.sort(tmp);
            tmpStr=new String(tmp);
            if(hMap.containsKey(tmpStr)){
                hMap.get(tmpStr).add(strs[i]);
            }else{
                List<String> ls=new ArrayList<String>();
                ls.add(strs[i]);
                hMap.put(tmpStr, ls);
            }
        }
        for (Map.Entry<String, List<String>> list : hMap.entrySet()) {
            List<String> list2=list.getValue();
            Collections.sort(list2);
            lists.add(list2);
        }
        return lists;
    }
}
