package pakke;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by BrageHalse on 21.09.2017.
 */
public class Reservasjon {
    private String navn;
    private String startS; //dd MMM yyyy HH:mm -- 04 Jul 2001 12:08
    private String slutt; //dd MMM yyyy HH:mm -- 04 Jul 2001 12:08
    private int maxRettar;
    private int antPers;
    private int resId;
    ArrayList<Bestilling> bestillinger = new ArrayList<>();
    private int teller = 0;

    public Reservasjon(String navn, String startS, String slutt, int antPers, int resId){
        this.navn=navn;
        this.startS = startS;
        this.slutt = slutt;
        this.antPers = antPers;
        this.resId = resId;
    }

    public int getResId(){
        return resId;
    }
    public void setResId(int i){
        resId = i;
    }
    public int getAntPers(){
        return antPers;
    }

    public Bestilling nyBestilling(){
        Bestilling best = new Bestilling(teller);
        bestillinger.add(best);
        teller++;
        for (int i = 0; i <bestillinger.size() ; i++) {
            if (best.antRettar>maxRettar){
                maxRettar = best.antRettar;
            }
        }
        return best;
        /*
        DateFormat f = new SimpleDateFormat("dd MMM YYYY HH:mm");
        Date st = null;
        try{
            st = f.parse(startS);
        }catch (ParseException e){
            System.out.println("parse exeption");
        }
        long oneMin = 60000;
        long star = st.getTime();

        slutt = new Date(star + (maxRettar * oneMin));*/
    }

    public Bestilling getBestilling(int nr){
        Bestilling bes = null;
        for (int i = 0; i < bestillinger.size(); i++) {
            if (bestillinger.get(i).getNr()==nr){
                bes = bestillinger.get(i);
                return bes;
            }
        }
        return bes;
    }

    public String getStart() {
        return startS;
    }

    public String getSlutt() {
        return slutt;
    }


    public boolean ledig(String start2, String slutt2) {
        DateFormat f = new SimpleDateFormat("dd MMM YYYY HH:mm");
        Date st = null;
        Date sl = null;
        Date st2 = null;
        Date sl2 = null;
        try {
            st = f.parse(startS);
            sl = f.parse(slutt);
            st2 = f.parse(start2);
            sl2 = f.parse(slutt2);
        } catch (ParseException e) {
            System.out.println("Error parse to date");
        }
        if ((st2.after(st)||st2.equals(st) && st2.before(sl)) || (sl2.after(st)) && sl2.before(sl) || sl2.equals(sl)) { //sjekker om tid2 everlapper reservasjonen
            return false;
        } else {
            return true;
        }
    }

    public String toString(){
        String ut = "Reservasjon på: '"+navn+"' fra " + startS + " til " + slutt +"<br>\n" ;
        for (int i = 0; i < bestillinger.size(); i++) {
            ut+= bestillinger.get(i).toString() + "<br>\n";
        }
        return ut;
    }
}
