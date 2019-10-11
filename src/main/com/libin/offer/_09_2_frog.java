package libin.offer;

/**
 * 面试题9：
 * 题目2：跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class _09_2_frog {
    public static void main(String[] args) {
        Solution09_2 solution09_2 = new Solution09_2();
        System.out.println(solution09_2.JumpFloor(5));
    }
}

class Solution09_2 {
    //跳台阶
    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    //变态跳台阶
    int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }

    //矩形覆盖
    public int RectCover(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }

    /**
     * 斐波那契数列优化
     * 采用尾递归进行优化,尾递归就是把当前的运算结果放到参数里面传递给下层.
     */
    private int fibTailRecursion(int n, int first, int second) {
        if (n == 0) {
            return first;
        } else {
            return fibTailRecursion(n - 1, second, first + second);
        }
    }

    /**
     * 采用非递归方式求解
     */
    int fibForCycle(int n) {
        int first = 1;
        int second = 2;
        if (n == 1) {
            return first;
        }
        if (n == 2) {
            return second;
        }
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }
}
