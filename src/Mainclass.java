import Test.AufgabenUndProjektverwaltungstool;
import Test.Projekte;
import utils.List;

import java.util.Scanner;

public class Mainclass {
    public static void main(String[] args) {
        AufgabenUndProjektverwaltungstool aufgabenUndProjektverwaltungstoolObjekt = new AufgabenUndProjektverwaltungstool();
        boolean tempWhileSchleife = true;
        while(tempWhileSchleife) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("                      Devflow Verwaltungstool");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Wollen Sie: \n[A] ein Projekt erstellen \n[B] eine Aufgabe erstellen \n[C] Die Ressourcenzuteilung " +
                    "fuer die jeweiligen Projekte sehen \n[D] Aufgaben, die zu einem bestimmten Projekt gehören einsehen" +
                    "\n[E] Den Fortschritt und die Deadline für alle Projekte einsehen \n[F] Fortschritt aktualisieren \n" +
                    " [G] Projekt entfernen aus Liste \n [H] oberste Aufgabe aus PriorityQueue entfernen " +" \n [X] Programm abbrechen");
            String option = scanner.nextLine();

            if (option.equals("A")|| option.equals("a")) {
                boolean schleifenVariable1 = true;
                while(schleifenVariable1){
                    try{

                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Name des Projektes:");
                        String namePojekt = scanner1.nextLine();

                        Scanner scanner12 = new Scanner(System.in);
                        System.out.println("Deadline des Projektes:") ;
                        String deadlineProjekt = scanner12.nextLine();

                        Scanner scanner13 = new Scanner(System.in);
                        System.out.println("Fortschritt des Projektes:") ;
                        int fortschrittProjekt = Integer.valueOf(scanner13.nextLine());

                        Scanner scanner14 = new Scanner(System.in);
                        System.out.println("Anzahl an Ressourcen des Projektes:") ;
                        int anzahlRessourcenProjekt = Integer.valueOf(scanner14.nextLine());

                        System.out.println("Ressourcen des Projektes:") ;
                        List<String> ressourcenDesProjekts = new List();
                        for(int i = 0; i < anzahlRessourcenProjekt; i++){
                            Scanner scanner15 = new Scanner(System.in);
                            String ressourceProjekt = scanner15.nextLine();
                            ressourcenDesProjekts.insert(ressourceProjekt);
                        }

                        aufgabenUndProjektverwaltungstoolObjekt.projekteZuProjektlisteHinzufügen(namePojekt, deadlineProjekt, fortschrittProjekt, ressourcenDesProjekts);
                        schleifenVariable1 = false;}

                        catch(Exception E){
                            System.out.println("Fehler:"+ E + "\nBitte gebe gültige Werte ein!");
                        }

                    }

        } else if (option.equals("B")|| option.equals("b")) {

            boolean schleifenVariable2 = true;
            while(schleifenVariable2){
                try{

                    Scanner scanner21 = new Scanner(System.in);
                    System.out.println("Name der Aufgabe:");
                    String nameAufgabe = scanner21.nextLine();

                    Scanner scanner22 = new Scanner(System.in);
                    System.out.println("Deadline der Aufgabe:") ;
                    String deadlineAufgabe = scanner22.nextLine();

                    Scanner scanner23 = new Scanner(System.in);
                    System.out.println("Wichtigkeitslevel der Aufgabe:") ;
                    int wichtigkeitAufgabe = Integer.valueOf(scanner23.nextLine());


                    aufgabenUndProjektverwaltungstoolObjekt.aufgabenInPriorityQueueEinfuegen(nameAufgabe, deadlineAufgabe, wichtigkeitAufgabe);
                    schleifenVariable2 = false;}

                            catch(Exception E){
                        System.out.println("Fehler:"+ E + "\nBitte gebe gültige Werte ein!");
                    }

                }

        }
        else if (option.equals("C")|| option.equals("c")) {

                aufgabenUndProjektverwaltungstoolObjekt.fortschrittUndDeadlineAllerProjekteAusgeben();

        } else if (option.equals("D")|| option.equals("d")) {

            Scanner scanner3 = new Scanner(System.in);
            System.out.println("Name des Projektes(Falls gleich keine Aufgabennamen ausgegeben werden hat das angegebe Projekt entweder keine zugewiesenen Aufgaben oder es existiert kein Projekt mit diesem Namen):");
            String nameProjekt = scanner3.nextLine();

            List <Projekte> Projektliste = aufgabenUndProjektverwaltungstoolObjekt.getProjektListe();
            Projektliste.toFirst();
            while(Projektliste.hasAccess()){
                if(Projektliste.getContent().getName().equals(nameProjekt)){
                    System.out.println(Projektliste.getContent().getSplit());

                }
            }


        } else if (option.equals("E")|| option.equals("e")) {
                aufgabenUndProjektverwaltungstoolObjekt.fortschrittUndDeadlineAllerProjekteAusgeben();

        } else if (option.equals("F")|| option.equals("f")) {
            try{

                Scanner scanner4 = new Scanner(System.in);
                System.out.println("Name des Projektes:");
                String namePojekt = scanner4.nextLine();

                Scanner scanner41 = new Scanner(System.in);
                System.out.println("Neuer Fortschritt des Projektes:") ;
                double neuerFortschrittProjekt = Double.valueOf(Integer.valueOf(scanner41.nextLine()));

                aufgabenUndProjektverwaltungstoolObjekt.fortschrittAktualisieren(namePojekt, neuerFortschrittProjekt);
            }
            catch(Exception E){
                System.out.println("Fehler:"+ E + "\n Bitte gebe gültige Werte ein!");
            }


        }
        else if (option.equals("G")|| option.equals("g")) {

            Scanner scanner5 = new Scanner(System.in);
            System.out.println("Name des Projektes:");
            String nameProjekt = scanner5.nextLine();

            aufgabenUndProjektverwaltungstoolObjekt.projekteAusProjetklisteEntfernen(nameProjekt);

        }
        else if (option.equals("H")|| option.equals("h")) {

                aufgabenUndProjektverwaltungstoolObjekt.aufgabenAusPriorityQueueEntfernen();

        }
        else if (option.equals("X")|| option.equals("x")) {
            tempWhileSchleife = false;
        }
        else{
            System.out.println("Bitte gebe eine der angegeben Buchstaben ein! \n");
        }
    }
}
}
