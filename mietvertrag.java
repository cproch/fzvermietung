import java.util.List;

public class mietvertrag {
    private final static String briefkopf = "FahrWerk GmbH\n Kolbenweg 26b\n12321 Rosshausen ";
    private String Mietvertrag, sachbearbeiter;
    private final static int mwst = 15;
    private int vertragsNummer, kundenNummer, fahrzeugNummer, mietdauer;
    private List<Integer> FahrzeugListe;


    public mietvertrag(int vertragsNummer, int kundenNummer, int fahrzeugNummer, String sachbearbeiter, int mietdauer) {

        this.vertragsNummer = vertragsNummer;
        this.kundenNummer = kundenNummer;
        //this.fahrzeugNummer = fahrzeugNummer;
        this.FahrzeugListe.add(fahrzeugNummer);
        this.sachbearbeiter = sachbearbeiter;
        this.mietdauer = mietdauer;
        //TODO: Kosten berechnen
    }

    @Override
    public String toString() {

        return "\nVertrag Nr.:"+this.getVertragsNummer()+"\nKunde Nr.:"+this.getKundenNummer()+"\nFahrzeug Nr.:"+this.getAllFahrzeugNummern()+"\nSachbearbeiter:"+this.getSachbearbeiter()+"\nKosten:";

    }



    private String getAllFahrzeugNummern(){
        String fzNummern="";
        for (Integer fzNummer:this.FahrzeugListe){
            fzNummern+=" "+fzNummern+",";
        }
        return  fzNummern;

    }

    private String genMietvertrag(int _kundenNummer) {
        String FirmenDaten = briefkopf;
        String KundenDaten = "";


        //TODO: Liste der Autos hinzufügen

        Mietvertrag = FirmenDaten + "\n" + KundenDaten;

        // KundenDaten = kunden.getBriefkopf(21);


        return Mietvertrag;

    }


    public void setSachbearbeiter(String sachbearbeiter) {
        this.sachbearbeiter = sachbearbeiter;
    }

    public String getSachbearbeiter() {
        return sachbearbeiter;
    }

    public static int getMwst() {
        return mwst;
    }

    public int getVertragsNummer() {
        return vertragsNummer;
    }

    public int getKundenNummer() {
        return kundenNummer;
    }

    public int getFahrzeugNummer() {

        return fahrzeugNummer;
    }
}
