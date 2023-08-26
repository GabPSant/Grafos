package Base;
public class Aresta {

    private Vertice inicio, dest;
    int value = 0;

    public Vertice getInicio(){ return inicio;}

    public Vertice getDest(){ return dest;}

    public Aresta(Vertice inicio, Vertice dest) {
        this.inicio = inicio;
        this.dest = dest;
    }
    
}
