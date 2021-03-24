/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;


class Node{
    int value;
    Node next;
}

//Implementacja listy jedno kierunkowej (stosu)
class OneDirectionList{
    OneDirectionList()
    {
    this.begin = null;
    }
    Node begin;
    void add(int value)
    {
        Node node = new Node();
        node.next = begin;
        node.value = value;
        begin = node;
    }
    Object getFirst()
    {
        return begin.value;
    }
    void removeFirst()
    {
        begin = begin.next;
    }
    void print(){
        Node iter = this.begin;
        while(iter != null){
        System.out.print(iter.value+" ");
        iter = iter.next;
        
        }
        System.out.print("\n");
    }
}

public class Lista {


    public static void main(String[] args) {
        OneDirectionList list1 = new OneDirectionList();
        list1.add(2);
        list1.add(5);
        list1.add(9);
        list1.removeFirst();
        list1.removeFirst();
        list1.add(7);
        list1.removeFirst();
        list1.print();
    }
    
}
