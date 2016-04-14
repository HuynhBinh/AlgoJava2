package com.binh;

/**
 * Created by HuynhBinh on 4/12/16.
 */
public class AVLTree {
    AVLNode rootAbove;

    public AVLTree() {
        rootAbove = new AVLNode();
    }

    public void rotate(AVLNode base, AVLNode rootAbove) {
        int balance = base.getBalance();

        if (Math.abs(balance) < 2) {
            return;
        }

        AVLNode child = null;

        if (balance < 0) {
            child = base.leftNode;
        } else {
            child = base.rightNode;
        }

        if (child == null) {
            return;
        }

        int childBalance = child.getBalance();

        AVLNode grand = null;

        //left - left
        if (balance < -1 && childBalance < 0) {
            if (rootAbove != this.rootAbove && rootAbove.rightNode == base) {
                rootAbove.rightNode = child;
            } else {
                rootAbove.leftNode = child;
            }

            grand = child.rightNode;
            child.rightNode = base;
            base.leftNode = grand;

            return;

        } else if (balance > 1 && childBalance > 0) // right-right
        {
            if (rootAbove != this.rootAbove && rootAbove.rightNode == base) {
                rootAbove.rightNode = child;
            } else {
                rootAbove.leftNode = child;
            }

            grand = child.leftNode;
            child.leftNode = base;
            base.rightNode = grand;

            return;
        } else if (balance < -1 && childBalance > 0) // left-right
        {
            grand = child.rightNode;
            base.leftNode = grand;
            child.rightNode = grand.leftNode;
            grand.leftNode = child;

            rotate(base, rootAbove);
            return;

        } else if (balance > 1 && childBalance < 0) // right - left
        {
            grand = child.leftNode;
            base.rightNode = grand;
            child.leftNode = grand.rightNode;
            grand.rightNode = child;

            rotate(base, rootAbove);

            return;
        }


    }

    private void insert(int value, AVLNode node)
    {
        if(this.rootAbove.leftNode == null)
        {
            AVLNode root = new AVLNode();
            root.value = value;

            this.rootAbove.leftNode = root;

            return;
        }

        if(value > node.value)
        {
            if(node.rightNode != null)
            {
                insert(value, node.rightNode);
            }
            else
            {
                node.rightNode = new AVLNode();
                node.rightNode.value = value;
                return;
            }

        }
        else
        {
            if(node.leftNode != null)
            {
                insert(value, node.leftNode);
            }
            else
            {
                node.leftNode = new AVLNode();
                node.leftNode.value = value;
                return;
            }

        }


        //if the root is being evaluated it, rotate if necessary
        if(node == this.rootAbove.leftNode)
        {
            rotate(this.rootAbove.leftNode, this.rootAbove);
        }

        //otherwise, rotate the left and right subtrees as necessary
        if(node.leftNode != null)
        {
            rotate(node.leftNode, node);
        }

        if(node.rightNode != null)
        {
            rotate(node.rightNode, node);
        }





    }

    public void insert(int value)
    {
        insert(value, this.rootAbove.leftNode);
    }

    public void inOrder(AVLNode node)
    {
        if (node.leftNode != null)
        {
            inOrder(node.leftNode);
        }
        System.out.println(node.value);

        if(node.rightNode != null)
        {
            inOrder(node.rightNode);
        }
    }


}
