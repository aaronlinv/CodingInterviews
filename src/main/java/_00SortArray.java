import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Aaron
 * @date 2021-02-24 17:09
 */
public class _00SortArray {

    // 交换
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    // 1. 类库 4 ms  46MB
    public int[] sortArray1(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    // 2. 选择排序 O(n) O(1) 
    // 1368 ms  45.9 MB
    // 每一轮选择最小元素交换到未排定部分的开头
    // 在交换成本较高的排序任务中，就可以使用「选择排序」
    public int[] sortArray2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    // 3. 插入排序 
    // 3 2 1 
    // 630ms 46MB
    // 稳定排序，在接近有序的情况下，表现优异
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            // 暂存元素
            int temp = nums[i];
            int j = i;

            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }

    @Test
    public void testRunner() {

        Assert.assertArrayEquals(new int[]{1}, sortArray(new int[]{1}));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sortArray(new int[]{1, 2, 3, 4, 5}));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sortArray(new int[]{5, 4, 3, 2, 1}));

        Assert.assertArrayEquals(new int[]{1, 2, 3, 5}, sortArray(new int[]{5, 2, 3, 1}));
        Assert.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 5}, sortArray(new int[]{5, 1, 1, 2, 0, 0}));
    }
}
