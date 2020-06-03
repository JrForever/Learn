package com.jianyb.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Search {
    //深度优先遍历二叉树 dfs
    public static void dfs(TreeNode node) {
        if (node == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.data+"-");
            //先右后左
            if (temp.right != null){
                stack.add(temp.right);
            }

            if (temp.left != null){
                stack.add(temp.left);
            }
        }
    }

    //广度优先遍历二叉树  bfs
    public static void bfs(TreeNode node) {
        if (node == null)
            return;

        Queue<TreeNode> deque = new LinkedList<>();
        deque.add(node);
        while (!deque.isEmpty()) {
            TreeNode temp = deque.poll();
            System.out.print(temp.data+"-");
            if (temp.left != null) {
                deque.add(temp.left);
            }

            if (temp.right != null) {
                deque.add(temp.right);
            }
        }
    }
}
