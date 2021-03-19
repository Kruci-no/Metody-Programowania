



package algorytmkadana;
import java.util.Scanner;
class SubArray {
    int start;
    int end;
    int sum;
    public SubArray(){
        this.start = 0;
        this.end = 0;
        this.sum = 0;

    }
    void print (){
    System.out.println("start: "+this.start +" end: "+this.end+" sum = "+this.sum );

    }
}
public class AlgorytmKadana{


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int tab[] = readArray(scanner);
        //System.out.println(alKadnana_1(tab));
        SubArray maxSubArray = alKadnana_2(tab);
        maxSubArray.print();
        // TODO code application logic here
    }
    
    public static int alKadnana_1(int tab[]){
        int maxSum = 0;
        int prevSum = 0; //[j..i-1]
        for(int i=0;i<tab.length;i++){
            if(prevSum + tab[i]> maxSum){//[j..i]
                maxSum = prevSum + tab[i];
            }
            if(prevSum + tab[i]< 0){
                prevSum = 0;
            }
            else{
                prevSum = prevSum + tab[i];
            }
        }      
    return maxSum;
    }
    
    public static SubArray alKadnana_2(int tab[]){
        SubArray maxSubArray = new SubArray();
        SubArray prevSubArray= new SubArray();
    
        for(int i=0;i<tab.length;i++){
            if(prevSubArray.sum + tab[i]> maxSubArray.sum){
                maxSubArray.sum = prevSubArray.sum + tab[i];
                maxSubArray.end = i;
                maxSubArray.start = prevSubArray.start;
                
            }
            if(prevSubArray.sum + tab[i]< 0){
                prevSubArray.sum = 0;
                prevSubArray.start = i+1;
                prevSubArray.end = i;
            }
            else{
                prevSubArray.sum = prevSubArray.sum+ tab[i];
                prevSubArray.end = i;
                
            }
        }      
    return maxSubArray;
    }
     
    public static int[] readArray( Scanner scanner){
    int n = scanner.nextInt();
    int[] tab = new int[n];
    for(int i=0;i<tab.length;i++){
        tab[i]=scanner.nextInt();
        }
    
    return tab;
    }
    
}
