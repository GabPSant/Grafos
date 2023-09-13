package Atividades;
import Base.Grafo;
import Base.Vertice;

public class MatrizLista {
    private Grafo g = null;
    
    public MatrizLista(Grafo g){
        this.g = g;
    }

    public void mostrarMatriz(){
        if(g.getArestas().isEmpty() || g.getVertices().isEmpty()){
            System.out.println("O grafo está vázio");
            return;
        }
        for(int i = 0; i<g.getVertices().size(); i++){
            if(i == 1){
                System.out.print("  |");
                for (Vertice x: g.getVertices()) System.out.printf(" %s |", x.getNome());
            }
            System.out.printf("%s |");
            //for() Pensar em uma forma de saber as quantidades de conexões um array tem, veja o repositório 'Estruturas de Dados'
        }
    }

    public void mostrarLista(){

    }

    public static void main(String[] args){
        Grafo g = new Grafo();
        g.setVertice(new Vertice("A"));
        g.setVertice(new Vertice("B"));
        g.setVertice(new Vertice("C"));


        MatrizLista matriz = new MatrizLista(g);
        matriz.mostrarMatriz();
    }
}
