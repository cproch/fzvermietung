
public class lkw extends fahrzeug {


    private final static int mietPreisProTagSmall = 50;
    private final static int mietPreisProTagLarge = 80;
    private final static int inspektionZyklus = 30000;
    private final static int mietpreis = 0;
    private boolean lkWisLarge = false;


    public lkw(int index,String kfzKennzeichen, int kmStand, boolean insketionNoetig, boolean istVermietet, boolean isLarge) {
        super(index,kfzKennzeichen, kmStand, insketionNoetig, istVermietet);
        setMietpreis(isLarge);
        setInspektionZyklus(inspektionZyklus);
        lkWisLarge=isLarge;

    }


    public void fahren(int km) {
        super.fahren(km);
        // TODO: Inspektion berücksichtigen

        System.out.println("kostet: " + getMietpreis());
        System.out.println(getKmStand());


    }


    public boolean isLkWisLarge() {
        return lkWisLarge;
    }

    @Override
    public String toString() {
        String strLarge=this.lkWisLarge?"Großer":"Kleiner";

        return "\nFahrzeug Nummer "+this.getIndex()+"\nLKW ("+strLarge+"), " + this.getKfzKennzeichen() + ", km Stand: " + this.getKmStand();

    }


    private void setMietpreis(boolean isLarge) {

        if (isLarge) {
            setMietpreis(mietPreisProTagLarge);

        } else {
            setMietpreis(mietPreisProTagSmall);
        }
    }


}
