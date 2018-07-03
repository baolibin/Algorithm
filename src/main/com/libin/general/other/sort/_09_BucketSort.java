package libin.general.other.sort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
 * 桶排序：将N个数，分成m个桶，桶之间的元素递增，然后对桶内的元素进行排序，最后输出所有元素
 */
public class _09_BucketSort {
    int arraySize = 10;  //N：排序数字个数
    int bucketSize = 10; //M：桶数量
    //主方法
    public static void main(String[] args) {
        _09_BucketSort bs = new _09_BucketSort();
        int[] array = bs.getArray();
        bs.bucketSort(array);
    }
    //生成待排序数组
    public int[] getArray() {
        int[] arr = new int[arraySize];
        Random r = new Random();
        for (int i = 0; i < arraySize; i++) {
            arr[i] = r.nextInt(100000);
        }
        return arr;
    }
    //进行分桶排序
    public void bucketSort(int[] a) {
        List<Integer>[] bucket = new ArrayList[bucketSize];
        for (int i = 0; i < a.length; i++) {
            int temp = a[i] / 10000;
            if (bucket[temp] == null) {
                bucket[temp] = new ArrayList<Integer>();
            }
            bucket[temp].add(a[i]);
        }
        System.out.println("桶的个数为："+bucket.length);
        //输出每个桶的长度
        int index=1;
        for (List<Integer> li:bucket) {
            if(li!=null) {
                System.out.print("桶"+index+"="+li.size() + "、");
            }
            index++;
        }
        System.out.println();
        // 对各个桶内的list中的元素进行排序
        for (int j = 0; j < bucketSize; j++) {
            insertSort(bucket[j]);// 对桶内的元素进行排序
            printList(bucket[j]);// 输出桶中的元素
        }
    }
    //一次输出每个桶排好序的数
    public void printList(List<Integer> list) {
        if(list!=null) {
            while (list.size() > 0) {
                System.out.print(list.remove(0) + "\t");
            }
        }
    }
    //对每个桶内的数进行排序
    public void insertSort(List<Integer> list) {// 对每个list进行排序
        if(list!=null){
            Collections.sort(list);
        }
    }
}
