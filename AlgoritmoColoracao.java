import java.util.LinkedList;
import java.util.Arrays;
import java.util.Iterator;

public class AlgoritmoColoracao {
    private int v; // Número de vertices
    private LinkedList<Integer> adj[]; // Lista adjacente

    AlgoritmoColoracao(int v){
        this.v = v;
        adj = new LinkedList[v];
        for(int i = 0; i<v; i++)
            adj[i] = new LinkedList();
    }
    // Conecta duas regiões do mapa
    void adicionarAresta(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    void verticesColoridosPossiveis(){
        int resultado[] = new int[this.v];

        Arrays.fill(resultado, -1);
        resultado[0] = 0;
        // Contem a quantidade de cores possíveis
        boolean coresPosiveis[] = new boolean[this.v];
        Arrays.fill(coresPosiveis, true);

        for(int i = 0; i<this.v; i++){
            Iterator<Integer> it = adj[i].iterator();
            while(it.hasNext()){
                int index = it.next();
                if(resultado[index] != -1) coresPosiveis[resultado[index]] = false;
            }

            int x;
            for(x = 0; x<this.v; x++){
                if(coresPosiveis[x]) break;
            }

            resultado[i] = x;
            Arrays.fill(coresPosiveis,true);
        }
        //O for serve para printar o resultado
        for(int i = 0; i<this.v; i++){
            System.out.printf("Vertice %d ---> Cor %d\n", i, resultado[i]);
        }
    }

    public static void main(String[] args){
        AlgoritmoColoracao grafo = new AlgoritmoColoracao(6);
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 4);
        grafo.adicionarAresta(4, 5);
        grafo.adicionarAresta(5,3);
        System.out.println("Coloração do grafo");
        grafo.verticesColoridosPossiveis();
    }
}

