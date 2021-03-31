package libin.leetcode;
/**
 Implement atoi to convert a string to an integer.
 Hint: Carefully consider all possible input cases.
 If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 */
class _8_String_to_Integer {
    public static void main(String[] agrs){
        Solution8 s8=new Solution8();
        //System.out.println(s8.myAtoi("-12+3BBB54"));
       // System.out.println(s8.myAtoi("+123BBB54"));
        //System.out.println(s8.myAtoi("2147483648"));
        System.out.println(s8.myAtoi("-1"));
        System.out.println(s8.myAtoi("2147483648"));
        //System.out.println(s8.myAtoi("    -00134"));
       // System.out.println(s8.myAtoi("+1"));
       // System.out.println(s8.myAtoi("-01324000"));//-1324000
        System.out.println(s8.myAtoi("-2147483649"));//-2147483648
        //System.out.println(Integer.MAX_VALUE);2147483647
        //System.out.println(Integer.MIN_VALUE);-2147483648
        //System.out.println('9'-'0');
    }
}
class Solution8 {
    public int myAtoi(String str) {
        String s=str.trim();
        int bingo=0;
        long output=0L;
        int len=s.length();
        if(s.equals("")||len==0){
            return 0;
        }
        char left='+';
        for(int i=0;i<len;i++){
            //出现多于两个符号的时候返回0
            if(s.charAt(i)=='-'||s.charAt(i)=='+'){
                if(bingo==1){
                    return 0;
                }
                left=s.charAt(i);
                bingo=1;
                continue;
            }
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                output=output*10+(s.charAt(i)-'0');
                if(left=='+'&& output>Integer.MAX_VALUE){
                    return 2147483647;
                }if(left=='-'&& -(output) <(Integer.MIN_VALUE)){
                    return -2147483648;
                }
            }else{
                break;
            }
        }
        //只有 + 或 - 号的时候
        if(output==0){
            return 0;
        }
        return left=='-'?-(int)output:(int)output;
    }
}