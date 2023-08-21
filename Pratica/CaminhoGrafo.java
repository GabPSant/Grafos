package Pratica;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

import Base.*;

public class CaminhoGrafo {
    static Grafo g = new Grafo();

    public static void buscaLargura(Vertice orig) {

        Queue<Vertice> fila = new LinkedList<>();
        fila.add(orig);

        while(fila.size() > 0) {

            Vertice atual = fila.remove();
            System.out.println("Vertice - " + atual.getNome());

            for(int i=0;i<g.getArestas().length;i++) {

                Aresta aux = g.getArestas()[i];
                if(aux.getInicio().getNome().equals(atual.getNome())) fila.add(aux.getDest());

            }

        }
    }

        public static void buscaProfundidade(Vertice orig) {

        Stack<Vertice> fila = new Stack<>();
        fila.add(orig);

        while(fila.size() > 0) {

            Vertice atual = fila.pop();
            System.out.println("Vertice - " + atual.getNome());

            for(int i=0;i<g.getArestas().length;i++) {

                Aresta aux = g.getArestas()[i];
                if(aux.getInicio().getNome().equals(atual.getNome())) fila.add(aux.getDest());

            }

        }
    }
    //Avalia 
    public static boolean isAppointed() {

        boolean res = false;
        int count = 0;

        for(int j=0;j<g.getArestas().length;j++) {

            Aresta atual = g.getArestas()[j];
            Vertice org = atual.getInicio();
            Vertice dest = atual.getDest();

            for(int i=0;i<g.getArestas().length;i++) {

                Aresta temp = g.getArestas()[i];
                Vertice orgT = temp.getInicio();
                Vertice destT = temp.getDest();

                if(orgT.getNome().equals(dest.getNome()) && destT.getNome().equals(org.getNome())) ++count;

            }
        }

        if(count==g.getArestas().length) res = true;

        return res;
    }

    public static void main(String[] args) {

        Vertice A = new Vertice("A");
        Vertice B = new Vertice("B");
        Vertice C = new Vertice("C");
        Aresta ab = new Aresta(A ,B, 0);
        Aresta ba = new Aresta(B, A, 0);
        Aresta bc = new Aresta(B, C, 0);
        Aresta cb = new Aresta(C, B, 0);

        Vertice[] vertices = {A, B, C};
        Aresta[] lines = {ab, bc, ba, cb};

        g.setVertices(vertices);
        g.setArestas(lines);
        
        System.out.println(CaminhoGrafo.isAppointed());
    }
}
