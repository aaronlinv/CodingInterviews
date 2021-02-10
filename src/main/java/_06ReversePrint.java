import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class _06ReversePrint {
    //输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）

    // 1. 7 ms	38.9 MB 利用List反转，遍历回数组
    public int[] reversePrint1(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();

        if (head == null) {
            return new int[]{};
        }
        ListNode curNode = head;
        do {
            list.add(curNode.val);
            curNode = curNode.next;
        } while (curNode != null);

        System.out.println("list == > " + list);

        Collections.reverse(list);
        int[] intArr = new int[list.size()];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = list.get(i);
        }
        System.out.println("Array == > " + Arrays.toString(intArr));
        return intArr;
    }

    // 2.栈 2 ms	39 MB
    public int[] reversePrint2(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();

        if (head == null) {
            return new int[]{};
        }

        ListNode curNode = head;
        while (curNode != null) {
            stack.push(curNode.val);
            curNode = curNode.next;
        }
        int size = stack.size();
        int[] intArr = new int[size];

        for (int i = 0; i < size; i++) {
            intArr[i] = stack.pop();
        }

        return intArr;

    }

    int intArr[];
    int i = 0;
    int j = 0;

    // 3. 递归 无需遍历List (利用递归决定new []的长度) 0 ms	39.8 MB
    // JUnit：java.lang.AssertionError: array lengths differed, expected.length=3 actual.length=4
    public int[] reversePrint(ListNode head) {
        solve(head);
        // System.out.println("array == >" + Arrays.toString(intArr));
        return intArr;
    }

    // 3.
    private void solve(ListNode head) {
        if (head == null) {
            intArr = new int[i];
            return;
        }
        i++;
        solve(head.next);
        intArr[j] = head.val;
        j++;
    }


    @Test
    public void testRunner() {
        // 非法情况
        Assert.assertArrayEquals(new int[]{}, reversePrint(null));

        // [1]
        ListNode listNode1 = new ListNode(1);
        listNode1.next = null;
        Assert.assertArrayEquals(new int[]{1}, reversePrint(listNode1));

        // [1,3,2]
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(2, null)));
        Assert.assertArrayEquals(new int[]{2, 3, 1}, reversePrint(listNode2));

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}
