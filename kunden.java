
public class kunden {
    private  int kundenNummer, plz, mietpreis;
    private String vorname, nachname, strasse, hausnummer, ort, briefkopf,sachbearbeiter;



    // public kunden(int kundenNummer, String vorname, String nachname, String strasse, String hausnummer, String ort, int plz) {
    public  kunden(int kundenNummer, String vorname, String sachbearbeiter) {

        this.vorname = vorname;
        this.kundenNummer = kundenNummer;
        this.sachbearbeiter=sachbearbeiter;


        //System.out.println("Neuer Kunde angelegt mit Namen: "+this.vorname);

    }

    @Override
    public String toString() {
        return "Kundennummer: " + this.getKundenNummer() + ", Name: " + this.getVorname() + ", Sachbearbeiter: "+this.getSachbearbeiter();


    }


    public void setSachbearbeiter(String sachbearbeiter) {
        this.sachbearbeiter = sachbearbeiter;
    }

    public String getSachbearbeiter() {
        return sachbearbeiter;
    }

    public  void setKundenNummer(int kundenNummer) {
        this.kundenNummer = kundenNummer;
    }

      public void setVorname(String vorname) {
        this.vorname = vorname;
    }


    public int getKundenNummer() {
        return kundenNummer;
    }


    public String getVorname() {
        return vorname;
    }

    public String getBriefkopf(int _kundennummer) {
        briefkopf = vorname + " " + nachname + "\n" + strasse + " " + hausnummer + "\n" + plz + " " + ort;
        return briefkopf;
    }


}
