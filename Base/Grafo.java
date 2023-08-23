package Base;
import java.util.ArrayList;
import java.util.Arrays;

public class Grafo {
    private Aresta arestas[];
    private Vertice vertices[];

    public void graphInit(int len) {
        arestas = new Aresta[len];
    }

    public Aresta[] getArestas() {
        return this.arestas;
    }
    public Vertice getVertice(String s){
        Vertice vertice = null;
        ArrayList<Vertice> tempLista = new ArrayList<>(Arrays.asList(vertices));
        for(Vertice v: tempLista)
            if(v.getNome() == s) vertice = v;
        return vertice;
    }

    public void setAresta(Aresta a) {
        ArrayList<Aresta> tempLista = new ArrayList<>(Arrays.asList(arestas));
        tempLista.add(a);
        this.arestas = tempLista.toArray(arestas);
    }

    public Vertice[] getVertices() {
        return this.vertices;
    }

    public void setVertice(Vertice v) {// Resolver o problema do NullPointer
        if(vertices != null)
            ArrayList<Vertice> tempLista = new ArrayList<>(Arrays.asList(vertices));
        else{
            ArrayList<Vertice> tempLista = new ArrayList<>();
        }
        tempLista.add(v);
        this.vertices = tempLista.toArray(vertices);
    }
}
