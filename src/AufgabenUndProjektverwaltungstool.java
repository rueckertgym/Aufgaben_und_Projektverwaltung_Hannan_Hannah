import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class AufgabenUndProjektverwaltungstool {
    private PriorityQueue<Aufgaben> AufgabenPriorityQueue;
    private List<Projekte>  ProjektListe;

    public AufgabenUndProjektverwaltungstool(){
        AufgabenPriorityQueue = new PriorityQueue<>();
        ProjektListe = new LinkedList<>();
    }
    public void AufgabenInPriorityQueueEinfuegen(Aufgaben neueAufgabe){

    }
    public void AufgabenAusPriorityQueueEntfernen(Aufgaben neueAufgabe){

    }

    public void ProjekteInWarteschlangeEinfuegen(Projekte neuesProjekt){
        ProjektListe.insert(neuesProjekt);

    }

    //public void ProjektAusWarteschlangeEntfernen(String name){

   // }

}
