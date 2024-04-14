import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*Klasse verwaltet die Aufgaben und Projekte, Aufgaben in einer Priority Queue und Projekte in einer Liste.
Sie hat Methoden, um Aufgaben der Queue hinzuzufügen, zu entfernen und Projekte zur Liste hinzuzufügen und entfernen
sowie eine Fortschrittsüberwachung der Projekte*/

public class AufgabenUndProjektverwaltungstool {
    private PriorityQueue<Aufgaben> AufgabenPriorityQueue;
    private List<Projekte> ProjektListe;

    public AufgabenUndProjektverwaltungstool() {
        Comparator<Aufgaben> sortByWichitg = Comparator.comparing(Aufgaben::wichtig);
        PriorityQueue<Integer> AufgabenPriorityQueue = new PriorityQueue<>(sortByWichitg);
        ProjektListe = new LinkedList<>();
    }

    /**
     * Fügt eine Aufgabe zur Queue hinzu, wenn "aufgabe" nicht null ist
     */
    public void AufgabenInPriorityQueueEinfuegen(Aufgaben aufgabe) {

        if (aufgabe == null) {
            throw new NullPointerException("data is null");
        }else{
            AufgabenPriorityQueue.offer(aufgabe);
        }
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
    public void ProjekteZuProjektlisteHinzufügen(String name, String deadline){
        Projekt neuesProjekt = new Projekt(name, deadline);
        Projektliste.insert(neuesProjekt);
    }

    /*Projekt mit gegebenen Namen wird aus der Liste Projetkliste entfernt, falls dies möglich ist
    @param String nameDes Projekts
    */

    public void ProjekteAusProjetklisteEntfernen(String nameDesProjekts){
        if(!Projektliste.isEmpty()){
        boolean schleifeAbbrechen = false;
        Projektliste.toFirst();
        while(!schleifeAbbrechen && Projektliste.getContent()){
            if(Projektliste.getContent().name.equals(nameDesProjekts)){
                Projektliste.remove();
                schleifeAbbrechen = true;
            }
            
            Projektliste.next();
            
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
        Projetkliste.toFirst();
        if(!Projektliste.isEmpty()){
            while(Projektliste.getContent()){
                System.out.println(get.Content().getName() + "    ");
                System.out.println(get.Content().getFortschritt() + " %  ");
                System.out.println(get.Content().getDeadline() + "    ");
                System.out.println("/n")

            }
        }
    }
}
