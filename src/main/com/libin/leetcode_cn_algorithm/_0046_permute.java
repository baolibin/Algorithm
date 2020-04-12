package libin.leetcode_cn_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright (c) 2020/4/12. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class _0046_permute {
    List<List<Integer>> res =  new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        fullPermutation(nums,0);
        return res;
    }
    public void fullPermutation(int[] nums,int index){
        if(index==nums.length){
            for(int i=0;i<nums.length;i++){
                System.out.print(nums[i]);
            }
            System.out.println();
            Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
            res.add(Arrays.asList(integers));
        }
        for(int i=index;i<nums.length;i++){
            if(legal(nums,index,i)){  // 当前遍历位置元素和后面元素一一对调，判断下是否有相同元素已经替换过
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
                fullPermutation(nums,index+1);
                nums[i] = nums[index];
                nums[index] = tmp;
            }
        }
    }
    boolean legal(int[] nums,int index,int cur){
        for(int i=index+1;i<=cur;i++){
            if(nums[i]==nums[index]){
                return false;
            }
        }
        return true;
    }
}
