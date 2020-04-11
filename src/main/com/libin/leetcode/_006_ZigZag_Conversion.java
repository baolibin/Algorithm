package libin.leetcode;

/**
 * Created by Administrator on 2017/1/8.
 */
public class _6_ZigZag_Conversion {
    public static void main(String[] args){
        String str="PAYPALISHIRING";
        Solution6 sl6 = new Solution6();
        System.out.println(sl6.convert(str,3));
        System.out.println(sl6.convert(str,14));
        System.out.println(sl6.convert("",2));
    }
}
class Solution6{
    public String convert(String s, int numRows) {
        int len=s.length();
        StringBuffer sb=new StringBuffer();
        if (s==""||len==0||numRows<=0){
            return "";
        }
        if(numRows==1||numRows==len){
            return s;
        }
        //每个zigzag是2*numRows-2个字符就可以
        int zigzag=2*numRows-2;
        for (int i=0;i<numRows;i++){
            for (int j=i;j<len;j+=zigzag){
                sb.append(s.charAt(j));
                //求一个V字的同行另一半，j+zigzag-2*i
                if(i!=0&&i!=numRows-1&&j+zigzag-2*i<len){
                    sb.append(s.charAt(j+zigzag-2*i));
                }
            }
        }
        return sb.toString();
    }
}
