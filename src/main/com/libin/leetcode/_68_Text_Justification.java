package libin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _68_Text_Justification {
    public static void main(String[] args) {
        //String[] str={"This", "is", "an", "example", "of", "text", "justification."};
        //String str2="";
        //String[] str3={"Listen","to","many,","speak","to","a","few."};
        //String[] str3={"Listen","to"};
        //String[] str3={"a","b","c","d","e"};
        //String[] str3={"What","must","be","shall","be."};
        String[] str3={"a"};
        Solution68 solution68 = new Solution68();
        //List<String> list=solution68.fullJustify(str, 16);
        List<String> list2=solution68.fullJustify(str3, 2);
        for (String string : list2) {
            System.out.println(string);
        }
    }
}
class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> li=new ArrayList<String>();
        int currentLen=0;; //当前行单词的总长度
        StringBuilder sb=new StringBuilder();
        int startIndex=0;	//行首第一个单词
        int spaceNum=0; //单词数
        int space=0;
        int spaceAveLen=1; //平均间隔长度默认为1
        int spaceLen=0; //余数间隔
        int i=0;
        for(i=0;i<words.length;i++){
            if(spaceNum==0||spaceNum==1){
                space=0;
            }else{
                space=spaceNum-1;
            }
            if(currentLen+space+words[i].length()<maxWidth||spaceNum==0){
                currentLen+=words[i].length();
                spaceNum++;
            }else{
                if(spaceNum>1){ //2个单词以上才会有间隔
                    spaceAveLen=(maxWidth-currentLen)/(spaceNum-1); //间隔平均长度
                    spaceLen=(maxWidth-currentLen)%(spaceNum-1);	//间隔余数长度
                }
                //满足一行条件
                for(int j=startIndex;j<i;j++){ //处理添加一行
                    sb.append(words[j]);
                    if(j<i-1){  //减一表示最后一个单词后不加空格
                        for(int k=0;k<spaceAveLen;k++){
                            sb.append(" ");
                        }
                        if(spaceLen>0){
                            sb.append(" ");
                            spaceLen--;
                        }
                    }
                }
                //处理一行只有一个单词的情况
                if(spaceNum==1){
                    for(int k=words[startIndex].length();k<maxWidth;k++){
                        sb.append(" ");
                    }
                }
                //添加 spaceNum>=1
                li.add(sb.toString());
                sb.delete(0,sb.length());
                //一行处理完毕，更新参数
                currentLen=words[i].length();
                startIndex=i;
                spaceNum=1;
                spaceAveLen=1;
                spaceLen=0;
            }
        }
        //最后一行 比较特殊  每个单词之间一个空格，之后全部空格
        int flag=0;
        if(currentLen>0){
            for(int q=startIndex;q<i;q++){
                sb.append(words[q]);
                if(i-q>1){  //一行多于一个单词时候
                    sb.append(" ");
                    flag++;
                }
            }
        }
        //单词之后全部填满空格
        for(int k=currentLen;k<maxWidth-flag;k++){
            sb.append(" ");
        }
        li.add(sb.toString());
        return li;
    }
}
