import Atividades.*;
import Base.*;

public class Main {
    //Grafo de teste 1
    static Grafo g1 = new Grafo();
    static void grafo1(){
        g1.setVertice("1");
        g1.setVertice("2");
        g1.setVertice("3");
        g1.setVertice("4");
        g1.setVertice("5");

        g1.setAresta("1", "2");
        g1.setAresta("1", "5");
        g1.setAresta("2", "4");
        g1.setAresta("2", "5");
        g1.setAresta("3", "4");
        g1.setAresta("3", "1");
        g1.setAresta("3", "5");
        g1.setAresta("4", "1");
        g1.setAresta("5", "4");
        g1.setAresta("4", "5");
    }
    //Grafo de teste 2
    static Grafo g2 = new Grafo();
    static void grafo2(){
        g2.eDirecional(); //Define que o gráfico 2 é direcional
        g2.setVertice("1");
        g2.setVertice("2");
        g2.setVertice("3");
        g2.setVertice("4");
        g2.setVertice("5");

        g2.setAresta("1", "2");
        g2.setAresta("2", "1");
        g2.setAresta("3", "5");
        g2.setAresta("4", "1");
        g2.setAresta("4", "2");
        g2.setAresta("5", "2");
        g2.setAresta("2", "5");
        g2.setAresta("3", "2");
        g2.setAresta("1", "5");
        g2.setAresta("2", "3");
    }

    static int[][] dijkstraTeste1(){
        int[][] teste1 = {
         //  0  1  2  3  4   
      /*0*/ {0, 2, 0, 1, 3},
      /*1*/ {2, 0, 4, 3, 2},
      /*2*/ {0, 4, 0, 0, 6},
      /*3*/ {1, 3, 0, 0, 5},
      /*4*/ {3, 2, 6, 5, 0},
        };
        return teste1;
    }
    static int[][] dijkstraTeste2(){
        int[][] teste2 = {
         //  1  2  3  4  5   
      /*1*/ {0, 4, 7, 3, 2},
      /*2*/ {4, 0, 5, 2, 0},
      /*3*/ {7, 5, 0, 5, 1},
      /*4*/ {3, 2, 5, 0, 2},
      /*5*/ {2, 0, 1, 2, 0},
        };
        return teste2;
    }
    static void mapaColoracao1(){
        AlgoritmoColoracao grafoColoracao1 = new AlgoritmoColoracao(5);
        grafoColoracao1.adicionarAresta(0, 1);
        grafoColoracao1.adicionarAresta(0, 2);
        grafoColoracao1.adicionarAresta(1, 2);
        grafoColoracao1.adicionarAresta(0, 4);
        grafoColoracao1.adicionarAresta(0,3);
        grafoColoracao1.adicionarAresta(1, 3);
        grafoColoracao1.adicionarAresta(2, 3);
        grafoColoracao1.adicionarAresta(3, 4);

        grafoColoracao1.verticesColoridos();
    }

    static void mapaColoracao2(){
        AlgoritmoColoracao grafoColoracao2 = new AlgoritmoColoracao(5);
        grafoColoracao2.adicionarAresta(0, 1);
        grafoColoracao2.adicionarAresta(0, 3);
        grafoColoracao2.adicionarAresta(1, 4);
        grafoColoracao2.adicionarAresta(1, 4);
        grafoColoracao2.adicionarAresta(2,3);
        grafoColoracao2.adicionarAresta(1, 4);
        grafoColoracao2.adicionarAresta(2, 3);
        grafoColoracao2.adicionarAresta(3, 4);

        grafoColoracao2.verticesColoridos();
    }

    static boolean konigsberg(){
        Konigsberg k = new Konigsberg();

        Ilha a = new Ilha("A");
        Ilha b = new Ilha("B");
        Ilha c = new Ilha("C");
        Ilha d = new Ilha("D");

        Ponte p1 = new Ponte(a, c);
        Ponte p2 = new Ponte(a, c);
        Ponte p3 = new Ponte(a, d);
        Ponte p4 = new Ponte(c, d);
        Ponte p5 = new Ponte(a, b);
        Ponte p6 = new Ponte(a, b);
        Ponte p7 = new Ponte(b, d);

        k.getIlhas().add(a);
        k.getIlhas().add(b);
        k.getIlhas().add(c);
        k.getIlhas().add(d);

        k.getPontes().add(p1);
        k.getPontes().add(p2);
        k.getPontes().add(p3);
        k.getPontes().add(p4);
        k.getPontes().add(p5);
        k.getPontes().add(p6);
        k.getPontes().add(p7);

        return k.passear();
    }

    public static void main(String[] args){//Testes para a questão 5
        //Questão 1 - Código se encontra na pasta Atividades, nome do arquivo: Matriz.java

        System.out.println("Questão 1:\n");
        System.out.print("(Grafo 1) ");
        grafo1();
        Matriz matriz1 = new Matriz(g1);
        matriz1.mostrarMatriz();
        System.out.println();

        System.out.print("(Grafo 2) ");
        grafo2();
        Matriz matriz2 = new Matriz(g2);
        matriz2.mostrarMatriz();
        System.out.println();

        //Questão 2 - Código se encontra na pasta Atividades, nome do arquivo: Konigsberg.java
        
        System.out.println("Questão 2\n");
        System.out.println("O problema de Konigsberg tem solução?\nR: " + konigsberg());
        System.out.println();

        //Questão 3 - Código se encontra na pasta Atividades, nome do arquivo: Dijkstra.java

        System.out.println("Questão 3\n");
        Dijkstra dijkstra = new Dijkstra();
        System.out.println("Dijkstra, teste 1:\n");
        dijkstra.dijkstra(dijkstraTeste1(), 2);
        System.out.println();
        System.out.println("Dijkstra, teste 2:\n");
        dijkstra.dijkstra(dijkstraTeste2(), 4);
        System.out.println();

        // Questão 4 - Código se encontra na pasta Atividades, nome do arquivo: AlgoritmoColoracao.java

        System.out.println("Questão 4\n");
        System.out.println("Mapa de Coloração, teste 1 (Grafo 1):\n");
        mapaColoracao1();
        System.out.println();
        System.out.println("Mapa de Coloração, teste 2 (Grafo 2):\n");
        mapaColoracao2();
        System.out.println();

        //(Códigos suplementares na pasta Base: Grafo.java, Vertice.java, Aresta.java, Ilha.java e Ponte.java)
    }
}
