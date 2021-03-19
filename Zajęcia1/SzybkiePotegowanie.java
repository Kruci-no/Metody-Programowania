/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;


public class SzybkiePotegowanie {

    public static void main(String[] args) {
         
        Scanner scanner = new Scanner(System.in);
        int p;
        int a; 
        a = scanner.nextInt();
        p = scanner.nextInt();
        int wynik = 1;
        while (p>0){
            if(p%2 == 1)
            {
                 wynik = wynik * a;
            }
            p = p/2;
            a = a * a;
             
         }
    System.out.println(wynik); 
    }

}

