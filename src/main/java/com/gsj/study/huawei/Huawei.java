package com.gsj.study.huawei;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Huawei {


    public static void main(String[] args) {

//        4
//        2   7
//        13 69

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        Huawei h = new Huawei();
        h.invertTree(root);

        TreeNode cur = root;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        while(cur != null){
            System.out.print(cur.val);
            if(cur.left != null) {
                deque.add(cur.left);
            }
            if(cur.right != null) {
                deque.add(cur.right);
            }
            cur = deque.pollFirst();
        }
    }


    public TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode right = invertTree(root.left);
        TreeNode left = invertTree(root.right);
        root.left = left;
        root.right = right;

//        TreeNode cur = root;
//        if(cur != null){
//            if(cur.left != null){
//                invertTree(cur.left);
//            }
//            if(cur.right != null){
//                invertTree(cur.right);
//            }
//            TreeNode tmp = cur.left;
//            cur.left = cur.right;
//            cur.right = tmp;
//        }
        return root;

    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


}
