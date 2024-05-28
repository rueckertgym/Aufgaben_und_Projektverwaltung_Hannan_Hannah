import java.util.Comparator;

import Test.Aufgaben;
import Test.Projekte;
import utils.*;

import java.util.PriorityQueue;

/*Klasse verwaltet die Aufgaben und Projekte, Aufgaben in einer Priority Queue und Projekte in einer Liste.
Sie hat Methoden, um Aufgaben der Queue hinzuzufügen, zu entfernen und Projekte zur Liste hinzuzufügen und entfernen
sowie eine Fortschrittsüberwachung der Projekte*/

public class AufgabenUndProjektverwaltungstool {
    private PriorityQueue<Aufgaben> AufgabenPriorityQueue;
    private List<Projekte> ProjektListe;


    public AufgabenUndProjektverwaltungstool() {
        PriorityQueue<Aufgaben> aufgabenPriorityQueue = new PriorityQueue<>(Comparator.comparing(Aufgaben::getWichtig));
        ProjektListe = new List<>();
    }

    /**
     * Fügt eine Aufgabe zur Queue hinzu, wenn "aufgabe" nicht null ist
     */
    public void aufgabenInPriorityQueueEinfuegen(String aufgabenstellung, String deadline, int wichtig) {
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
        if(AufgabenPriorityQueue.isEmpty()){
            System.out.println("Es sind keine Aufgaben vorhanden");
        }else{
            AufgabenPriorityQueue.poll();
        }
    }

    /* neues Projekt wird erzeugt mit gegebenen Attributen und in Projektliste eingefügt
@param String name(name des neuen Projektes), String deadline(deadline des neuen Projektes) */
    public void projekteZuProjektlisteHinzufügen(String name, String deadline, int fortschritt,String ressource, String aufgaben){
        Projekte neuesProjekt = new Projekte(name, deadline,fortschritt,ressource,aufgaben);
        ProjektListe.insert(neuesProjekt);
    }

    /*Projekt mit gegebenen Namen wird aus der Liste Projetkliste entfernt, falls dies möglich ist
    @param String nameDes Projekts
    */

    public void projekteAusProjetklisteEntfernen(String nameDesProjekts){
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
            while(ProjektListe.hasAccess()){
                System.out.println(ProjektListe.getContent().getName() + "    ");
                System.out.println(ProjektListe.getContent().getFortschritt() + " %  ");
                System.out.println(ProjektListe.getContent().getDeadline() + "    ");
                System.out.println(" ");
                ProjektListe.next();
            }
        }
    }

    public void projektResourcenZuweisung(){
        ProjektListe.toFirst();
        while (!ProjektListe.isEmpty()){
            System.out.println("Das Projekt: " +ProjektListe.getContent().getName()+ "benötigt folgende Ressource: "+ ProjektListe.getContent().getSplit());
            System.out.println(ProjektListe.getContent().getSplit());
            ProjektListe.next();
        }
    }

    public void projektFortschrittsueberwachung(String projektName){
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

    public void fortschrittAktuallisieren(String projektName, double neuerFortschritt) {
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
