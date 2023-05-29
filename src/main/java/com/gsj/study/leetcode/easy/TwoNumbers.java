package com.gsj.study.leetcode.easy;

public class TwoNumbers {
    public static void main(String[] args) {
        ListNode t1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode t2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode re = addTwoNumbers(t1, t2);
        while(re != null){
            System.out.print(re.val+"-->");
            re = re.next;
        }

        System.out.println();
        t1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9, new ListNode(9)))))));
        t2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        re = addTwoNumbers(t1, t2);
        while(re != null){
            System.out.print(re.val+"-->");
            re = re.next;
        }


    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null;
        ListNode pre = null;
        ListNode oneIndex = l1;
        ListNode sndIndex = l2;
        int i = 0;
        int jw = 0;
        while(oneIndex != null && sndIndex != null){

            ListNode  cur = new ListNode(oneIndex.val + sndIndex.val + jw);
            jw = cur.val/10;
            cur.val = cur.val % 10;
            if(i == 0){
                head = cur;
                pre = head;
            }else{
                pre.next = cur;
                pre = cur;
            }
            oneIndex = oneIndex.next;
            sndIndex = sndIndex.next;
            i++;
        }

        ListNode left = oneIndex != null ? oneIndex : sndIndex;

        while(left != null){
            ListNode  cur = new ListNode(left.val + jw);
            jw = cur.val/10;
            cur.val = cur.val % 10;
            if(i == 0){
                head = cur;
                pre = head;
            }else{
                pre.next = cur;
                pre = cur;
            }
            left = left.next;
            i++;
        }

        if(jw > 0){
            pre.next = new ListNode(jw);
        }

        return head;
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}



