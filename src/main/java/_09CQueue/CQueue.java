package _09CQueue;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author Aaron
 * @date 2021-02-19 16:12
 * <p>
 * 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 */
// 61ms 46.7
public class CQueue {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();


    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else if (!stack1.isEmpty()) {

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();

        } else {
            return -1;
        }
    }

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */

    @Test
    public void testRunner() {
        /*
        输入：
        ["CQueue","appendTail","deleteHead","deleteHead"]
        [[],[3],[],[]]
        输出：[null,null,3,-1]
        */
        CQueue q1 = new CQueue();
        q1.appendTail(3);
        Assert.assertEquals(q1.deleteHead(), 3);
        Assert.assertEquals(q1.deleteHead(), -1);

        /*
        输入：
        ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
        [[],[],[5],[2],[],[]]
        输出：[null,-1,null,null,5,2]
         */
        CQueue q2 = new CQueue();
        Assert.assertEquals(q2.deleteHead(), -1);
        q2.appendTail(5);
        q2.appendTail(2);
        Assert.assertEquals(q2.deleteHead(), 5);
        Assert.assertEquals(q2.deleteHead(), 2);

    }
}
