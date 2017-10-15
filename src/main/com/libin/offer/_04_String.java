package libin.offer;

/**
 * 面试题4：替换字符
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class _04_String {
        public static void main(String[] args){
            Solution04 solution04 = new Solution04();
            StringBuffer sb=new StringBuffer();
            sb.append("we ");
            sb.append("are ");
            sb.append("happy");
            System.out.println(solution04.replaceSpace(sb));
        }
}
/**
 * 时间复杂度O(n)
 */
class Solution04 {
    public String replaceSpace(StringBuffer str) {
        char[] youStr=str.toString().toCharArray();
        int length=youStr.length;
        int difflen=0; //计算空格的个数
        for(int i=0;i<length;i++){
            if(youStr[i] == ' '){
                difflen++;
            }
        }
        int mylen=length+difflen*2;
        char[] myStr=new char[mylen];
        mylen--;
        for(int j=length-1;j>=0;j--){
            if(youStr[j]==' '){
                myStr[mylen--]='0';
                myStr[mylen--]='2';
                myStr[mylen--]='%';
            }else{
                myStr[mylen--]=youStr[j];
            }
        }
        return String.valueOf(myStr);
    }
}
