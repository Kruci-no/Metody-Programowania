
package javaapplication29;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


class Vertex
{
String label;
int index;
boolean wasVisited;
Vertex(String label,int index){
    this.index = index;
    this.label = label;
    this.wasVisited = false;
}
}
class Graph{
    int maxVertexNum;
    int currentVertexNum;
    Vertex tab[];
    int [][] adMatrix;
    Graph(int maxVertexNum){
        this.adMatrix = new int[maxVertexNum][maxVertexNum];
        this.currentVertexNum = 0;
        this.maxVertexNum = maxVertexNum;
        this.tab = new Vertex[maxVertexNum];
    }
    void addVertex(String label){
        tab[currentVertexNum] = new Vertex(label,currentVertexNum);
        currentVertexNum++;
    }
    void addDirectedEgde(int i, int j){
        adMatrix[i][j] = 1;
    }
    void addEgde(int i, int j){
        adMatrix[i][j] = 1;
        adMatrix[j][i] = 1;
    }
    void restartVisit(){
        for(int i=0;i<currentVertexNum;i++){
            tab[i].wasVisited = false;
        
        }
    
    }
    void DFS(){
        if(currentVertexNum==0)
            return;
        Vertex v = tab[0];
        Stack<Vertex> stack = new Stack();
        stack.push(v);
        v.wasVisited = true;
        while(!stack.empty()){
            v = stack.pop();
            System.out.print(v.label+":"+v.index + " ");         
            for(int i=0;i<currentVertexNum;i++){
               if(adMatrix[v.index][i]!= 0 && tab[i].wasVisited==false){
                   tab[i].wasVisited = true;
                   stack.push(tab[i]);
               } 
            }  
        }
        restartVisit();
    }
    void BFS(){
        if(currentVertexNum==0)
            return;
        Vertex v = tab[0];
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(v);
        v.wasVisited = true;
        while(!queue.isEmpty()){
            v = queue.remove();
            System.out.print(v.label+":"+v.index + " ");
            for(int i=0;i<currentVertexNum;i++){
               if(adMatrix[v.index][i]!= 0 && tab[i].wasVisited==false){
                   tab[i].wasVisited = true;
                   queue.add(tab[i]);
               } 
            }  
        }
        restartVisit();
    
    }

}
public class JavaApplication29 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Graph graph = new Graph(10);
       graph.addVertex("0");
       graph.addVertex("1");
       graph.addVertex("2");
       graph.addVertex("3");
       graph.addVertex("4");
       graph.addVertex("5");
       graph.addEgde(0, 1);
       graph.addEgde(0, 4);
       graph.addEgde(1, 4);
       graph.addEgde(1, 2);
       graph.addEgde(2, 3);
       graph.addEgde(3, 4);
       graph.addEgde(3, 5);
       System.out.println("Przeszukiwanie w wszerz ");
       graph.BFS();
       System.out.println("\nPrzeszukiwanie w gląb");
       graph.DFS();
       System.out.println();
       
        
    }
    
}
