import java.util.Comparator;
import java.util.LinkedList;

import Test.Aufgaben;
import utils.*;
import java.util.Scanner;
import java.util.PriorityQueue;

/*Klasse verwaltet die Aufgaben und Projekte, Aufgaben in einer Priority Queue und Projekte in einer Liste.
Sie hat Methoden, um Aufgaben der Queue hinzuzufügen, zu entfernen und Projekte zur Liste hinzuzufügen und entfernen
sowie eine Fortschrittsüberwachung der Projekte*/

public class AufgabenUndProjektverwaltungstool {
    private PriorityQueue<Aufgaben> AufgabenPriorityQueue;
    private List<Projekte> ProjektListe;

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
                        
                        Scanner scanner = new Scanner(System.in);  
                        System.out.println("Name des Projektes:");
                        String namePojekt = scanner.nextLine();

                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Deadline des Projektes:") ;
                        String deadlineProjekt = scanner.nextLine(); 

                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Fortschritt des Projektes:") ;
                        int fortschrittProjekt = scanner.nextLine();

                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Anzahl an Ressourcen des Projektes:") ;
                        int anzahlRessourcenProjekt = scanner.nextLine(); 

                        System.out.println("Ressourcen des Projektes:") ;
                        ArrayList <String> ressourcenDesProjekts = new ArrayList();
                        for(int i = 0; i < anzahlRessourcenProjekt; i++){
                            Scanner scanner = new Scanner(System.in);
                            String ressourceProjekt = scanner.nextLine();
                            ressourcenDesProjekts.add(ressourceProjekt);
                        }

                        this.ProjekteZuProjektlisteHinzufügen(namePojekt, deadlineProjekt, fortschrittProjekt, ressourcenDesProjekts);
                        schleifenVariable1 = false;

                        catch(Exception E){
                            System.out.println("Fehler:"+ E + "\nBitte gebe gültige Werte ein!");
                        }

                }}}

                } else if (option.equals("B")|| option.equals("b")) {

                    boolean schleifenVariable2 = true;
                    while(schleifenVariable2){
                        try{
                        
                            Scanner scanner = new Scanner(System.in);  
                            System.out.println("Name der Aufgabe:");
                            String nameAufgabe = scanner.nextLine();

                            Scanner scanner = new Scanner(System.in);
                            System.out.println("Deadline der Aufgabe:") ;
                            String deadlineAufgabe = scanner.nextLine(); 

                            Scanner scanner = new Scanner(System.in);
                            System.out.println("Wichtigkeitslevel der Aufgabe:") ;
                            int wichtigkeitAufgabe = scanner.nextLine();


                            this.AufgabenInPriorityQueueEinfuegen(nameAufgabe, deadlineAufgabe, wichtigkeitAufgabe);
                            schleifenVariable2 = false;

                            catch(Exception E){
                                System.out.println("Fehler:"+ E + "\nBitte gebe gültige Werte ein!");
                            }

                }}

                } else if (option.equals("C")|| option.equals("c")) {

                    this.fortschrittUndDeadlineAllerProjekteAusgeben();

                } else if (option.equals("D")|| option.equals("d")) {

                    Scanner scanner = new Scanner(System.in);  
                    System.out.println("Name des Projektes(Falls gleich keine Aufgabennamen ausgegeben werden hat das angegebe Projekt entweder keine zugewiesenen Aufgaben oder es existiert kein Projekt mit diesem Namen):");
                    String namePojekt = scanner.nextLine();

                    List <Projekte> Projektliste = this.getProjektListe;
                    Projektliste.toFirst();
                    while(Projektliste.hasAcces()){
                        if(Projektliste.getContent().getName().equals(nameProjekt)){
                            System.out.println(Projektliste.getContent().getSplitAbhaengigkeiten();

                        }
                    }


                } else if (option.equals("E")|| option.equals("e")) {
                    this.fortschrittUndDeadlineAllerProjekteAusgeben();

                } else if (option.equals("F")|| option.equals("f")) {
                    try{

                     Scanner scanner = new Scanner(System.in);  
                        System.out.println("Name des Projektes:");
                        String namePojekt = scanner.nextLine();

                         Scanner scanner = new Scanner(System.in);
                        System.out.println("Neuer Fortschritt des Projektes:") ;
                        int neuerFortschrittProjekt = scanner.nextLine();

                        this.FortschrittAktuallisieren(neuerFortschrittProjekt, namePojekt);
                    }
                    catch(Exception E){
                        System.out.println("Fehler:"+ E + "\n Bitte gebe gültige Werte ein!");
                    }


                }
                else if (option.equals("G")|| option.equals("g")) {

                    Scanner scanner = new Scanner(System.in);  
                    System.out.println("Name des Projektes:");
                    String namePojekt = scanner.nextLine();

                    this.ProjekteAusProjetklisteEntfernen(nameProjekt);

                }
                else if (option.equals("H")|| option.equals("h")) {#

                this.AufgabenAusPriorityQueueEntfernen();

                }
                else if (option.equals("X")|| option.equals("x")) {
                    tempWhileSchleife = false;
                }
            else{
                System.out.println("Bitte gebe eine der angegeben Buchstaben ein! \n");
                }
        }
    }

    public AufgabenUndProjektverwaltungstool() {
        PriorityQueue<Aufgaben> aufgabenPriorityQueue = new PriorityQueue<>(Comparator.comparing(Aufgaben::getWichtig));
        ProjektListe = new List<>();
    }

    /**
     * Fügt eine Aufgabe zur Queue hinzu, wenn "aufgabe" nicht null ist
     */
    public void aufgabenInPriorityQueueEinfuegen(String aufg
    abenstellung, String deadline, int wichtig) {
        Aufgaben a = new Aufgaben(aufgabenstellung, deadline, wichtig);
            AufgabenPriorityQueue.offer(a);
        }

    public PriorityQueue<Aufgaben> getAufgabenPriorityQueue() {
        return AufgabenPriorityQueue;
    }

    public List<Projekte> getProjektListe() {
        return ProjektListe;
    }

    /**
     * wenn die Queue nicht leer ist, wird der Head entfernt
     */
    public void aufgabenAusPriorityQueueEntfernen() {
        if(AufgabenPriorityQueue.peek() == null){
            System.out.println("Es sind keine Aufgaben vorhanden");
        }else{
            AufgabenPriorityQueue.poll();
        }

    }

    /* neues Projekt wird erzeugt mit gegebenen Attributen und in Projektliste eingefügt
@param String name(name des neuen Projektes), String deadline(deadline des neuen Projektes) */
    public void ProjekteZuProjektlisteHinzufügen(String name, String deadline, int fortschritt,ArrayList ressource){
        Projekte neuesProjekt = new Projekte(name, deadline,fortschritt,ressource);
        ProjektListe.insert(neuesProjekt);
    }

    /*Projekt mit gegebenen Namen wird aus der Liste Projetkliste entfernt, falls dies möglich ist
    @param String nameDes Projekts
    */

    public void ProjekteAusProjetklisteEntfernen(String nameDesProjekts){
        if(!ProjektListe.isEmpty()){
        boolean schleifeAbbrechen = false;
        ProjektListe.toFirst();
        while(!schleifeAbbrechen && ProjektListe.isEmpty()){
            if(ProjektListe.getContent().getName().equals(nameDesProjekts)){
                ProjektListe.remove();
                schleifeAbbrechen = true;
            }
            
            ProjektListe.next();
            
            }
            if(!schleifeAbbrechen){
                System.out.println("Projekt mit Namen:" + nameDesProjekts + "existiert nicht in der Projektliste!");
        }  
        }
        else{
            System.out.println("Projektliste ist leer!");
        }
        
    }

//Fortschritt und Deadline aller Projekte mit ihrem Namen in Reihenfolge der Liste ausgeben, keine Parameter
    public void fortschrittUndDeadlineAllerProjekteAusgeben(){
        ProjektListe.toFirst();
        if(!ProjektListe.isEmpty()){
            while(!ProjektListe.isEmpty()){
                System.out.println(ProjektListe.getContent().getName() + "    ");
                System.out.println(ProjektListe.getContent().getFortschritt() + " %  ");
                System.out.println(ProjektListe.getContent().getDeadline() + "    ");
                System.out.println("/n");
                ProjektListe.next();
            }
        }
    }

    public void ProjektResourcenZuweisung(){
        ProjektListe.toFirst();
        while (!ProjektListe.isEmpty()){
            System.out.println("Das Projekt: " +ProjektListe.getContent().getName()+ "benötigt folgende Ressource: "+ ProjektListe.getContent().getSplit());
            System.out.println(ProjektListe.getContent().getSplit());
            ProjektListe.next();
        }
    }

    public void ProjektFortschrittsueberwachung(String projektName){
        ProjektListe.toFirst();
        boolean gefunden = false;
        while(!ProjektListe.isEmpty() && gefunden == false){
            if(ProjektListe.getContent().getName().equals(projektName)){
                gefunden = true;
                System.out.print(ProjektListe.getContent().getName() + ": "+ ProjektListe.getContent().getFortschritt());
            }else {
                ProjektListe.next();
            }
        }
    }

    public void FortschrittAktuallisieren(String projektName, double neuerFortschritt) {
        ProjektListe.toFirst();
        boolean gefunden = false;
        while (!ProjektListe.isEmpty() && gefunden == false) {
            if (ProjektListe.getContent().getName().equals(projektName)) {
                ProjektListe.getContent().setFortschritt(neuerFortschritt);
                System.out.println("Fortschritt auf: "+ProjektListe.getContent().getFortschritt()+ "aktuallisiert" );
                gefunden = true;
            } else {
                ProjektListe.next();
            }
        }
    }
}
