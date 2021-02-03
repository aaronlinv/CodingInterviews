import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aaron
 * @date 2021-02-03 17:20
 */
public class _03FindRepeatNumber {
    // 长度为 n 的数组 nums 里的所有数字都在 0～n-1 
    class Solution {
        // 1. HashSet 时间空间：O(n) O(n)
        public int findRepeatNumber1(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                if (set.contains(num)) {
                    return num;
                } else {
                    set.add(num);
                }
            }
            return -1;
        }

        // 2. 数组标记
        public int findRepeatNumber2(int[] nums) {
            int[] temp = new int[nums.length];
            for (int num : nums) {
                if (temp[num] != 1) {
                    temp[num] = 1;
                } else {
                    return num;
                }
            }
            return -1;
        }

        // 数组交换
        public int findRepeatNumber(int[] nums) {
            // 0,1,2,2
            for (int num : nums) {
                if (nums[num] != num) {
                    int value = nums[num];
                    nums[num] = nums[value];
                    nums[value] = value;
                }
            }
            return -1;
        }

    }

    @Test
    public void testRunner() {
        Solution s = new Solution();
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        Assert.assertEquals(s.findRepeatNumber(arr), 2);

        arr = new int[]{};
        Assert.assertEquals(s.findRepeatNumber(arr), -1);

        arr = new int[]{0};
        Assert.assertEquals(s.findRepeatNumber(arr), -1);

        arr = new int[]{0, 1, 2, 3, 4};
        Assert.assertEquals(s.findRepeatNumber(arr), -1);

        arr = new int[]{1, 1};
        Assert.assertEquals(s.findRepeatNumber(arr), 1);

        arr = new int[]{0, 1, 1};
        Assert.assertEquals(s.findRepeatNumber(arr), 1);

    }


}
