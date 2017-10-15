package libin.offer;

import java.util.ArrayList;

/**
 * 面试题20：顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class _20_printMatrix {
    public static void main(String[] args){
        Solution20 solution20 = new Solution20();
        int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] a1={{1},{2},{3},{4}};
        ArrayList<Integer> res =solution20.printMatrix(a1);
        for(Integer o:res){
            System.out.print(o+"、");
        }
    }
}
class Solution20 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int rowsEnd=0; //每次遍历结尾行坐标
        int columnsEnd=0;//每次遍历结尾列坐标
        int rowsLen=matrix.length;
        int columnsLen=matrix[0].length;
        int count=0;//标记打印的圈数
        if(rowsLen<=0||columnsLen<=0){
            return null;
        }
        while(rowsLen>count*2&&columnsLen>count*2){
            rowsEnd=rowsLen-count-1;
            columnsEnd=columnsLen-count-1;
            for(int i=count;i<=columnsEnd;i++){ //从左到右
                res.add(matrix[count][i]);
            }
            if(count<rowsEnd){
                for(int j=count+1;j<=rowsEnd;j++){ //从上到下
                    res.add(matrix[j][columnsEnd]);
                }
            }
            if(count<rowsEnd&&count<columnsEnd){ //从右到左
                for(int k=columnsEnd-1;k>=count;k--){
                    res.add(matrix[rowsEnd][k]);
                }
            }
            if(count<columnsEnd&&count<rowsEnd-1){ //从下到上
                for(int p=rowsEnd-1;p>=count+1;p--){
                    res.add(matrix[p][count]);
                }
            }
            count++;
        }
        return res;
    }
}