import org.junit.Assert;
import org.junit.Test;

/**
 * @author Aaron
 * @date 2021-02-20 17:15
 */
public class _10Fibonacci {
    /*
    F(0) = 0,   F(1) = 1
    F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
    答案需要取模 1e9+7（1000000007）
     */
    // 错误
    public int fib1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (fib1(n - 1)) % 1000000007 + (fib1(n - 2)) % 1000000007;
    }

    // 0 ms 34.9 MB
    public int fib2(int n) {
        /*
        fib : 0 1 1 2
        
        n = 0    0
        n = 1    0 1  循环一次
        n = 2    0 1 1   循环两次
         */

        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            // 累加两数，并往前移动一位
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    // 动态规划 
    public int fib(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    @Test
    public void testRunner() {
        Assert.assertEquals(0, fib(0));
        Assert.assertEquals(1, fib(1));
        Assert.assertEquals(1, fib(2));
        Assert.assertEquals(2, fib(3));
        Assert.assertEquals(134903163, fib(45));
    }
}
