package libin.offer;

/**
 * 面试题9：
 * 题目2：跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class _09_2_frog {
    public static void main(String[] args){
        Solution09_2 solution09_2 = new Solution09_2();
        System.out.println(solution09_2.JumpFloor(5));
    }
}
class Solution09_2 {
    //跳台阶
    public int JumpFloor(int target) {
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
    //变态跳台阶
    int JumpFloorII(int target) {
        return (int) Math.pow(2,target-1);
    }
    //矩形覆盖
    public int RectCover(int target) {
        if(target==0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        return RectCover(target-1)+RectCover(target-2);
    }
}