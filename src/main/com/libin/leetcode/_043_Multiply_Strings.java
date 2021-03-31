package libin.leetcode;

class _43_Multiply_Strings {
    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        //solution43.multiply("121", "462");
        System.out.println(solution43.multiply("121", "462"));
    }
}
class Solution43 {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){ //正常相乘范围在(n1+n2-1,n1+n2)位之间，有一个乘数为0，直接返回0
            return "0";
        }
        int n1=num1.length();
        int n2=num2.length();
        char[] str1=num1.toCharArray();
        char[] str2=num2.toCharArray();
        int[] count=new int[n1+n2];
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                count[i+j]+=(str1[n1-i-1]-'0')*(str2[n2-j-1]-'0'); //同位置的先相加不进位
            }
        }
        int dividend=0; //除数
        int remain=0; //余数
        for(int k=0;k<count.length;k++){ //进位计算每一位
            remain=(count[k]+dividend)%10;
            dividend=(count[k]+dividend)/10;
            count[k]=remain;
        }
        StringBuilder sb=new StringBuilder(); //返回处理
        for(int i=count.length-1;i>=0;i--){
            if(i==count.length-1&&count[i]==0){
                continue;
            }
            sb.append(count[i]);
        }
        return sb.toString();
    }
}

