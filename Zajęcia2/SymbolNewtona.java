
package symbolnewtona;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class SymbolNewtona {

    static int k;
    static int n;
    static int tab[][];
      
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        tab = new int[n+1][k+1]; 
        init();
        System.out.println(computeNetonSymbol(n,k));
        
        // TODO code application logic here
    }
    public static void init(){
        for(int i=0;i<=n;i++)
            for(int j=0;j<=k;j++)
                tab[i][j]= -1;
        
        
        for(int i=0;i<=n;i++){
            tab[i][0] = 1;
        }
        for(int i=0;i<=k;i++){
            tab[i][i] = 1;
        }
        
    }
    public static int computeNetonSymbol(int n, int m){
        if(tab[n][m] != -1)
            return tab[n][m];
        else{
            tab[n][m] = computeNetonSymbol(n-1,m-1)+ computeNetonSymbol(n-1,m);
        }
        return tab[n][m];                
    }   
}
