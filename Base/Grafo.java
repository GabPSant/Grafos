package Base;
public class Grafo {

    private Aresta arestas[];
    private Vertice vertices[];

    public void graphInit(int len) {
        arestas = new Aresta[len];
    }

    public Aresta[] getArestas() {
        return this.arestas;
    }

    public void setArestas(Aresta[] lines) {
        this.arestas = lines;
    }

    public Vertice[] getVertices() {
        return this.vertices;
    }

    public void setVertices(Vertice[] vertices) {
        this.vertices = vertices;
    }
}
