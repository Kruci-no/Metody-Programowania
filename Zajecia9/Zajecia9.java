/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication24;

/**
 *
 * @author User
 */
class Node{
    int value;
    Node left;
    Node right;
}
class BST{
    Node root;
    void add(int x){
        Node current = root;
        if(root == null){
            root = new Node();
            root.value = x;  
        }
        else while(true){
            
            if(x <= current.value){
                //System.out.print("elo");
                if(current.left == null){
                    current.left = new Node();
                    current.left.value = x;
                    break;
                }
                else{
                    current = current.left;
                }
            }
            else{
                
                if(current.right == null){
                    current.right = new Node();
                    current.right.value = x;
                    break;
                }
                else{
                    current = current.right;
                }          
            }
        }
        current = new Node();
        current.value = x;   
        //System.out.print(root);
        //System.out.print(current);
    }
    void inOrder(){
        inOrder(root);
    }
    void inOrder(Node node){
       // System.out.print(node);
        if(node != null){
            inOrder(node.left);
            System.out.print(node.value+" ");
            inOrder(node.right);
        }
    
    }
    
}
public class JavaApplication24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BST tree = new BST();
        tree.add(1);
        tree.add(3);
        tree.add(7);
        tree.add(4);
        tree.inOrder();
        //System.out.println(tree.root.right);
        // TODO code application logic here
    }
    
}
