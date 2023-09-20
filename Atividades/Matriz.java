package Atividades;
import Base.*;

public class Matriz {
    private Grafo g = null;
    
    public Matriz(Grafo g){
        this.g = g;
    }

    public void mostrarMatriz(){
        if(g.getArestas().isEmpty() || g.getVertices().isEmpty()){
            System.out.println("O grafo está vázio");
            return;
        }
        System.out.println("Matriz de Adjacência:\n");
        for(int i = 0; i<g.getVertices().size(); i++){
            if(i == 0){
                System.out.print("  |");
                for (Vertice x: g.getVertices()) System.out.printf(" %s |", x.getNome());
                System.out.println();
            }
            System.out.printf("%s |", g.getVertices().get(i).getNome());
            for(Vertice a: g.getVertices()) 
                System.out.printf(" %d |", (g.getAresta(g.getVertices().get(i).getNome(), a.getNome()) == null)?0:1);
            System.out.println();
        }
    }

    public static void main(String[] args){
        Grafo g = new Grafo();
        g.setVertice("A");
        g.setVertice("B");
        g.setVertice("C");
        //g.eDirecional();
        g.setAresta("A", "B");
        g.setAresta("B", "C");
        g.setAresta("A", "C");
        g.setAresta("D", "B");
        g.printVertices();

        Matriz matriz = new Matriz(g);
        matriz.mostrarMatriz();
    }
}
