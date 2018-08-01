package libin.general._07_dp;
/**
 * Copyright (c) 2017/1/1. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 01背包
 */
public class _03_knapsack {
    int N=4; //物品个数
    int M=12; //载重总量
    int[] w={2,4,6,7,0}; //物品的重量
    int[] v={1,5,3,8,0}; //物品的价值
    int[][] f=new int[N+1][M+1];
    /**
     * 求最大值
     */
    public void getValue(){
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(j>=w[i]){
                    f[i][j]=max(f[i-1][j],f[i-1][j-w[i]]+v[i]);
                }else {
                    f[i][j]=f[i-1][j];
                }
            }
        }
    }
    public int max(int num1,int num2){
        return num1>num2?num1:num2;
    }
    public void printMaxVal(){
        System.out.println(f[N][M]);
    }
    public static void main(String[] args){
        _03_knapsack knapsack = new _03_knapsack();
        knapsack.getValue();
        knapsack.printMaxVal();
    }
}
