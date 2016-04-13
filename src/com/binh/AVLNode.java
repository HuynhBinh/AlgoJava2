package com.binh;

/**
 * Created by HuynhBinh on 4/13/16.
 */
public class AVLNode {

    public AVLNode leftNode;
    public AVLNode rightNode;

    public int value;

    public int height()
    {
        int leftHeight = (leftNode == null) ? 0 : leftNode.height();
        int rightHeight = (rightNode == null) ? 0 : rightNode.height();

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int getBalance()
    {
        int leftHeight = (leftNode == null) ? 0 : leftNode.height();
        int rightHeight = (rightNode == null) ? 0 : rightNode.height();

        return rightHeight - leftHeight;
    }


}
