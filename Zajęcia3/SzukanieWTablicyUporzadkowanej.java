/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szukaniebinarne;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class SzukanieBinarne {
        // TODO code application logic here
    public static void main(String[] args) {
    // TODO code application logic here
    Scanner scanner = new Scanner(System.in);
    int[] tab;
    int n = scanner.nextInt();
    tab = new int[n];
    read_array(tab,scanner); //Zakładamy, że tablica jest uporządkowana tab[i]<=tab[j] dla i<j
    int a = scanner.nextInt(); //szukany element tablicy
    System.out.println(binarySearch(tab,a));
    System.out.println(interpolationSearch(tab,a));
    
    
    
    
    }
    public static int binarySearch(int[] tab,int a){
        int start = 0;
        int end = tab.length-1;
        int i;
        while(start <= end)
        {
            i = start+(end-start+1)/2;
            if(tab[i]==a)
                return i;
            if(tab[i]<a){
                start = i+1;
            }
            else{
                end = i-1;
            }
           
        }
        return -1;
    
    }
    public static int interpolationSearch(int[] tab,int a){
        int start = 0;
        int end = tab.length - 1;
        //To avoid divition by zero
        if(tab[start] == a){
            return start;
        }
        if(tab[start]>a)
            return -1;
        
        
        while(start<end){
            int inter = start + (a - tab[start]) *(end - start) /(tab[end]-tab[start]);
            if(tab[inter]==a){
                return inter;
            }
            else if (tab[inter]<a){
                start = inter+1;
            }
            else {
                end = inter-1; 
            }  
        }   
        return -1;
    }
    
    public static void read_array(int[] tab,Scanner scanner) {
    // TODO code application logic here
    for(int j = 0;j<tab.length;j++){
        tab[j] = scanner.nextInt();
    }     
    }
    
}
