/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication21;

/**
 *
 * @author User
 */
public class JavaApplication21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] tab={0,40,2,1,9,3,2,0,4,4,3,2,9,0,11,33,4,6,4,2,99,18,100,44,32,77,46,67,11,24,66,33,4,2,3,1,0,0,999,0,0};
        radixSortBase10(tab,100);
        print_array(tab);
    }
    public static void countSort(int[] tab,int k){
        int [] count = new int[k];
        for(int i=0;i<tab.length;i++){
            count[tab[i]] = count[tab[i]] + 1; 
        }
        int j = 0;
        for(int i=0;i<tab.length;i++){
            while(count[j] == 0)
                j++;
            tab[i] = j;
            count[j] = count[j]-1;
        }
            
    }
    public static void countSortStable(int[] tab,int k){
        int [] count = new int[k];
        int [] temp = new int[tab.length];
        for(int i=0;i<tab.length;i++){
            count[tab[i]] = count[tab[i]] + 1; 
        }
        for(int i = 1;i<count.length;i++){
            count[i] = count[i-1] + count[i];
        }
        for(int i=tab.length-1;i>=0;i--){
            count[tab[i]] = count[tab[i]] - 1; 
            temp[count[tab[i]]] = tab[i]; 
        }
        for(int i=0;i<tab.length;i++)
            tab[i] = temp[i];
    
    }
    public static void countSortBase(int[] tab,int b, int k){
        int [] count = new int[b];
        int [] temp = new int[tab.length];
        //System.out.println(temp.length);
        for(int i=0;i<tab.length;i++){
            int j = f(tab[i],b,k);
            count[j] = count[j] + 1; 
        }
        for(int i = 1;i<count.length;i++){
            count[i] = count[i-1] + count[i];
        }
        for(int i=tab.length-1;i>=0;i--){
            int j = f(tab[i],b,k);
            count[j] = count[j] - 1; 
            //System.out.print(count[tab[i]]);
            temp[count[j]] = tab[i]; 
        }
        for(int i=0;i<tab.length;i++)
            tab[i] = temp[i];
    
    }
    public static int f(int n,int b,int k){
        return  ((int)(n/Math.pow(b,k)) %b);
    }
    public static void radixSortBase10(int [] tab,int maxNum){
        int l =(int) Math.log10(maxNum+1)+1;
        for(int j = 0;j<l;j++){
            System.out.println(j);
            countSortBase(tab,10,j);
            print_array(tab);
        
        }
    }
    
    public static void print_array(int[] tab) {
        for(int j = 0;j<tab.length;j++){
            System.out.print(tab[j]+" ");
        }
        System.out.print("\n");
    }
    
}
