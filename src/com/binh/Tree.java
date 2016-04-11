package com.binh;

/**
 * Created by HuynhBinh on 4/11/16.
 */
public class Tree
{
    public Node root;

    public Node search(int value, Node fromNode)
    {
        if (fromNode.value == value)
        {
            return fromNode;
        }

        if (value > fromNode.value)
        {
            if (fromNode.rightNode != null)
            {
                return search(value, fromNode.rightNode);
            } else
            {
                return null;
            }
        } else
        {
            if (fromNode.leftNode != null)
            {
                return search(value, fromNode.leftNode);
            } else
            {
                return null;
            }
        }

    }


    public Node search(int value)
    {
        Node currentNode = root;

        if(value == currentNode.value)
        {
            return currentNode;
        }


        while (true)
        {
            if (value > currentNode.value)
            {
                if(currentNode.rightNode != null)
                {
                    currentNode = currentNode.rightNode;
                    if(currentNode.value == value)
                    {
                        return currentNode;
                    }
                }
                else
                {
                    return null;
                }


            } else
            {
                if(currentNode.leftNode != null)
                {
                    currentNode = currentNode.leftNode;
                    if(currentNode.value == value)
                    {
                        return currentNode;
                    }
                }
                else
                {
                    return null;
                }
            }
        }

    }


    public void insert(int value, Node fromNode)
    {
        if (root == null)
        {
            this.root = new Node();
            this.root.value = value;

            return;
        }

        if (value > fromNode.value)
        {
            if (fromNode.rightNode != null)
            {
                insert(value, fromNode.rightNode);
            } else
            {
                fromNode.rightNode = new Node();
                fromNode.rightNode.value = value;
            }
        } else
        {
            if (fromNode.leftNode != null)
            {
                insert(value, fromNode.leftNode);
            } else
            {
                fromNode.leftNode = new Node();
                fromNode.leftNode.value = value;
            }
        }
    }


    public void insert(int value)
    {
        if(this.root == null)
        {
            this.root = new Node();
            this.root.value = value;
            return;
        }

        Node currentNode = root;

        while(true)
        {
            if(value > currentNode.value)
            {
                if(currentNode.rightNode != null)
                {
                    currentNode = currentNode.rightNode;
                }
                else
                {
                    currentNode.rightNode = new Node();
                    currentNode.rightNode.value = value;
                    return;
                }
            }
            else
            {
                if(currentNode.leftNode != null)
                {
                    currentNode = currentNode.leftNode;
                }
                else
                {
                    currentNode.leftNode = new Node();
                    currentNode.leftNode.value = value;
                    return;
                }
            }
        }
    }

    public Node minValue()
    {
        Node currentNode = root;
        while (currentNode.leftNode != null)
        {
            currentNode = currentNode.leftNode;

        }

        return currentNode;
    }


    public Node minValue(Node node)
    {

        if(node.leftNode == null)
        {
            return node;
        }

        return minValue(node.leftNode);

    }






    public Node maxValue()
    {
        Node currentNode = root;

        while (currentNode.rightNode != null)
        {
            currentNode = currentNode.rightNode;
        }

        return currentNode;
    }


    public Node maxValue(Node node)
    {
        if(node.rightNode == null)
        {
            return node;
        }

        return maxValue(node.rightNode);
    }

    public void inOrder(Node node)
    {
        if (node.leftNode != null)
        {
            inOrder(node.leftNode);
        }

        //print middle node
        System.out.println(node.value);
        //return;


        if(node.rightNode != null)
        {
            inOrder(node.rightNode);
        }

    }

    public void postOrder(Node node)
    {
        if(node.rightNode != null)
        {
            postOrder(node.rightNode);
        }

        System.out.println(node.value);


        if(node.leftNode != null)
        {
            postOrder(node.leftNode);
        }

    }


}
