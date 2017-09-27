package pakke;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;

/**
 * Created by BrageHalse on 21.09.2017.
 */
public class Restaurant {
    ArrayList<Bord> alleBord = new ArrayList<>();
    public ArrayList<Rett> alleRettar = new ArrayList<>();
    public ArrayList<Reservasjon> reservasjoner = new ArrayList<>();
    private String resNavn;
    public int reservasjonsTeller = 0;

    public Restaurant(String resNavn) {
        this.resNavn = resNavn;
    }

    public String getResNavn() {
        return resNavn;
    }

    public ArrayList<Rett> getRettar() {
        return alleRettar;
    }

    public boolean regNyttBord(String nrBord) {
        String[] split = nrBord.split(",");
        int bordnr = Integer.parseInt(split[0].trim());
        int maxAntPers = Integer.parseInt(split[1].trim());
        for (int i = 0; i < alleBord.size(); i++) {
            if (alleBord.get(i).getBordnr() == bordnr) {
                return false;
            }
        }
        Bord b = new Bord(bordnr, maxAntPers);
        alleBord.add(b);
        return true;
    }

    public Reservasjon getReservasjon(int resId) {
        return reservasjoner.get(resId);
    }

    public Rett getRett(int rettId) {
        Rett r = null;
        for (int i = 0; i < alleRettar.size(); i++) {
            if (alleRettar.get(i).getId() == rettId) {
                r = alleRettar.get(i);
                return r;
            }
        }
        return r;
    }

    public String menyToString(){
        String ut="<h2> Meny </h2> <br> \n";
        for (int i = 0; i <alleRettar.size() ; i++) {
            ut+= alleRettar.get(i).toString() + "<br> \n";
        }
        return ut;
    }

    public String getMeny(){
        String ut ="<h2> Bestill din mat </h2><br> \n";
        for (int i = 0; i < alleRettar.size(); i++) {
            ut+= alleRettar.get(i).getNavn() + " pris: "+alleRettar.get(i).pris+ ",- <input id='rett"+alleRettar.get(i).getId()+"' type='number' class='form-control'> <br>";
        }
        return ut;
    }

    public boolean regNyRett(String rett) {
        String[] total = rett.split(",");
        int rettId = Integer.parseInt(total[0].trim());
        String navn = total[1];
        String beskrivelse = total[2];
        double pris = Double.parseDouble(total[3].trim());
        for (int i = 0; i < alleRettar.size(); i++) {
            if (alleRettar.get(i).getId() == rettId) {
                return false;
            }
        }
        Rett r = new Rett(rettId, navn, beskrivelse, pris);
        alleRettar.add(r);
        return true;
    }

    public int reserverBord(String total) { //dd MMM yyyy HH:mm -- 04 Jul 2001 12:08
        String[] tot = total.split(",");
        String navn = tot[0];
        String start = tot[1].trim();
        String slutt = tot[2].trim();
        System.out.println(tot[3]);
        String tal = tot[3].replaceAll(" ", "");
        System.out.println(tal);
        int ant = Integer.parseInt(tal);
        System.out.println(ant);
        Reservasjon res = new Reservasjon(navn, start, slutt, ant, 0);
        int nr = 0;
        res.setResId(reservasjonsTeller);
        for (int i = 0; i < alleBord.size(); i++) {
            if ((alleBord.get(i).getMaxAntPers() >= res.getAntPers()) && alleBord.get(i).checkLedig(res)) {
                alleBord.get(i).reserverBord(res);
                nr = alleBord.get(i).getBordnr();
                reservasjoner.add(alleBord.get(i).getReservasjon(reservasjonsTeller));
                reservasjonsTeller++;
                break;
            }
        }
        return nr;
    }


    public String toString() {
        String ut = "<h1>Oversikt:</h1> <br>\n";
        for (int i = 0; i < alleBord.size(); i++) {
            ut += alleBord.get(i).toString();
        }
        return ut;
    }

    public static void main(String[] args) {
        Restaurant res = new Restaurant("res2ran");
        res.regNyttBord("1,6");
        res.regNyttBord("2,5");
        res.regNyttBord("2,1");
        res.regNyttBord("3,10");
        res.regNyttBord("4,5");
        Reservasjon res1 = new Reservasjon("Brage", "21 Sep 2017 15:30", "21 Sep 2017 16:30", 4, 0);
        Reservasjon res2 = new Reservasjon("Brage", "21 Sep 2017 15:30", "21 sep 2017 16:00", 8, 0);
        Reservasjon res3 = new Reservasjon("Brage", "21 Sep 2017 15:30", "21 Sep 2017 16:30", 4, 0);
        res.reserverBord("Brage, 21 Sep 2017 15:30, 21 Sep 2017 16:30, 4");
        System.out.println(res.toString());/*//*
        res.regNyRett(1, "Kjøttkaker", "Kjøttkaker i brun saus.", 80);
        res.regNyRett(2, "Laks", "laks med poteter.", 75);
        res.regNyRett(-1, "Cola", "0,5L Cola.", 30);
        System.out.println(res.getReservasjon(0).toString());
        res.getReservasjon(0).nyBestilling();
        res.getReservasjon(0).nyBestilling();
        res.getReservasjon(0).getBestilling(0).leggTilRett(res.getRett(1));
        res.getReservasjon(0).getBestilling(0).leggTilRett(res.getRett(-1));
        res.getReservasjon(0).getBestilling(1).leggTilRett(res.getRett(2));

        System.out.println(res.getReservasjon(0).getBestilling(0).toString());
        System.out.println(res.getReservasjon(0).getBestilling(1).toString());
        System.out.println(res.getReservasjon(0).toString());
        System.out.println(res.toString());*/
    }
}

