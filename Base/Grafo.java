package Base;
import java.util.ArrayList;

public class Grafo {
    private ArrayList<Aresta> arestas = new ArrayList<>();
    private ArrayList<Vertice> vertices = new ArrayList<>();
    private boolean direcional = false;//defini que o grafo não é direcional (se uma aresta for criado, o caminho existe para ambos)

    public void eDirecional(){// Caso queira que o grafo seja direcional, é só usar essa função antes de definir as arestas
        this.direcional = true;
    }

    // Serve para checar se o grafo é não direcional
    public boolean eNaoDirecional(){
        if(arestas.size()%2 != 0 || direcional) return false;
        Aresta[] arrayTeste = arestas.toArray(new Aresta[0]);
        int contador = 0;
        // Pensar na ideia de um contador que avalie o conjunto do array encontre se todos os valores são reflexos um do outro
        for(int i = 0; i<arrayTeste.length;i++){
            if(i+1 == arrayTeste.length) break;
            for(int j = 1; j<arrayTeste.length; j++){
                if((arrayTeste[i].getInicio() == arrayTeste[j].getDest())&&(arrayTeste[i].getDest() == arrayTeste[j].getInicio()))
                    contador++;
            }
        }
        System.out.println(contador);
        return (contador == arrayTeste.length/2)?true:false;
    }

    public void printGrafo(){
        if(arestas.isEmpty() || vertices.isEmpty()) return;
        System.out.print("Lista de vertices: ");
        for(Vertice v: vertices) System.out.printf("%s ", v.getNome());
        System.out.println("\n\nLista de arestas:");
        for(Aresta a: arestas) System.out.printf("  %s --> %s\n", a.getInicio().getNome(), a.getDest().getNome());
    }

    public ArrayList<Aresta> getArestas() {
        return this.arestas;
    }
    public Vertice getVertice(String s){
        Vertice vertice = null;
        for(Vertice v: vertices)
            if(v.getNome() == s) vertice = v;
        return vertice;
    }
    public void setAresta(Aresta a) {
        for(Aresta ar: arestas) if(ar == a) return;
        arestas.add(a);
        if(!direcional){
            Aresta inversa = new Aresta(a.getDest(), a.getInicio());
            for(Aresta ar: arestas) if(ar == inversa) return;
            arestas.add(inversa);
        }
    }

    public ArrayList<Vertice> getVertices() {
        return this.vertices;
    }

    public void setVertice(Vertice v) {
        for(Vertice ve: vertices) if(ve==v) return;
        vertices.add(v);
    }
}
