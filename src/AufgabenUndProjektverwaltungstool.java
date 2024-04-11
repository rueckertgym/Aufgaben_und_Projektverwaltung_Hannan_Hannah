import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

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

    public void ProjekteZuProjektlisteHinzufügen(Projekte neuesProjekt){
        Projektliste.insert(neuesProjekt);
    }
}
