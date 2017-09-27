package pakke;

/**
 * Created by BrageHalse on 21.09.2017.
 */
    public class Rett {
        private int id;
        private String navn;
        private String beskrivelse;
        double pris;
        public Rett(int id, String navn, String beskrivelse, double pris){
            this.id = id;
            this.navn = navn;
            this.beskrivelse = beskrivelse;
            this.pris = pris;
        }

    public int getId() {
        return id;
    }

    public String getNavn() {
        return navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public double getPris(){
            return pris;
    }

    public String toString(){
        return navn +": " + beskrivelse + " Pris: " + pris + ",-";
    }
}
