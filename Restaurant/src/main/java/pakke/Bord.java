package pakke;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by BrageHalse on 21.09.2017.
 */
public class Bord {
    private int bordnr;
    private int maxAntPers;
    private ArrayList<Reservasjon> reservasjoner = new ArrayList<>();

    public Bord(int bordnr, int maxAntPers){
        this.bordnr = bordnr;
        this.maxAntPers = maxAntPers;
    }

    public int getMaxAntPers(){
        return maxAntPers;
    }

    public int getBordnr(){
        return bordnr;
    }

    public boolean reserverBord(Reservasjon res){
        if (checkLedig(res)){
            reservasjoner.add(res);
            return true;
        }else{
            return false;
        }
    }
    public Reservasjon getReservasjon(int resId){
        Reservasjon res = null;
        for (int i = 0; i <reservasjoner.size() ; i++) {
            if (reservasjoner.get(i).getResId()==resId){
                return res = reservasjoner.get(i);
            }
        }return res;
    }

    public boolean checkLedig(Reservasjon res){
        for (int i= 0; i <reservasjoner.size() ; i++) {
            if (reservasjoner.get(i).ledig(res.getStart(), res.getSlutt())==false){
                return false;
            }
        }
        return true;
    }

    public String toString(){
        String ut ="Bordnr: " + bordnr +"<br>\n";
        for (int i = 0; i <reservasjoner.size() ; i++) {
            ut+="   " + reservasjoner.get(i).toString() + "<br>\n";
        }
        return ut;
    }

}
