import org.junit.Assert;
import org.junit.Test;

/**
 * @author Aaron
 * @date 2021-02-23 17:32
 */
public class _11MinArray {
    /*
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转
    输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素
    例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1
    
     */
    // 0 ms  38.5 MB
    // [3, 4, 5, 1, 2]
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                // 相等左移动
                high--;
            }
        }
        return numbers[low];
    }
    // 0 ms  38.2 MB
    public int minArray2(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] > numbers[i]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }


    @Test
    public void testRunner() {
        Assert.assertEquals(2, minArray(new int[]{2, 2}));
        Assert.assertEquals(1, minArray(new int[]{3, 4, 5, 1, 2}));
        Assert.assertEquals(0, minArray(new int[]{2, 2, 2, 0, 1}));
        Assert.assertEquals(0, minArray(new int[]{0, 1, 2, 3, 4}));
    }
}
