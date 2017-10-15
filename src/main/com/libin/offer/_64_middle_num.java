package libin.offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 面试题64：数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class _64_middle_num {
}
class Solution64{
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public void Insert(Integer num) {
        arrayList.add(num);
    }

    public Double GetMedian() {
        Collections.sort(arrayList);
        int len=arrayList.size();
        if(len%2==0){
            return 1.0*(arrayList.get(len/2-1)+arrayList.get(len/2))/2;
        }
        return 1.0*arrayList.get(len/2);
    }
}