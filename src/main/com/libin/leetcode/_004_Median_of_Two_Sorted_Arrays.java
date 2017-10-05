package libin.leetcode;
/**
4. Median of Two Sorted Arrays
https://leetcode.com/problems/median-of-two-sorted-arrays/

There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */
public class _004_Median_of_Two_Sorted_Arrays {
	public static void main(String[] args) {
		int[] nums1 = {1};
		int[] nums2 = {2,3, 4,5,6};
		Solution4 solution4 = new Solution4();
		double d=solution4.findMedianSortedArrays(nums1, nums2);
		System.out.println(d);
	}
}
/**
 *时间复杂度为：O(log (m+n)),采用二分查找法
 *如果使用归并排序的时间复杂度为O(m*n)
 *
 *两个有序数组m和n
 *如果m的中位数小于n的中位数，那么两个有序数组的中位数位于m的右区间和n的左区间中;
 *如果m的中位数大于n的中位数，那么两个有序数组的中位数位于m的左区间和m的右区间中;
 *递归分治不断缩小m和n的区间来找到整体的中位数。
 */
class Solution4 {
	/**
     * @param nums1  第一个有序数组
     * @param nums2 第二个有序数组
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenM=nums1.length;
        int lenN=nums2.length;
        if(lenM==0){
            if(lenN%2!=0){
                return 1.0*nums2[lenN/2];
            }else{
                return (nums2[lenN/2]+nums2[lenN/2-1])/2.0;
            }
        }
        if(lenN==0){
            if(lenM%2!=0){
                return 1.0*nums1[lenM/2];
            }else{
                return (nums1[lenM/2]+nums1[lenM/2-1])/2.0;
            }
        }
        int left=(lenM+lenN+1)/2;
        int right=(lenM+lenN+2)/2;
        return (findK(nums1,0,nums2,0,left)+findK(nums1,0,nums2,0,right))/2.0;
    }
    /**
     * @param numM  第一个有序数组
     * @param m    所计算区间的首下标
     * @param numN  第二个有序数组
     * @param n    所计算区间的首下标
     * @param k    整体数组的中位数在第K位
     * @return
     */
    double findK(int[] numM,int m,int[] numN,int n,int k){
        if(m>numM.length-1){ //中位数不在第一个数组里
            return numN[n+k-1];
        }
        if(n>numN.length-1){ //中位数不在第二个数组里
            return numM[m+k-1];
        }
        if(k==1){ //二分查找到头的时候
            return numM[m]<numN[n]?numM[m]:numN[n];
        }
        int midM=Integer.MAX_VALUE; //第一个有序数组经过二分查找的新中位数
        int midN=Integer.MAX_VALUE; //第二个有序数组经过二分查找的新中位数
        if(m+k/2-1<numM.length){
            midM=numM[m+k/2-1];
        }
        if(n+k/2-1<numN.length){
            midN=numN[n+k/2-1];
        }
        if(midM<midN){ 
            return findK(numM,m+k/2,numN,n,k-k/2);
        }
        return findK(numM,m,numN,n+k/2,k-k/2);
    }
}




