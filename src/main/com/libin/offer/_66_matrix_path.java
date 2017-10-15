package libin.offer;
/**
 * 面试题66：矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bccced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class _66_matrix_path {
    public static void main(String[] args){
        boolean[] vistied=new boolean[5];
        System.out.println(vistied[0]);
    }
}
class Solution66 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(matrix==null||rows<1||cols<1||str==null){
            return false;
        }
        boolean[] vistied=new boolean[rows*cols];
        int pathLength=0;
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(hasPathCore(matrix, rows, cols, row, col,  str, pathLength, vistied)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean hasPathCore(char[] matrix, int rows, int cols,int row, int col, char[] str,int pathLength,boolean[] vistied){
        if(pathLength==str.length){
            return true;
        }
        boolean hasPath=false;
        if(row>=0&&row<rows&&col>=0&&col<cols&&matrix[row*cols+col]==str[pathLength]&&!vistied[row*cols+col]){
            pathLength++;
            vistied[row*cols+col]=true;
            hasPath=hasPathCore(matrix, rows, cols, row, col-1,  str, pathLength, vistied)
                    ||hasPathCore(matrix, rows, cols, row-1, col,  str, pathLength, vistied)
                    ||hasPathCore(matrix, rows, cols, row, col+1,  str, pathLength, vistied)
                    ||hasPathCore(matrix, rows, cols, row+1, col,  str, pathLength, vistied);
            if(!hasPath){
                pathLength--;
                vistied[row*cols+col]=false;
            }
        }
        return hasPath;
    }
}
