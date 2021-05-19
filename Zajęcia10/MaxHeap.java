/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication27;

/**
 *
 * @author User
 */
class Node{
    int value;
}
class MaxHeap{
    int size;
    Node[] array;
    void Heap(int size){
    
    }
    int left(int i){
        return 2*i+1;
    }
    int right(int i){
        return 2*i+2;
    }
    int parent(int i){
        return (i+1)/2 - 1;
    
    }
    MaxHeap(int n){
       array = new Node[n];
       size = n;
       for(int i=0;i<n;i++){
           array[i] = new Node(); 
       }
    }
    void swap(int i, int j){
        Node temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    
    }
    void max_heapify(int i){ //przesiewanie w dół O(log (size)) 
        int l = left(i);
        int r = right(i);
        int largest = i;
        if(l<size && array[l].value>array[largest].value){
            largest = l;
        }
        if(r<size && array[r].value>array[largest].value){
            largest = r;
        }
        if(largest != i){
            swap(i,largest);
            max_heapify(largest);
        
        }
    }
    void min_heapify(int i){ //przesiewanie w góre O(log (size))
        int p = parent(i);
        if(p>=0 && array[p].value < array[i].value){
            swap(i,p);
            min_heapify(p);
        
        }
    }
    void build_heap(){// O(size)
        for(int i = size/2;i>=0;i--){
            max_heapify(i);
        }
    
    }
    void print_heap(){
        for(int i =0;i<size;i++){
            System.out.print(array[i].value+" ");
        }
        System.out.println();
    }
}
public class JavaApplication27 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(9);
        heap.array[0].value = 4; heap.array[1].value = 2; heap.array[2].value = 9; 
        heap.array[3].value = 14; heap.array[4].value = -3; heap.array[5].value = 8;
        heap.array[6].value = 0; heap.array[7].value = 20; heap.array[8].value = 1;
        //        4
        //     2     9
        //  14   -3  8 0
        //20 1
        
        heap.build_heap();
        heap.print_heap();
        heap.array[0].value = -10; 
        heap.max_heapify(0);
        heap.print_heap();
        heap.array[8].value = 100; 
        heap.min_heapify(8);
        heap.print_heap();
        
    }
    
}
