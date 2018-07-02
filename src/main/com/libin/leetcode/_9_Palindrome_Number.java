package libin.leetcode;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class _9_Palindrome_Number {
    public static void main(String[] agrs){
        Solution9 solution9 = new Solution9();
        System.out.println(solution9.isPalindrome(12321));
        System.out.println(solution9.isPalindrome(-2147483648));
    }
}
class Solution9 {
    public boolean isPalindrome(int x) {
        int left,right;
        int len=1,j=x;
        if(x<0){
            return false;
        }
        while(j/10!=0){
            len*=10;
            j/=10;
        }
        while(x!=0){
            left=x/len;
            right=x%10;
            if(left!=right){
                return false;
            }
            x=(x%len)/10;
            len/=100;
        }
        return true;
    }
}