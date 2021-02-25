import org.junit.Assert;
import org.junit.Test;

/**
 * @author Aaron
 * @date 2021-02-25 17:21
 */
public class _12Exist {
    // 矩阵中的路径 5ms 40.4MB
    // M,N 分别为矩阵行列大小， K 为字符串 word 长度 
    // O(3^KMN) O(K)
    // 3代表排除回头外的其他三个方向的搜索 递归深度不超过 K
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        // 对每个元素调用 dfs 深度优先搜索
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        // 排除越界和不符合的情况
        if (i >= board.length || i < 0 ||
                j >= board[0].length || j < 0 ||
                board[i][j] != words[k]) {
            return false;
        }
        // 搜索结束
        if (k == words.length - 1) {
            return true;
        }
        // 标记已搜索过
        board[i][j] = '\0';
        
        // 上下左右
        boolean res = dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i - 1, j, k + 1) ||
                dfs(board, words, i, j - 1, k + 1) || dfs(board, words, i, j + 1, k + 1);
        // 恢复
        board[i][j] = words[k];
        return res;
    }

    @Test
    public void testRunner() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        Assert.assertTrue(exist(board, "ABCCED"));

        board = new char[][]{
                {'a', 'b'},
                {'c', 'd'}};
        Assert.assertFalse(exist(board, "abcd"));


    }
}
