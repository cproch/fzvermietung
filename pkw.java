
public class pkw extends fahrzeug {


    private final static int mietPreisProTag = 30;
    private final static int inspektionZyklus = 20000;
    boolean istVermietet;

    public pkw(int index, String kfzKennzeichen, int kmStand, boolean insketionNoetig, boolean istVermietet) {
        super(index,kfzKennzeichen, kmStand, insketionNoetig, istVermietet);
        setInspektionZyklus(inspektionZyklus);
        setMietpreis(mietPreisProTag);
        this.istVermietet=istVermietet;
    }


    public void fahren(int km) {
        super.fahren(km);
        // TODO: Inspektion berücksichtigen
    }



    @Override
    public String toString() {
        return "\nFahrzeug Nummer "+this.getIndex()+"\nPKW: "+this.getKfzKennzeichen()+", km Stand: "+this.getKmStand()+" vermietet:"+this.istVermietet;


    }

}
