package com.jianyb.tree;

/**
 * 二叉树
 */
public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    //向二叉树中插入子节点
    public void insert(TreeNode root, int data) {
        //二叉搜索树的左节点都比根节点小
        if (data > root.data) {
            if (root.right == null) {
                root.right = new TreeNode(data);
            }else {
                insert(root.right, data);
            }
        }else {
            //二叉树的右节点都比根节点大
            if (root.left == null){
                root.left = new TreeNode(data);
            }else {
                insert(root.left, data);
            }
        }
    }
}
