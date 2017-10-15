package libin.offer;

/**
 * 面试题3：二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class _03_array {
    public static void main(String[] args) {
        Solution03 solution03 = new Solution03();
        int[][] array = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};
        System.out.println(solution03.Find(11,array));
    }
}
class Solution03 {
    public boolean Find(int target, int[][] array) {
        int rows = array.length;
        int column = array[0].length;
        int currentRow = 0;
        int currentColumn = column - 1;
        if (rows > 0 && column > 0) {
            while (currentRow < rows && currentColumn >= 0) {
                if (array[currentRow][currentColumn] == target) {
                    return true;
                } else if (array[currentRow][currentColumn] < target) {
                    currentRow++;
                } else {
                    currentColumn--;
                }
            }
        }
        return false;
    }
}
