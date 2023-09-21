package Atividades;

import java.util.Arrays;

public class Dijkstra {
    private static final int INF = Integer.MAX_VALUE;


  public void dijkstra(int[][] graph, int source) {
    int n = graph.length;
    int[] dist = new int[n]; // array para armazenar a menor distancia
    boolean[] visitado = new boolean[n]; // array para marcar os nodes visitados
    Arrays.fill(dist, INF); // initializar a distancia como infinito
    dist[source] = 0; // distance do ponto de inicio é igual a 0

    for (int i = 0; i < n - 1; i++) {
      // selecione o vertice com a distancia minima
      int u = menorDistancia(dist, visitado);
      visitado[u] = true; // marca um vertice como visitado

      // for para updatear os valores de distancia na matriz adjacencia
      for (int v = 0; v < n; v++) {
        if (
          !visitado[v] &&
          graph[u][v] != 0 &&
          dist[u] != INF &&
          dist[u] + graph[u][v] < dist[v]
        ) {
          dist[v] = dist[u] + graph[u][v];
        }
      }
    }
    printDistances(dist, source); // print a menor distancia
  }

  // Função que calcula a menor distancia entre duas vertices
  private int menorDistancia(int[] dist, boolean[] visitado) {
    int minDist = INF;
    int minVertice = -1;
    for (int i = 0; i < dist.length; i++) {
      if (!visitado[i] && dist[i] < minDist) {
        minDist = dist[i];
        minVertice = i;
      }
    }
    return minVertice;
  }

  // Função que imprime o valor do menor caminho
  private void printDistances(int[] dist,int source) {
    System.out.printf("Menor distância (do vertice %d):\n", source);
    for (int i = 0; i < dist.length; i++) {
      System.out.println("Vertice " + i + ": " + dist[i]);
    }
  }

  public static void main(String[] args) {
    int[][] graph1 = {
      { 0, 2, 0, 1, 0, 3},
      { 2, 0, 4, 3, 0, 2},
      { 0, 4, 0, 0, 6, 1},
      { 1, 3, 0, 0, 5, 4},
      { 0, 0, 6, 5, 0, 2},
      { 3, 2, 1, 4, 2, 0}
    };
    Dijkstra dijkstra = new Dijkstra();
    dijkstra.dijkstra(graph1, 1);
  }
}
