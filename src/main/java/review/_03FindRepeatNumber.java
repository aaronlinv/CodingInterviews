package review;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class _03FindRepeatNumber {
    // 长度为 n 的数组 nums 里的所有数字都在 0～n-1 
    class Solution {
        // 1. HashSet 时间空间：O(n) O(n)
        // 8 ms	47.5 MB
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
        // 	1 ms	46 MB
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
        // 0 ms	46.2 MB
        public int findRepeatNumber(int[] nums) {
            // 1,0,1,2,2
            /*
            比如 nums[0] 值如果为0 就不变
            如果 nums[0] 值为1 那就把它的值与 nums[1] 的交换
            保证 nums[index] = index
            保证下标 与其值相同否者，否则就不对
             */
            
            int temp;
            for (int i = 0; i < nums.length; i++) {
                // 保证index 和值x 相同，否者要交换
                if(nums[i] != i){
                    // 出现两个 nums[i]值
                    if(nums[nums[i]]== nums[i]){
                        return nums[i];
                    }
                    temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
            return -1;

        }

    }

    @Test
    public void testRunner() {
        Solution s = new Solution();
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        Assert.assertEquals(2, s.findRepeatNumber(arr));

        arr = new int[]{};
        Assert.assertEquals(-1, s.findRepeatNumber(arr));

        arr = new int[]{0};
        Assert.assertEquals(-1, s.findRepeatNumber(arr));

        arr = new int[]{0, 1, 2, 3, 4};
        Assert.assertEquals(-1, s.findRepeatNumber(arr));

        arr = new int[]{1, 1};
        Assert.assertEquals(1, s.findRepeatNumber(arr));

        arr = new int[]{0, 1, 1};
        Assert.assertEquals(1, s.findRepeatNumber(arr));

        arr = new int[]{2, 3, 1, 0, 2, 5, 3};
        Assert.assertEquals(2, s.findRepeatNumber(arr));

    }


}
