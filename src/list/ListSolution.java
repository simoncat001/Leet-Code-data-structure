package list;

import sun.plugin.dom.core.CoreConstants;

import java.util.List;

public class ListSolution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return head.next;
    }
    
    public ListNode reverseList1(ListNode head) {
        ListNode curr = null;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = curr;
            curr = temp;
            head = head.next;
        }
        return curr;
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode check = head;
        int canProceed = 0;
        while (check != null && canProceed < k) {
            canProceed++;
            check = check.next;
        }
        if (canProceed < k) {
            return head;
        } else {
            int i = k;
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null && i > 0) {
                //临时存贮next指针
                ListNode temp = curr.next;
                //反转当前节点next指针
                curr.next = prev;
                //prev指针前移
                prev = curr;
                //curr指针前移指向next
                curr = temp;
                i--;
            }
            if (curr != null) {
                //递归反转下一个 k Group
                head.next = reverseKGroup(curr, k);
            }
            return prev;
        }
    }
    
    public void rotate(int[] nums, int k) {
    
    }
    
    
}
