package libin.general._07_dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2017/1/1. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 最长递增子序列(Longest Increasing Subsequence)
 */
public class _02_LIS {
	public static void main(String[] args) {
		System.out.println("测试一：所有递增序列遍历：");
		int[] tmpNum={23,9,15,40,7,41,3,1,5};
		lcs lcs = new lcs(tmpNum);
		lcs.countLIS();
		lcs.printAll(); //输出结果
		
		System.out.println("\n\n测试二：所有递增序列遍历：");
		int[] tmpNum2={123,23,345,45,678,78,1,2,3};
		lcs lcs2 = new lcs(tmpNum2);
		lcs2.countLIS();
		lcs2.printAll(); //输出结果
		
		System.out.println("\n\n测试三：所有递增序列遍历：");
		int[] tmpNum3={123,23,345,45,678,78,1,2,3,89};
		lcs lcs3 = new lcs(tmpNum3);
		lcs3.countLIS();
		lcs3.printAll(); //输出结果
	}
}

class lcs{
	private int[] tmpNum; //数组
	private int[] lcsNum; //存储所有的递增序列
	private int[] selectNum; //存储递增序列下标，   当前某元素存储的上前一个元素的下标值，遍历会用
	private int max; //存储最长递增序列的长度 maxlength
	private int maxIndex; //存储最长递增子序列的下标  遍历所有序列用不到这个变量，遍历其中一个可以用这个，没太多卵用
	private List<Integer> list;
	/**
	 * 构造方法
	 * @param tmpNum 待操作的数组
	 * @param //lcsNum LIS数组存储当前每个点的最长递增序列长度
	 * @param //selectNum 存储当前元素递增序列的上一个元素下标
	 * @param //max 最长递增序列的长度
	 */
	public lcs(int[] tmpNum) {
		this.tmpNum = tmpNum;
		lcsNum=new int[tmpNum.length];
		selectNum=new int[tmpNum.length];
		for (int i = 0; i < tmpNum.length; i++) {
			lcsNum[i]=1;
			selectNum[i]=-1;
		}
		this.max = 0;
		maxIndex=0;
		list=new ArrayList<Integer>();
	}
	/**
	 * 计算最长递增子序列
	 */
	public void countLIS(){
		for(int i=1;i<tmpNum.length;i++){
			for (int j = 0; j < i; j++) {  //遍历当前i节点 之前的节点
				if (tmpNum[j]<=tmpNum[i]) {    //把当前节点的，之前所有小于当前节点的元素，的最长递增长度，赋值给当前元素
					if (lcsNum[i]<lcsNum[j]+1) { //当前节点的递增子序列长度+1
						lcsNum[i]=lcsNum[j]+1;
						selectNum[i]=j; //当前几点的递增子序列的上一个节点是j
					}
				}
			}
			if (max<lcsNum[i]) { 
				max=lcsNum[i]; //更新整个数组最长递增子序列的最大值
				maxIndex=i; //最长递增子序列的结尾下标值
			}
		}
	}
	/**
	 * 打印最长递增子序列,只会打印其中一个
	 *  //@param selectNum
	 * //@param maxIndex
	 */
	public void print(){
		System.out.print("原数组为：");
		for (int i = 0; i < tmpNum.length; i++) {
			System.out.print(tmpNum[i]+"、");
		}
		System.out.print("\n最长递增子序列的长度为："+max);
		int current=maxIndex;
		while (current>=0) {
			list.add(tmpNum[current]);
			current=selectNum[current];
		}
		System.out.print("\n最长递增子序列之一为：");
		for (int i = list.size()-1; i>=0; i--) {
			System.out.print(list.get(i)+"、");
		}
		System.out.print("\nLIS数组为：");
		for (int i = 0; i < lcsNum.length; i++) {
			System.out.print(lcsNum[i]+"、");
		}
	}
	/**
	 * 打印所有的最长递增子序列
	 */
	public void printAll(){
		System.out.print("原数组为：");
		for (int i = 0; i < tmpNum.length; i++) {
			System.out.print(tmpNum[i]+"、");
		}
		System.out.print("\nLIS数组为：");
		for (int k = 0; k < lcsNum.length; k++) {
			System.out.print(lcsNum[k]+"、");
		}
		System.out.print("\n最长递增子序列的长度为："+max);
		for (int i = lcsNum.length-1; i >=0; i--) {  //从selectNum后开始，selectNum数组所有等于最长序列长度的都遍历
			if(lcsNum[i]==max){  //进行一次最长递增数组的遍历
				list.clear();//清空当前最长递增子序列存储空间
				int maxcurrent=i;
				while (maxcurrent>=0) {
					list.add(tmpNum[maxcurrent]);
					maxcurrent=selectNum[maxcurrent];
				}
				System.out.print("\n最长递增子序列之一为：");
				for (int j = list.size()-1; j>=0; j--) {
					System.out.print(list.get(j)+"、");
				}
			}
			list.clear(); //清空当前最长递增子序列存储空间
		}
	}
}
