/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

import java.util.Stack;

/**
 *
 * @author User
 */
public class Rekurencja {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //test1(100000);
        int[] poly = {1,2,5};//x^2 + 2x + 5
        System.out.println(Horner(poly,2));
        System.out.println(Horner2(poly,2));
        int[] tab1 = {1,2,4,5,3,5,6,-2,-22,5,3,2,6,7,6,7,1,2,4,0,0};
        System.out.println("Quick Sort");
        quick_sort2(tab1);
        print_array(tab1);
        int[] set = {1,2,1,7};
        System.out.println(Pack(set,11));
        // TODO code application logic here
    }
    public static int test1(int n){
        if(n == 1){
            return 0;
        }
        else{
            return test1(n-1);
        }
    }
    //Schemat Hornera - rekurencja nie jest ogonowa
    public static int Horner(int[] poly,int x ,int n){
        if(n == 1){
            return poly[0];
        }
        return Horner(poly,x,n-1)*x + poly[n-1];
    }
    public static int Horner(int[] poly,int x ){
        return Horner(poly,x,poly.length);
    }
   
    
    //schemat Hornera z ogonowa rekurencja
    public static int Horner2(int[] poly,int x ,int n,Integer acc){
        if(n == poly.length){
            return acc ;
        }
        acc = acc *x+ poly[n];
        return Horner2(poly,x,n+1,acc);
    }
    public static int Horner2(int[] poly,int x){
        return Horner2(poly,x,0,0);
    }
    
    public static int partition(int[] tab,int L,int R){
        int x = tab[R];
        int i = L - 1;
        for(int j=L;j<R;j++){
            if(tab[j]<= x){
                i=i+1;
                swap(tab,i,j);
            }
        } 
        swap(tab,i+1,R);
        return i+1;
    }
    //usunieta rekurencja ogonowa z quick sort.
    public static void quick_sort(int[] tab,int L,int R){
        if(L>=R)
            return;
        while(true){
            int i = partition(tab,L,R);
            quick_sort(tab,L,i-1);
            L = i+1;
            if(L>=R){
                return;
            }
            //quick_sort(tab,i+1,R);
        }
    }
    public static void quick_sort(int[] tab){
        quick_sort(tab,0,tab.length-1);
    }
    //Symulacja rekurencji za pomocą stosu
    public static void quick_sort2(int[] tab,int L,int R){
        Stack<Pair> stack = new Stack<Pair>();
        Pair p = new Pair(L,R);
        stack.push(p);
        while(!stack.isEmpty()){
            p = stack.pop();
            if(!(p.L>=p.R) ){
                int i = partition(tab,p.L,p.R);
                Pair p1 = new Pair(p.L,i-1);
                Pair p2 = new Pair(i+1,p.R);
                stack.push(p1);
                stack.push(p2);                      
            }
            
            
        }

    }
    public static void quick_sort2(int[] tab){
        quick_sort(tab,0,tab.length-1);
    }
        
    
    
    public static void swap(int[] tab,int i,int j){
        int temp=tab[i];
        tab[i]=tab[j];
        tab[j]=temp;
    }
    //Algorytm do rozwiazujacy problem pakowania plecaka
    public static boolean Pack(int[] X,int S,int i){
        if(S==0)
            return true;
        if(X.length == i)
            return false;
        if(X[i]<=S){
            return Pack(X,S-X[i],i+1)||Pack(X,S,i+1);
        }
        else{
            return Pack(X,S,i+1);
        }
    }
    public static boolean Pack(int[] X,int S){
        return Pack(X,S,0);
    }
    
    public static void print_array(int[] tab) {
    // TODO code application logic here
        for(int j = 0;j<tab.length;j++){
            System.out.print(tab[j]+" ");
        }
        System.out.print("\n");
    }
    

}
class Pair{
        int L;
        int R;
    Pair(int L,int R){
        this.L = L;
        this.R = R;
    
    } 
}
