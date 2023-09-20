package Base;
import java.util.LinkedList;

public class Grafo {
    private LinkedList<Aresta> arestas = new LinkedList<>();
    private LinkedList<Vertice> vertices = new LinkedList<>();
    private boolean direcional = false;//defini que o grafo não é direcional (se uma aresta for criado, o caminho existe para ambos)

    public boolean getDirecional(){ return direcional;}

    public void eDirecional(){// Caso queira que o grafo seja direcional, é só usar essa função antes de definir as arestas
        this.direcional = true;
    }

    // Serve para checar se o grafo é não direcional
    public boolean checarNaoDirecional(){
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

    public void printVertices(){
        if(arestas.isEmpty() || vertices.isEmpty()) return;
        System.out.print("Lista de vertices: \n");
        for(Vertice v: vertices) System.out.printf("%s \n", v.getNome());
        System.out.println();
    }

    public LinkedList<Aresta> getArestas() {
        return this.arestas;
    }

    public Aresta getAresta(String s1, String s2){
        Aresta aresta = null;
        for(Aresta a: arestas)
            if(a.getInicio().getNome() == s1 && a.getDest().getNome() == s2) aresta = a;
    
        return aresta;
    }   

    public void setAresta(String s1, String s2) {
        if(getVertice(s1) == null || getVertice(s2) == null) return;
        Aresta a = new Aresta(getVertice(s1), getVertice(s2));
        for(Aresta ar: arestas) if(ar == a) return;
        arestas.add(a);
        if(!direcional){
            Aresta inversa = new Aresta(a.getDest(), a.getInicio());
            for(Aresta ar: arestas) if(ar == inversa) return;
            arestas.add(inversa);
        }
    }

    public LinkedList<Vertice> getVertices() {
        return this.vertices;
    }

    public Vertice getVertice(String s){
        Vertice vertice = null;
        for(Vertice v: vertices)
            if(v.getNome() == s) vertice = v;
        return vertice;
    }

    public void setVertice(String s) {
        Vertice v = new Vertice(s);
        for(Vertice ve: vertices) if(ve==v) return;
        vertices.add(v);
    }
}
