package com.two95.sooraj.BinarySearchTree;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	BST binary=new BST();
    	binary.insert(5);
    	binary.insert(25);
    	binary.insert(3);
    	binary.insert(101);
    	binary.insert(76);
    	binary.insert(2);
    	binary.insert(18);
    	binary.insert(33);
    	binary.display(binary.root);
    	System.out.println("root is"+binary.root.data);

    }
}
