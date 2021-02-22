import org.junit.Assert;
import org.junit.Test;

/**
 * @author Aaron
 * @date 2021-02-22 17:02
 */
public class _10NumWays {
    /*
    一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
    答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1
    青蛙跳台阶问题：  f(0)=1 ,f(1)=1 ,f(2)=2 ；
     */
    // 0 ms 35.4 MB
    public int numWays1(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
    
    // 0 ms 35.2 MB
    public int numWays(int n) {
        if (n == 0)return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_007;
        }
        return dp[n];
    }


    // public int numWays0(int n) {
    //     if (n == 0) return 1;
    //     if (n == 1) return 1;
    //     return numWays(n - 1) + numWays(n - 2);
    // }

    @Test
    public void testRunner() {
        Assert.assertEquals(1, numWays(0));
        Assert.assertEquals(1, numWays(1));
        Assert.assertEquals(2, numWays(2));
        Assert.assertEquals(782204094, numWays(100));


    }
}
