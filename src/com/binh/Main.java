package com.binh;

public class Main {

    public static void main(String[] args)
    {

        Tree tree = new Tree();
        /*tree.insert(15, tree.root);
        tree.insert(7, tree.root);
        tree.insert(23, tree.root);
        tree.insert(6, tree.root);
        tree.insert(17, tree.root);
        tree.insert(13, tree.root);
        tree.insert(99, tree.root);*/
        tree.insert(15);
        tree.insert(7);
        tree.insert(23);
        tree.insert(6);
        tree.insert(17);
        tree.insert(13);
        tree.insert(99);


        tree.postOrder(tree.root);

        System.out.println("Min: " + tree.minValue().value);
        System.out.println("Max: " + tree.maxValue().value);


        System.out.println("Min1: " + tree.minValue(tree.root).value);
        System.out.println("Max1: " + tree.maxValue(tree.root).value);


        Node data = tree.search(12, tree.root);
        if(data != null)
        {
            System.out.println("Search: " + data.value);
        }
        else
        {
            System.out.println("Cannot find");
        }

        Node data1 = tree.search(23);
        if(data1 != null)
        {
            System.out.println("Search: " + data1.value);
        }
        else
        {
            System.out.println("Cannot find");
        }

    }
}
