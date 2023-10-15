package com.example;
public class BinaryTree {

    Node raiz;

    public BinaryTree() {
        this.raiz = null;
    }

public void add(int info){
    Node novo = new Node();
    novo.info = info;
    if(raiz == null){
        raiz = novo;
        return;
    }
    Node atual = raiz;
    while(atual!= null){
        if(atual.info > info){
            if(atual.esq == null){
                atual.esq = novo;
                return;
            }
            atual = atual.esq;
        }else{
            if(atual.dir == null){
                atual.dir = novo;
                return;
            }
            atual = atual.dir;
        }
    }
}

    
 public void preorder(Node raiz) {
    
            if(raiz == null) {
              return;
            }
        
            System.out.print(raiz.info + " ");
        
            preorder(raiz.esq);
        
            preorder(raiz.dir);
        
          }

public void search(int search)
{
    Node atual = raiz;
    while(atual!= null){
        if(atual.info == search){
            System.out.println(atual.info);
            return;
        }
        if(atual.info > search){
            atual = atual.esq;
        }else{
            atual = atual.dir;
        }
    }
    System.out.println("Nao Encontrado");
}    
public Node deleteNode(Node raiz ,int valor) {
    // Return if empty tree
    if (raiz == null) {
      return raiz;
    }

    // Find the node to be deleted
    if (valor < raiz.info) {
      raiz.esq = deleteNode(raiz.esq, valor);
    } else if (valor > raiz.info) {
      raiz.dir = deleteNode(raiz.dir, valor);
    } else {

      // Case 1: No child
      if (raiz.esq == null && raiz.dir == null) {
        return null;
      }

      // Case 2: One child  
      if (raiz.esq == null) {
        Node temp = raiz.dir;
        return temp;
      } else if (raiz.dir == null) {
        Node temp = raiz.esq;
        return temp;
      }

      // Case 3: 2 children
      Node successor = getSuccessor(raiz);
      raiz.info = successor.info;
      raiz.dir = deleteNode(raiz.dir, successor.info);
    }
    return raiz;
  }

  public Node getSuccessor(Node raiz) {
    Node curr = raiz.dir;
    while (curr != null && curr.esq != null) {
      curr = curr.esq;
    }
    return curr;
  } 
 
}
