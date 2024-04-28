import Test.Projekte;
import utils.List;
import java.util.Scanner;


//Main klasse mit main methode, alle user interaktionen finden von hieraus statt,
//Fehler bei der Eingabe vom user werden mit exceptions gehandlet
//Ist wegen zeitproblemen noch nicht komplett aus lauffaehigkeit getestet :(
public class Mainclass {
    public static void main(String[] args) {
        AufgabenUndProjektverwaltungstool aufgabenUndProjektverwaltungstoolObjekt = new AufgabenUndProjektverwaltungstool();
        boolean tempWhileSchleife = true;
        while(tempWhileSchleife) {          //aussere while schleife mit allen Interaktion
            Scanner scanner = new Scanner(System.in);
            System.out.println("                      Devflow Verwaltungstool");
            System.out.println("-----------------------------------------------------------------------"); //unten die moeglichen Optionen
            System.out.println("Wollen Sie: \n[A] ein Projekt erstellen \n[B] eine Aufgabe erstellen \n[C] Die Ressourcenzuteilung " +
                    "fuer die jeweiligen Projekte sehen \n[D] Aufgaben, die zu einem bestimmten Projekt gehören einsehen" +
                    "\n[E] Den Fortschritt und die Deadline für alle Projekte einsehen \n[F] Fortschritt aktualisieren \n" +
                    " [G] Projekt entfernen aus Liste \n [H] oberste Aufgabe aus PriorityQueue entfernen " +" \n [X] Programm abbrechen");
            String option = scanner.nextLine();

            if (option.equals("A")|| option.equals("a")) {  //Projekt erstellen und in Liste einfuegen
                boolean schleifenVariable1 = true;   //gueltiges Objekt muss erstellt werden, sonst steckt user in endlosschleife fest
                while(schleifenVariable1){
                    try{

                        Scanner scanner1 = new Scanner(System.in);          //scanner objekte sind durchnummeriert sorry:(
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
                        String resourcenDesProjekts = "";
                        for(int i = 0; i < anzahlRessourcenProjekt; i++){
                            Scanner scanner15 = new Scanner(System.in);
                            String ressourceProjekt = scanner15.nextLine();
                            resourcenDesProjekts += ressourceProjekt;
                        }
                        //Abhaengigkeiten zu aufgaben, sind noch nicht vom User abgefragt worden -> FEHLT
                        //Koennen nur vom code aus initialisiert werden
                        aufgabenUndProjektverwaltungstoolObjekt.projekteZuProjektlisteHinzufügen(namePojekt, deadlineProjekt, fortschrittProjekt, resourcenDesProjekts, "Platzhalter zugewiesene Aufgaben");
                        schleifenVariable1 = false;}

                        catch(Exception E){           //Exceptionhandling -> Aktion wird wiederholt
                            System.out.println("Fehler:"+ E + "\nBitte gebe gültige Werte ein!");
                        }

                    }

        } else if (option.equals("B")|| option.equals("b")) {  //Aufgabe erstellen und in Queue einfuegen

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
        else if (option.equals("C")|| option.equals("c")) { //benoetigte Ressourcen aller Projekte ausgeben

                aufgabenUndProjektverwaltungstoolObjekt.projektResourcenZuweisung();

        } else if (option.equals("D")|| option.equals("d")) { //Abhaengigkeiten werden ausgegeben (gibt allerdings bisher noch keine)

            Scanner scanner3 = new Scanner(System.in);
            System.out.println("Name des Projektes(Falls gleich keine Aufgabennamen ausgegeben werden hat das angegebe Projekt entweder keine zugewiesenen Aufgaben oder es existiert kein Projekt mit diesem Namen):");
            String nameProjekt = scanner3.nextLine();

            List<Projekte> Projektliste = aufgabenUndProjektverwaltungstoolObjekt.getProjektListe();
            Projektliste.toFirst();
            while(Projektliste.hasAccess()){
                if(Projektliste.getContent().getName().equals(nameProjekt)){
                    System.out.println(Projektliste.getContent().getSplit());

                }
            }


        } else if (option.equals("E")|| option.equals("e")) { //fortschritt und deadline aller projekte werden ausgegeben
                aufgabenUndProjektverwaltungstoolObjekt.fortschrittUndDeadlineAllerProjekteAusgeben();

        } else if (option.equals("F")|| option.equals("f")) { //fortschritt bei einen angegebenen Projekt wird aktualisiert
            try{             //wenn diese Optionen Fehler enthaelt und abgefangen wird, muss sie manuell erneut gestartet werden

                Scanner scanner4 = new Scanner(System.in);
                System.out.println("Name des Projektes:");
                String namePojekt = scanner4.nextLine();

                Scanner scanner41 = new Scanner(System.in);
                System.out.println("Neuer Fortschritt des Projektes:") ;
                double neuerFortschrittProjekt = Double.valueOf(Integer.valueOf(scanner41.nextLine()));

                aufgabenUndProjektverwaltungstoolObjekt.fortschrittAktuallisieren(namePojekt, neuerFortschrittProjekt);
            }
            catch(Exception E){
                System.out.println("Fehler:"+ E + "\n Bitte gebe gültige Werte ein!, Aktion wurde abgebrochen, bitte waehle sie erneut aus!");
            }


        }
        else if (option.equals("G")|| option.equals("g")) { // angegebenes Projekt wird aus Projektliste entfernt

            Scanner scanner5 = new Scanner(System.in);
            System.out.println("Name des Projektes:");
            String nameProjekt = scanner5.nextLine();

            aufgabenUndProjektverwaltungstoolObjekt.projekteAusProjetklisteEntfernen(nameProjekt);

        }
        else if (option.equals("H")|| option.equals("h")) {  //angegebene aufgabe wird aus Queue entfernt

                aufgabenUndProjektverwaltungstoolObjekt.aufgabenAusPriorityQueueEntfernen();

        }
        else if (option.equals("X")|| option.equals("x")) { //Ganzes Programm wird abgebrochen
            tempWhileSchleife = false;
        }
        else{
            System.out.println("Bitte gebe eine der angegeben Buchstaben ein! \n");
        }
    }
}
}
