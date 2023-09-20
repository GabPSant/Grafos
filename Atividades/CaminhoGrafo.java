package Atividades;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.HashMap;
import Base.*;

public class CaminhoGrafo {
    Grafo g = null;

    public CaminhoGrafo(Grafo g){
        this.g = g;
    }

    public void buscaLargura(Vertice orig) {

        Queue<Vertice> fila = new LinkedList<>();
        fila.add(orig);
        System.out.println("\nBusca por largura: ");

        while(fila.size() > 0) {

            Vertice atual = fila.remove();
            System.out.println("Vertice - " + atual.getNome());

            for(int i=0;i<g.getArestas().size();i++) {

                Aresta aux = g.getArestas().get(i);
                if(aux.getInicio().getNome().equals(atual.getNome())) fila.add(aux.getDest());

            }

        }
    }

    public void buscaProfundidade(Vertice orig) {
        Stack<Vertice> fila = new Stack<>();
        fila.add(orig);
        System.out.println("\nBusca por profundidade: ");

        while(fila.size() > 0) {

            Vertice atual = fila.pop();
            System.out.println("Vertice - " + atual.getNome());

            for(int i=0;i<g.getArestas().size();i++) {

                Aresta aux = g.getArestas().get(i);
                if(aux.getInicio().getNome().equals(atual.getNome())) fila.add(aux.getDest());

            }

        }
    }
    //Conta a quantidade de arestas no grafo
    public void caminhosPossiveis() {
        int contador = 0;
        System.out.println("Lista de Arestas");
        for(Vertice i: g.getVertices()){
            for(Vertice j: g.getVertices()){
                if(g.getAresta(i.getNome(), j.getNome()) != null){
                    System.out.printf("%s -> %s\n", i.getNome(), j.getNome());
                    contador++;
                }
            }
        }
        if(!g.getDirecional()) contador /= 2;
        System.out.printf("Quantidade de arestas: %d\n", contador);
        System.out.println();
    }

    public void caminhoEuler(){// Como eu crio um algoritmo para avaliar cada elemento e encontrar se é possível encontrar se
        //é possível caminhar de um vertice para cada vertice do grafo
        int u  = 0;// Encontrar o vertice com 
        
    }

    public static void main(String[] args) {
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

        CaminhoGrafo caminho = new CaminhoGrafo(g);
        caminho.caminhosPossiveis();
        System.out.println(g.checarNaoDirecional());
        //caminho.buscaLargura(g.getVertice("C"));
        //caminho.buscaProfundidade(g.getVertice("A"));
    }
}
