package com.jianyb.tree;

public class BinaryTree {
    int data;
    BinaryTree right;//右子数
    BinaryTree left;//左子树

    public BinaryTree(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    //向二叉树中插入子节点
    public void insert(BinaryTree root, int data) {
        //二叉搜索树的左节点都比根节点小
        if (data > root.data) {
            if (root.right == null) {
                root.right = new BinaryTree(data);
            }else {
                insert(root.right, data);
            }
        }else {
            //二叉树的右节点都比根节点大
            if (root.left == null){
                root.left = new BinaryTree(data);
            }else {
                insert(root.left, data);
            }
        }
    }

    //先根遍历
    public static void preOrder(BinaryTree root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data+"-");
        preOrder(root.left);
        preOrder(root.right);
    }

    //中根遍历
    public static void inOrder(BinaryTree root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+"-");
        inOrder(root.right);
    }

    //后根遍历
    public static void posOrder(BinaryTree root) {
//        System.out.println("call posOrder");
        if (root == null) {
            return;
        }
        posOrder(root.left);
        posOrder(root.right);
        System.out.print(root.data+"-");
    }
}
