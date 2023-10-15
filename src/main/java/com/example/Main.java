package com.example;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        long inicio = System.currentTimeMillis();
        for(int i=0;i<20000;i++){
        Random random = new Random();
        tree.add(random.nextInt());
       }
       long fim = System.currentTimeMillis();
       System.out.println("Tempo de inserção Binaria com 20 mil:"+(fim-inicio));
       //tree.preorder(tree.raiz);



        AVLTree teste= new AVLTree();
        inicio = System.currentTimeMillis();
        for(int i=0;i<20000;i++){
        Random random = new Random();
        teste.inserir(random.nextInt());
       }
       fim = System.currentTimeMillis();
       System.out.println("Tempo de inserção AVL com 20 mil:"+(fim-inicio));
       //teste.preorder(teste.raiz);


    }
}