package libin.offer;

import java.util.ArrayList;

/**
 * 面试题41-题目2：和为S的连续正数序列
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class _41_2_keepseried {
    public static void main(String[] args) {
        Solution41_2 solution41_2 = new Solution41_2();
        System.out.println(solution41_2.FindContinuousSequence(9));
    }
}

class Solution41_2 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        if (sum < 3) {
            return arrayLists;
        }
        ArrayList<Integer> tmpList = null;
        int head = 1;
        int tail = 2;
        int middle = (1 + sum) / 2;
        int curSum = head + tail;
        while (head < middle) {
            tmpList = new ArrayList<Integer>();
            if (curSum == sum) {
                for (int i = head; i <= tail; i++) {
                    tmpList.add(i);
                }
                arrayLists.add(tmpList);
            }
            while (curSum > sum && head < middle) {
                curSum -= head;
                head++;
                if (curSum == sum) {
                    for (int i = head; i <= tail; i++) {
                        tmpList.add(i);
                    }
                    arrayLists.add(tmpList);
                    break;
                }
            }
            tail++;
            curSum += tail;
        }
        return arrayLists;
    }
}
