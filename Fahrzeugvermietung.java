import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Fahrzeugvermietung {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";

    private static final List<String> MenuItems = Arrays.asList("Start", "Kundeneingabe", "Fahrzeuge", "Mietvertraege");
    private static final Scanner userInput = new Scanner(System.in);

    private static List<pkw> pkwListe = new ArrayList();
    private static List<lkw> lkwListe = new ArrayList();
    private static List<mietvertrag> mietVertragListe = new ArrayList();
    private static final List<kunden> kundenIdListe = new ArrayList();


    private static String sMainMenue, sInput;
    private static int iMenueItem = 0;
    private static int iInput;


    public static void main(String[] args) {

        List<kunden> kundenIdListe = new ArrayList();
        String name;
        int anzPKW, anzLKW;

        sysMessage("Bevor es losgeht - wieviele PKW sollen erzeugt werden?");
        anzPKW = tryCatchUserinput();//Integer.parseInt(userInput.nextLine());
        sysMessage("Und wieviele LKW sollen erzeugt werden?");
        anzLKW = tryCatchUserinput();
        generiereFahrzeuge(anzPKW, anzLKW);


        while (true) {
            buildMeune(0);
            iMenueItem = tryCatchUserinput();// Integer.parseInt(userInput.nextLine());

            try {
                buildMeune(iMenueItem);
            } catch (Exception ArrayIndexOutOfBoundsException) {
                sysMessage("Bitte eine Menü Nummer eingeben " + ANSI_BLUE + iMenueItem + ANSI_RED + " ist nicht erlaubt");
            }

        }


    }



    public Fahrzeugvermietung(){

    }


    private static int tryCatchUserinput(Integer[] erlaubteEingaben, int eingabe) {
        int retval = 0;
        boolean error = true;

        if (!Arrays.asList(erlaubteEingaben).contains(eingabe)) {

            sysMessage("Ihre Eingabe " + ANSI_BLUE + eingabe + ANSI_RED + " ist ungültig");

            while (error) {
                System.out.print("Erneute Eingabe: ");
                retval = tryCatchUserinput();

                if (Arrays.asList(erlaubteEingaben).contains(retval)) {
                    error = false;
                }

            }
        } else {
            retval = eingabe;

        }

        return retval;

    }


    private static int tryCatchUserinput() {

        int n1 = 0;
        boolean bError = true;

        while (bError) {
            try {
                n1 = parseInt(userInput.nextLine());
                bError = false;
            } catch (NumberFormatException e) {
                //e.printStackTrace();
                sysMessage("Bitte nur Zahlen eingeben");
            }
        }

        return n1;

    }


    public static void chooseCar() {
        int fGrp = 0;

        System.out.println("Welche Fahrzeuggruppe?\n(1): PKW\n(2): LKW\n(3): Beide");
        fGrp = tryCatchUserinput();//Integer.parseInt(userInput.nextLine());
        showCars(fGrp);


        //TODO: Abholen welche Nummer gewünscht ist - dazu evtl. die angezeigten in eine temporäre Liste übernehmen?


    }


    private static void showCars(int iwhich) {
        int chooseBigOrSmall, chooseAllorAvailable;


        System.out.println("(1): Alle\n(2): Unvermietet");


        chooseAllorAvailable = tryCatchUserinput();
        chooseAllorAvailable = tryCatchUserinput(new Integer[]{1, 2}, chooseAllorAvailable);


        switch (iwhich) {

            case 1:

                for (pkw car : pkwListe) {

                    if ((chooseAllorAvailable == 2) && (!car.isIstVermietet())) {
                        System.out.println(car);
                    }

                    if (chooseAllorAvailable == 1) {
                        System.out.println(car);
                    }
                }

                break;

            case 2:

                System.out.println("(1): Nur Grosse\n(2): Nur kleine\n(3): Alle");
                chooseBigOrSmall = tryCatchUserinput();//Integer.parseInt(userInput.nextLine());

                chooseBigOrSmall = tryCatchUserinput(new Integer[]{1, 2}, 2);


                for (lkw clkw : lkwListe) {


                    switch (chooseBigOrSmall) {

                        case 1:
                            if (clkw.isLkWisLarge()) {
                                System.out.println(clkw);
                            }
                            break;

                        case 2:
                            if (!clkw.isLkWisLarge()) {
                                System.out.println(clkw);
                            }
                            break;


                        case 3:
                            System.out.println(clkw);
                            break;


                        default:
                            sysMessage("Keine erlaubte Eingbabe");
                            break;


                    }


                }


                break;
            case 3:

                for (pkw car : pkwListe) {
                    System.out.println(car);
                }
                for (lkw clkw : lkwListe) {
                    System.out.println(clkw);
                }

                break;


            default:
                sysMessage("Keine erlaubte Eingbabe");
                break;
        }


    }


    private static void generiereFahrzeuge(int anzahlPKW, int anzahlLKW) {
        int kmStand;
        int index = 0;

        for (int i = 0; i < anzahlPKW; i++) {
            kmStand = (int) ((Math.random()) * 4500 + 1);

            pkwListe.add(new pkw(index, genKennzeichen(), kmStand, false, false));
            index++;
        }

        for (int i = 0; i < anzahlLKW; i++) {
            kmStand = (int) ((Math.random()) * 4500 + 1);

            lkwListe.add(new lkw(index, genKennzeichen(), kmStand, false, false, (Math.random() < 0.5)));
            index++;
        }


        sysMessage("Fahrzeug Flotte mit " + anzahlPKW + " PKW und " + anzahlLKW + " LKW erstellt");


    }


    private static void sysMessage(String message) {

        System.out.println(ANSI_RED + "*************" + message + "*************" + ANSI_RESET);


    }


    private static String genKennzeichen() {
        String firmaDefault = "HH-";
        char nummSchild;

        for (int i = 0; i < 2; i++) {
            nummSchild = (char) ('a' + 25 * Math.random());
            firmaDefault += Character.toUpperCase(nummSchild);
        }

        firmaDefault += "-";

        int anzahl = (int) (Math.random() * 3 + 1);


        for (int i = 0; i < anzahl; i++) {
            firmaDefault += (int) (Math.random() * 10);

//            System.out.println(firmaDefault);
        }


        return firmaDefault;


    }



    private static void buildMeune(int _MenuItem) {

        if (_MenuItem == 9) {

            sysMessage("Auf wiedersehen");
            System.exit(0);

        }


        String wMenue = MenuItems.get(_MenuItem);
        String outString = "";

        String welcome = ANSI_GREEN + "##############################################" + ANSI_RESET;
        welcome += ANSI_BLUE + wMenue + ANSI_RESET;
        welcome += ANSI_GREEN + "##############################################" + ANSI_RESET;

        System.out.println(welcome);


        switch (_MenuItem) {
            case 0:
                outString = "(0): Dieses Menu\n";
                outString += "(1): " + MenuItems.get(1) + "\n";
                outString += "(2): " + MenuItems.get(2) + "\n";
                outString += "(3): " + MenuItems.get(3) + "\n";
                outString += "(9): beenden \n";
                System.out.println(outString);

                break;

            case 1:
                kundenEingabe();
                break;

            case 2:
                outString = "2";
                chooseCar();
                break;
            case 3:
                outString = "3";
                mietvertragMenue();
                break;

            default:
                sysMessage("Keine erlaubte Eingbabe");
                break;

        }


    }


    private static void mietvertragMenue(){
        boolean repeat = true;
        int intUserInput = 0;
        int vertragsnummer=0;
        String stringUserInput;

        System.out.println("Verträge im System: ");
        for (mietvertrag mVertrag : mietVertragListe) {
            System.out.println(mVertrag+"\n");
        }

        System.out.println("\nVertagsnummer eingeben:");
        vertragsnummer = parseInt(userInput.nextLine());

        String kMenue = "(1): Fahrzeug hinzufügen \n(2): Vertrag Details anzeigen\n(3): Menü verlassen";
        Integer[] usedMenue = new Integer[]{1, 2, 3};

        while(repeat){

            System.out.println(kMenue);
            intUserInput = tryCatchUserinput();
            intUserInput = tryCatchUserinput(usedMenue, intUserInput);

            switch (intUserInput){


                case 1:
                    System.out.println(1);
                    genLeaseAgreement(kundenIdListe.get(mietVertragListe.get(vertragsnummer).getKundenNummer()));
                    break;
                case 2:
                    System.out.println(mietVertragListe.get(vertragsnummer));
                    break;
                case 3:
                    buildMeune(0);
                    repeat=false;
                    break;
                default:

                    break;

            }


        }



    }




    private static void kundenEingabe() {
        boolean repeat = true;
        int intUserInput = 0;
        int kundenNummer=0;
        boolean neueEingabe = true;


        String stringUserInput;
        System.out.println("Name des Sachbearbeiters eingeben:");

        String stringSachbearbeiterInput = userInput.nextLine();
        String kMenue = "(1): weiteren Kunden eingeben\n(2): Kundeneingabe verlassen\n(3): Alle Kunden auflisten\n(4) Kunden Auswahl";
        Integer[] usedMenue = new Integer[]{1, 2, 3, 4};


        while (repeat) {


            if (neueEingabe) {

                System.out.println("Namen des Kunden angeben: ");
                stringUserInput = userInput.nextLine();
                kundenIdListe.add(new kunden(kundenIdListe.size(), stringUserInput, stringSachbearbeiterInput));
                neueEingabe = false;


            }
            System.out.println(kMenue);
            intUserInput = tryCatchUserinput();
            intUserInput = tryCatchUserinput(usedMenue, intUserInput);


            if (intUserInput == 1) neueEingabe = true;
            if (intUserInput == 2) repeat = false;

            if (intUserInput == 3) {
                for (kunden knde : kundenIdListe) {
                    System.out.println(knde);
                }
            }

            if (intUserInput == 4) {
                System.out.print("Kundennummer:");
                intUserInput = tryCatchUserinput();
                kunden kundeSelected = kundenIdListe.get(intUserInput);


                sysMessage("Kunde " + kundeSelected.getVorname() + "ausgewählt");
                System.out.println("(1):Mietvertrag erstellen\n(2):Sachbearbeiter ändern\n(3): zurück");

                intUserInput = tryCatchUserinput();
                intUserInput = tryCatchUserinput(new Integer[]{1, 2, 3}, intUserInput);

                if (intUserInput == 1) genLeaseAgreement(kundeSelected);
                if (intUserInput == 2) changeContact(kundeSelected);


            }


        }


    }


    private static void genLeaseAgreement(kunden kundeSelected) {
        //TODO: 1. Fahrzeug auswahl, 2. Mietdauer auswahl
        int indexFahrzeug, mietDauer;
        boolean error = true;


        /* TODO: Prüfen, ob eingegebene Nummer 1. Exisitert, 2. Das Fahrzeug nicht vermietet ist
        while (error){
        }
        */
        chooseCar();
        System.out.println("Fahrzeug Nummer:");
        indexFahrzeug = tryCatchUserinput();
        System.out.println("Mietdauer:");
        mietDauer = tryCatchUserinput();


        mietvertrag mVertrag = new mietvertrag(mietVertragListe.size(), kundeSelected.getKundenNummer(), indexFahrzeug, kundeSelected.getSachbearbeiter(), mietDauer);

        mietVertragListe.add(mVertrag);


    }

    private static void changeContact(kunden kundeSelected) {
        System.out.println("Bisheriger Sachbearbeiter: " + kundeSelected.getSachbearbeiter());
        System.out.println("Neuer Sachbearbeiter:");

        kundeSelected.setSachbearbeiter(userInput.nextLine());
        System.out.println("Eintrag geändert");

    }


}
