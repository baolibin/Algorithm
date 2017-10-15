package libin.offer;

/**
 * 面试题67：机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class _67_robot_range {
    public static void main(String[] args){

    }
}
class Solution67 {
    public int movingCount(int threshold, int rows, int cols){
        boolean[] visited=new boolean[rows*cols];
        int count=movingCountCore(threshold, rows,cols,0,0,visited);
        return count;
    }
    public int movingCountCore(int threshold, int rows, int cols,int row,int col,boolean[] visited){
        int count=0;
        if(check(threshold,rows,cols,row,col,visited)){
            visited[row*cols+col]=true;
            count=1+movingCountCore(threshold, rows,cols,row-1,col,visited)
                    +movingCountCore(threshold, rows,cols,row,col-1,visited)
                    +movingCountCore(threshold, rows,cols,row+1,col,visited)
                    +movingCountCore(threshold, rows,cols,row,col+1,visited);
        }
        return count;
    }
    public boolean check(int threshold, int rows, int cols,int row,int col,boolean[] visited){
        if(row>=0&&row<rows&&col>=0&&col<cols&&getDigitSum(row)+getDigitSum(col)<=threshold&&!visited[row*cols+col]){
            return true;
        }
        return false;
    }
    public int getDigitSum(int num){
        int sum=0;
        while (num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}
