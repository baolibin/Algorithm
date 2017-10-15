package libin.offer;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 面试题28：字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class _28_full_permutation {
    public static void main(String[] args){
        Solution28 solution28 = new Solution28();
        String str="abc";
        ArrayList<String> arrayList =solution28.Permutation(str);
        for(String s:arrayList){
            System.out.print(s+"、");
        }
    }
}
class Solution28 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if(str==null){
            return arrayList;
        }
        char[] chars = str.toCharArray();
        getFullPermutation(arrayList,chars,0);
        Collections.sort(arrayList);
        return arrayList;
    }
    public void getFullPermutation(ArrayList<String> arrayList,char[] chars,int currentIndex){
        if(currentIndex==chars.length-1){
            arrayList.add(String.valueOf(chars));
            return;
        }
        for(int i=currentIndex;i<chars.length;i++){
            if(repetition(chars, currentIndex, i)){
                char tmp=chars[currentIndex];//第currentIndex个元素与右侧任一元素交换
                chars[currentIndex]=chars[i];
                chars[i]=tmp;
                getFullPermutation(arrayList,chars,currentIndex+1);//第currentIndex个元素不断与currentIndex的右侧元素交换
                chars[i]=chars[currentIndex];//第currentIndex个元素与右侧任一元素再换回来
                chars[currentIndex]=tmp;
            }
        }
    }
    public boolean repetition(char[] str,int currentIndex,int slip){
        while (currentIndex<slip) {  //扫描当前点与待交换点之间，待交换的是否有重复元素
            if(str[currentIndex]==str[slip]){
                return false;
            }
            currentIndex++;
        }
        return true;
    }
}