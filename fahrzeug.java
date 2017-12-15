
public abstract class fahrzeug {

    private String kfzKennzeichen;
    private int kmStand, mietpreis, kmBisInspektion,index;
    private boolean istVermietet, insketionNoetig;


    private int inspektionZyklus;


    public fahrzeug(int index,String kfzKennzeichen, int kmStand, boolean insketionNoetig, boolean istVermietet) {
        this.kfzKennzeichen = kfzKennzeichen;
        this.kmStand = kmStand;
        this.insketionNoetig = insketionNoetig;
        this.istVermietet = istVermietet;
        this.index=index;
    }


    public void fahren(int km) {
        // ToDo: insketionNoetig in den klassen lkw und pkw ergänzen

        this.kmStand += km;

    }


//ToDo: Alle Setter und Getter Sinnvoll ?


    public void setInspektionZyklus(int inspektionZyklus) {
        this.inspektionZyklus = inspektionZyklus;
    }

    public int getMietpreis() {
        return mietpreis;
    }

    public void setMietpreis(int mietpreis) {
        this.mietpreis = mietpreis;
    }


    public int getIndex() {
        return index;
    }

    public void setKfzKennzeichen(String kfzKennzeichen) {
        this.kfzKennzeichen = kfzKennzeichen;
    }

    public void setKmStand(int kmStand) {
        this.kmStand = kmStand;
    }


    public void setIstVermietet(boolean istVermietet) {
        this.istVermietet = istVermietet;
    }

    public boolean isIstVermietet() {
        return istVermietet;
    }

    public String getKfzKennzeichen() {
        return kfzKennzeichen;
    }

    public int getKmStand() {
        return kmStand;
    }


}
