package com.example;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(0);
        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.preorder(tree.raiz);
        tree.search(3);
        tree.search(9);
    }
}