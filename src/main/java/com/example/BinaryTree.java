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
    
}
