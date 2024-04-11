import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class AufgabenUndProjektverwaltungstool {
    private PriorityQueue<Aufgaben> AufgabenPriorityQueue;
    private List<Projekte> ProjektListe;

    public AufgabenUndProjektverwaltungstool() {
        AufgabenPriorityQueue = new PriorityQueue<>();
        ProjektListe = new LinkedList<>();
    }

    public void AufgabenInPriorityQueueEinfuegen(Aufgaben aufgabe) {
        AufgabenPriorityQueue.offer(aufgabe);
    }

    public void AufgabenAusPriorityQueueEntfernen() {
        AufgabenPriorityQueue.poll();

    }

    public void ProjekteZuProjektlisteHinzufügen(Projekte neuesProjekt){
        Projektliste.insert(neuesProjekt);
    }
}
