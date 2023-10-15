package com.example;

public class AVLTree {
    Node raiz;
    public AVLTree(){
        raiz= null;
    }

public static int altura(Node no){
    if(no==null) return -1;
    int esquerda =altura(no.esq);
    int direita = altura(no.dir);
    if(esquerda>direita) return 1+esquerda;
    return 1+direita;
}
public int fatorBalanciamento(Node no){  
    return altura(no.esq) -altura(no.dir);   
}
// A partir das rotações o nó raiz ira mudar e será retornado para manter o atributo  integro
public void inserir(int info) {
    raiz = inserirInterno(raiz,info ); 
  }

private Node inserirInterno(Node raiz, int info) {
    
    // Passo 1 - Executa a inserção normal em uma BST
    if (raiz == null) {
      Node novo=new Node();
      novo.info=info;
      return novo;
    }
    
    if (info < raiz.info) {
      raiz.esq = inserirInterno(raiz.esq, info);
    } else {
      raiz.dir = inserirInterno(raiz.dir, info);
    }

    // Passo 3 - Obtem o fator de balanceamento
    int balance = fatorBalanciamento(raiz);

    // Passo 4 - Verifica quais são os casos de desbalanceamento 
    // e faz a rotação se necessário
    
    if (balance > 1) {
      if (info < raiz.esq.info) {
        return rotacaoDireita(raiz);
      } else {
        raiz.esq = rotacaoEsquerda(raiz.esq);
        return rotacaoDireita(raiz);
      }
    }

    if (balance < -1) {
      if (info > raiz.dir.info) {
        return rotacaoEsquerda(raiz);
      } else {
        raiz.dir = rotacaoDireita(raiz.dir);
        return rotacaoEsquerda(raiz);
      }
    }
    
    return raiz;
  }

  // Rotação à direita 
private Node rotacaoDireita(Node y) {

    Node x = y.esq;
    Node z = x.dir;
  
    x.dir = y;
    y.esq = z;
  
    return x; 
  }
  
  // Rotação à esquerda
  private Node rotacaoEsquerda(Node x) {
  
    Node y = x.dir;
    Node z = y.esq;
  
    y.esq = x;
    x.dir = z;
  
    return y;
  }
public void preorder(Node raiz) {
    
    if(raiz == null) {
      return;
    }

    System.out.print(raiz.info + " ");

    preorder(raiz.esq);

    preorder(raiz.dir);

  }


}
