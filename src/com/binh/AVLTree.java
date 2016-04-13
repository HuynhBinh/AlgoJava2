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

        if (Math.abs(balance) < 2)
        {
            return;
        }

        AVLNode child = null;

        if (balance < 0)
        {
            child = base.leftNode;
        } else
        {
            child = base.rightNode;
        }

        if (child == null)
        {
            return;
        }

        int childBalance = child.getBalance();

        AVLNode grand = null;

        //left - left
        if (balance < -1 && childBalance < 0)
        {
            if (rootAbove != this.rootAbove && rootAbove.rightNode == base)
            {
                rootAbove.rightNode = child;
            } else
            {
                rootAbove.leftNode = child;
            }

            grand = child.rightNode;
            child.rightNode = base;
            base.leftNode = grand;

            return;

        }
        else if(balance > 1 && childBalance > 0) // right-right
        {
            if(rootAbove != this.rootAbove && rootAbove.rightNode == base)
            {
                rootAbove.rightNode = child;
            }
            else
            {
                rootAbove.leftNode = child;
            }

            grand = child.leftNode;
            child.leftNode = base;
            base.rightNode = grand;

            return;
        }
        else if(balance < -1 && childBalance > 0) // left-right
        {
            grand = child.rightNode;
            base.leftNode = grand;
            child.rightNode = grand.leftNode;
            grand.leftNode = child;
            rotate(base, rootAbove);
            return;

        }
        else if(balance > 1 && childBalance < 0) // right - left
        {

        }


    }
}
