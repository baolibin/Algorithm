package libin.leetcode;
public class _38_Count_and_Say {
    public static void main(String[] args) {
        Solution38 solution10 = new Solution38();
        System.out.println(solution10.countAndSay(1));
        System.out.println(solution10.countAndSay(2));
        System.out.println(solution10.countAndSay(3));
        System.out.println(solution10.countAndSay(4));
        System.out.println(solution10.countAndSay(5));
    }
}

class Solution38 {
    public String countAndSay(int n) {
        int count=1;
        StringBuilder sb=new StringBuilder("1");
        if(n==1){
            return "1";
        }
        char[] str;
        for(int i=1;i<n;i++){
            str=sb.toString().toCharArray();
            sb.delete(0, sb.length());
            for(int j=0;j<str.length;j++){
                if(j<str.length-1&&str[j]==str[j+1]){
                    count++;
                }else {
                    sb.append(String.valueOf(count)+String.valueOf(str[j]));
                    count=1;
                }
            }
        }
        return sb.toString();
    }
}