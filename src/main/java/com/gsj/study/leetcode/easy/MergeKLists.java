package com.gsj.study.leetcode.easy;

public class MergeKLists {


    public static void main(String[] args) {
        ListNode t1 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(9, new ListNode(10)))))));
        ListNode t2 = new ListNode(2, new ListNode(3, new ListNode(6, new ListNode(11))));
        ListNode t3 = new ListNode(2, new ListNode(3, new ListNode(6, new ListNode(11))));
        ListNode[] lists = new ListNode[3];
        lists[0] = t1;
        lists[1] = t2;
        lists[2] = t3;
        ListNode re = mergeKLists(lists);
        while (re != null) {
            System.out.print(re.val + "-->");
            re = re.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return mergeKLists(lists, 0, lists.length);
    }

    public static ListNode mergeKLists(ListNode[] lists, int start, int end) {
        int mid = (end - start) / 2;

        if (mid == 0) {
            return lists[start];
        }
        ListNode first = null;
        ListNode sec = null;

        first = mergeKLists(lists, start, start + mid);
        sec = mergeKLists(lists, start + mid, end);

        return mergeKLists(first, sec);
    }

    public static ListNode mergeKLists(ListNode first, ListNode sec) {
        if (first == null) {
            return sec;
        }
        if (sec == null) {
            return first;
        }
        if (first.val > sec.val) {
            return mergeKLists(sec, first);
        }
        ListNode cur = first;
        ListNode secIdx = sec;

        while (secIdx != null) {
            if (cur.val <= secIdx.val) {
                while (cur.next != null && cur.next.val <= secIdx.val) {
                    cur = cur.next;
                }
                if (cur.next != null) {
                    ListNode curNext = cur.next;
                    cur.next = secIdx;
                    ListNode secNext = secIdx.next;
                    secIdx.next = curNext;
                    cur = secIdx;
                    secIdx = secNext;
                } else {
                    cur.next = secIdx;
                    secIdx = secIdx.next;
                    break;
                }
            }
        }
        return first;
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
