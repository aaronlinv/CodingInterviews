import org.junit.Assert;
import org.junit.Test;

/**
 * @author Aaron
 * @date 2021-02-09 11:16
 */
public class _04FindNumberIn2DArray {
    // 1. 遍历 0 ms	44.5 MB O(nm) O(1)
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }

    // 2. 0 ms	44.3 MB O(n+m) O(1)
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int maxRow = matrix.length - 1;
        int maxCol = matrix[0].length - 1;

        int curRow = maxRow;
        int curCol = 0;
        // 从右上角开始搜索
        while (curRow >= 0 && curCol <= maxCol) {
            if (matrix[curRow][curCol] == target) {
                return true;
            } else if (matrix[curRow][curCol] < target) {
                curCol++;
            } else {
                curRow--;
            }
        }
        return false;

    }



    @Test
    public void testRunner() {
        int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        /*for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }*/

        // 边界
        Assert.assertTrue(findNumberIn2DArray(arr, 1));
        Assert.assertTrue(findNumberIn2DArray(arr, 15));
        Assert.assertTrue(findNumberIn2DArray(arr, 18));
        Assert.assertTrue(findNumberIn2DArray(arr, 30));
        // 不存在 
        Assert.assertFalse(findNumberIn2DArray(arr, 0));
        Assert.assertFalse(findNumberIn2DArray(arr, 31));


    }
}
