package Test;

import utils.List;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*Klasse verwaltet die Aufgaben und Projekte, Aufgaben in einer Priority Queue und Projekte in einer Liste.
Sie hat Methoden, um Aufgaben der Queue hinzuzufügen, zu entfernen und Projekte zur Liste hinzuzufügen und entfernen
sowie eine Fortschrittsüberwachung der Projekte*/

public class AufgabenUndProjektverwaltungstool {
    private PriorityQueue<Aufgaben> AufgabenPriorityQueue;
    private List<Projekte> ProjektListe;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("                      Devflow Verwaltungstool");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Wollen Sie: \n[A] ein Projekt erstellen \n[B] eine Aufgabe erstellen \n[C] Die Ressourcenzuteilung " +
                "fuer die jeweiligen Projekte sehen \n[D] Die Abheangigkeit zwischen den Aufgaben betrachten" +
                "\n[E] Wissen wann sie mit x Projekt fertig sein sollen \n[F] Fortschritt aktuallisieren");
        String option = scanner.nextLine();
        while(true){
            if(option.equals("A")){

            } else if (option.equals("B")) {

            }else if (option.equals("C")) {

            }else if (option.equals("D")) {

            }else if (option.equals("E")) {

            }else if (option.equals("F")) {

            }
        }
    }

    public AufgabenUndProjektverwaltungstool() {
        AufgabenPriorityQueue = new PriorityQueue<>(Comparator.comparing(Aufgaben::getWichtig));
        ProjektListe = new List<>();
    }

    /**
     * Fügt eine Aufgabe zur Queue hinzu, wenn "aufgabe" nicht null ist
     */
    public void AufgabenInPriorityQueueEinfuegen(String aufgabenstellung, String deadline, int wichtig) {
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
    public void AufgabenAusPriorityQueueEntfernen() {
        if(AufgabenPriorityQueue.peek() == null){
            System.out.println("Es sind keine Aufgaben vorhanden");
        }else{
            AufgabenPriorityQueue.poll();
        }

    }

    /* neues Projekt wird erzeugt mit gegebenen Attributen und in Projektliste eingefügt
@param String name(name des neuen Projektes), String deadline(deadline des neuen Projektes) */
    public void ProjekteZuProjektlisteHinzufügen(String name, String deadline, int fortschritt,String ressource){
        Projekte neuesProjekt = new Projekte(name, deadline,fortschritt,ressource);
        ProjektListe.insert(neuesProjekt);
    }

    /*Projekt mit gegebenen Namen wird aus der Liste Projetkliste entfernt, falls dies möglich ist
    @param String nameDes Projekts
    */

    public boolean ProjekteAusProjetklisteEntfernen(String nameDesProjekts){
        boolean schleifeAbbrechen = false;
        ProjektListe.toFirst();
        boolean gefunden = true;
        while(!schleifeAbbrechen && ProjektListe.isEmpty()){
            if(ProjektListe.getContent().getName().equals(nameDesProjekts)){
                ProjektListe.remove();
                schleifeAbbrechen = true;
                return gefunden;
            }else{
                ProjektListe.next();
            }
        }
        if(!schleifeAbbrechen){
            System.out.println("Projekt mit Namen:" + nameDesProjekts + "existiert nicht in der Projektliste!");
            gefunden = false;
            return gefunden;
        } else{
            System.out.println("Projektliste ist leer!");
            gefunden = false;
            return gefunden;
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
            System.out.println("Das Projekt: " +ProjektListe.getContent().getName()+ "benötigt folgende resource: "+ ProjektListe.getContent().getSplit());
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
