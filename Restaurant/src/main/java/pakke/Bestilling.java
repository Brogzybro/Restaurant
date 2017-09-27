package pakke;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;

/**
 * Created by BrageHalse on 21.09.2017.
 */
public class Bestilling {
    ArrayList<Rett> retter = new ArrayList<>();
    Restaurant restaurant;

    int nr;
    int antRettar = 0;

    public Bestilling(int nr){
        this.nr = nr;
    }

    public int getAntRettar(){
        return antRettar;
    }

    public int getNr(){
        return nr;
    }

    public boolean leggTilRett(Rett rett){
        if (rett.getId()>0){
            antRettar++;
        }
        retter.add(rett);
        return true;
    }

    public double bestillingPris(){
        double sum = 0;
        for (int i = 0; i <retter.size() ; i++) {
            sum += retter.get(i).getPris();
        }
        return sum;
    }

    public String toString(){
        String ut="bestilling nr:" + nr + " er:<br>\n";
        for (int i = 0; i <retter.size(); i++) {
            ut += retter.get(i).toString() + "<br>\n";
        }
        ut += "Pris: " + bestillingPris() + ",-<br>\n";
        return ut;
    }
}
