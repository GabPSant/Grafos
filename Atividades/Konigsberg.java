package Atividades;
import Base.Ponte;
import Base.Ilha;
import java.util.*;

public class Konigsberg {

    private ArrayList<Ilha> ilhas = new ArrayList<>();
    private ArrayList<Ponte> pontes = new ArrayList<>();

    public ArrayList<Ilha> getIlhas(){
        return ilhas;
    }

    public ArrayList<Ponte> getPontes(){
        return pontes;
    }

    public boolean passear() {

        Ilha atual = ilhas.get(0);
        int countFalse = 0;
        int countTrue = 0;

        boolean res = true;

        while(countFalse<pontes.size()) {

            countFalse = 0;
            countTrue = 0;

            for(int j=0;j<pontes.size();j++) {

                if(pontes.get(j).getInicio().getNome().equals(atual.getNome()) && !pontes.get(j).getPassado()) {

                    atual = pontes.get(j).getInicio();
                    pontes.get(j).setPassado(true);
                    break;

                } else if(pontes.get(j).getFim().getNome().equals(atual.getNome()) && !pontes.get(j).getPassado()) {

                    atual = pontes.get(j).getFim();
                    pontes.get(j).setPassado(true);
                    break;

                }

                ++countFalse;
                if(countFalse==pontes.size()) res = false;

            }

                for(int k=0;k<pontes.size();k++) {
                    if(pontes.get(k).getPassado()) ++countTrue;
                }

                if(countTrue==pontes.size()) break;

        }

        return res;
    }

    public static void main(String[] args) {
        
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

        k.ilhas.add(a);
        k.ilhas.add(b);
        k.ilhas.add(c);
        k.ilhas.add(d);

        k.pontes.add(p1);
        k.pontes.add(p2);
        k.pontes.add(p3);
        k.pontes.add(p4);
        k.pontes.add(p5);
        k.pontes.add(p6);
        k.pontes.add(p7);

        System.out.println(k.passear());

    }
}
