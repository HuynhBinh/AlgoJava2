package com.binh;

/**
 * Created by HuynhBinh on 4/12/16.
 */
public class AVLTree
{
    AVLNode rootAbove;

    public AVLTree()
    {
        rootAbove = new AVLNode();
    }

    public void rotate(AVLNode base, AVLNode rootAbove)
    {
        int balance = base.getBalance();

        if(Math.abs(balance) < 2)
        {
            return;
        }

        AVLNode child = null;

        if(balance < 0)
        {
            child = base.leftNode;
        }
        else
        {
            child = base.rightNode;
        }

        if(child == null)
        {
            return;
        }

        int childBalance = child.getBalance();

        AVLNode grand = null;






    }
}
