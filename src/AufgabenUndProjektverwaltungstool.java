import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class AufgabenUndProjektverwaltungstool {
    private PriorityQueue<Aufgaben> AufgabenPriorityQueue;
    private List<Projekte> ProjektListe;

    public static void main(String[] args) {

    }

    public AufgabenUndProjektverwaltungstool() {
        AufgabenPriorityQueue = new PriorityQueue<>();
        ProjektListe = new LinkedList<>();
    }

    public void AufgabenInPriorityQueueEinfuegen(Aufgaben aufgabe) {
        AufgabenPriorityQueue.offer(aufgabe);
    }

    public void AufgabenAusPriorityQueueEntfernen() {
        Aufgaben aufgabe = AufgabenPriorityQueue.poll();
    }
}

