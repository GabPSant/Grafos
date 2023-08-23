package Atividades;
import Base.*;

public class RedePetri{
    private Grafo g = new Grafo();

    public RedePetri(Grafo g){
        this.g = g;
    }
    
    public String VerificarRedePetri(){
        boolean rede = false;

        return (rede == true)?"É uma rede de Petri":"Não é uma rede de Petri";
    }
}

class VerticePetri extends Vertice{
    private boolean tipo;

    public VerticePetri(String nome, boolean tipo){
        super(nome);
        this.tipo = tipo;
    }

    public String getTipo(){
        return (tipo == true)?"É uma transição":"É um lugar";
    }
    public void setTipo(boolean tipo){
        this.tipo = tipo;
    }
}