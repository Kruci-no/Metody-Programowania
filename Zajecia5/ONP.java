/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

/**
 *
 * @author User
 */

class StackArray {
    public int maxSize; 
    public char[] Elem; 
    public int top; 
    public StackArray(int size) { // konstruktor - Create() 
        maxSize = size; // ustawiamy rozmiar tablicy 
        Elem = new char[maxSize]; // tworzymy tablicę dla elementów 
        top = maxSize; // na razie brak elementów (rośnie w górę) 
    }
    public void push(char x) { 
        if(isFull()) System.out.println("stos jest pelny"); 
        else Elem[--top] = x; 
    }
    public char pop(){ // usuwa element ze szczytu stosu
       return Elem[top++]; // pobieramy element i zwiększamy top 
    }
    public char top(){ // zwraca wartość na szczycie stosu 
        return Elem[top]; 
    }
    public boolean isEmpty(){ // zwraca true, jeżeli stos pusty 
        return (top == maxSize); 
    } 
    public boolean isFull(){ // zwraca true, jeżeli stos pełny
        return (top == 0); 
    }
    public void clear(){
        top=maxSize;
    }
    public void print(){
        System.out.print("Stos:");
        for(int i = maxSize-1; i>= top;i--){
            System.out.print(Elem[i]+" ");
        }
        System.out.println();
    }
}
public class ONP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(zamiana_na_ONP("(a+b)*c"));
        // TODO code application logic here
    }
    public static boolean czy_operad(char znak){
        for(int i=0;i<26;i++){
            if('a'+i==znak)
                return true;
        }
        return false;
            
    }
    
    public static String zamiana_na_ONP(String g){
        char znak;
        String wynik = new String ();
        StackArray stack = new StackArray(256);
        for(int i=0;i<g.length();i++){
            znak = g.charAt(i);
            if (znak=='(')
            {
                stack.push('(');
            }
            else if (czy_operad(znak)){
                wynik = wynik + znak;
            }
            else if (znak==')'){
                while(stack.top() != '('){
                    wynik = wynik + stack.pop();
                
                }
            stack.pop();
            }
            else {
                
                while(!stack.isEmpty()&& priorytet(stack.top()) >= priorytet(znak)){
                wynik = wynik + stack.pop();
                }
                stack.push(znak);
                    
            }
        
        }
        while(!stack.isEmpty()){
            wynik = wynik + stack.pop();
        }
        return wynik;
    }
    public static int priorytet(char znak){
        if(znak=='*' ||znak=='/'||znak=='%')
            return 1;
        if(znak=='+'||znak=='-')
            return 0;
        return -1;
}
    
}
