package Base;

// True -> Possivel | False -> Impossivel
public class Ponte {

    Ilha inicio, fim;
    private boolean passado = false;

    public Ponte(Ilha inicio, Ilha fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public boolean getPassado(){
        return this.passado;
    }

    public void setPassado(boolean passado){
        this.passado = passado;
    }

    public Ilha getInicio(){
        return this.inicio;
    }

    public Ilha getFim(){
        return this.fim;
    }
}
