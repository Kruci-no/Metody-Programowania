
package javaapplication13;

public class Sortowania {

    public static void main(String[] args) {
        int[] tab1 = {1,2,4,5,3,5,6,-2,-22,5,3,2,6,7,6,7,1,2,4,0,0};
        int[] tab2 = {1,2,4,5,3,5,6,-2,-22,5,3,2,6,7,6,7,1,2,4,0,0};
        System.out.println("Quick Sort");
        quick_sort(tab1);
        print_array(tab1);
        System.out.println("Merge Sort");
        int[] tab3 = merge_sort(tab2);
        print_array(tab3);

    }
    public static int[] merge_sort(int[] tab){
        if(tab.length == 1){
            return tab;
        }
        int l = tab.length/2;
        int tab1[] = new int[l];
        int tab2[] = new int[tab.length - l];
        int i=0;
        while(i<l){
            tab1[i] = tab[i];
            i = i+1;
        }
        while(i<tab.length){
            tab2[i-l] = tab[i];
            i = i+1;
        }
        tab1 = merge_sort(tab1);
        tab2 = merge_sort(tab2);
        tab = merge(tab1,tab2);
        return tab;
    
    }
    public static int[] merge(int[] tab1,int[] tab2){
        int[] tabM = new int[tab1.length+tab2.length];
        int i1=0; int i2=0;
        while(i1<tab1.length && i2<tab2.length ){
            if(tab1[i1] < tab2[i2]){
                tabM[i1+i2] = tab1[i1];
                i1 = i1+1;
            }
            else{
                tabM[i1+i2] = tab2[i2];
                i2 = i2+1;
            }

        }
        while(i1<tab1.length ){
            tabM[i1+i2] = tab1[i1];
            i1 = i1+1;
        }
        while(i2<tab2.length ){
            tabM[i1+i2] = tab2[i2];
            i2 = i2+1;
        }
        return tabM;
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
    public static void quick_sort(int[] tab){
        quick_sort(tab,0,tab.length-1);
    }
    public static void quick_sort(int[] tab,int L,int R){
        if(L>=R)
            return;
    int i = partition(tab,L,R);
    quick_sort(tab,L,i-1);
    quick_sort(tab,i+1,R);
    }
    public static void swap(int[] tab,int i,int j){
        int temp=tab[i];
        tab[i]=tab[j];
        tab[j]=temp;
    }
    public static void print_array(int[] tab) {
    // TODO code application logic here
        for(int j = 0;j<tab.length;j++){
            System.out.print(tab[j]+" ");
        }
        System.out.print("\n");
    }
}
