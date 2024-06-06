package Test;
import com.sun.tools.javac.Main;
import org.junit.Test;

import static org.junit.Assert.*;
//Namen der Methoden aus der Testklasse sind veraltet :(

public class TestAufgabenUndProjektverwaltungstool {

    @Test
    public void TestAufgabenInPriorityQueueEinfuegen() {
        AufgabenUndProjektverwaltungstool a = new AufgabenUndProjektverwaltungstool();
        a.aufgabenInPriorityQueueEinfuegen("lern zu programmieren", "2006-10-24", 4);
        assertFalse(a.getAufgabenPriorityQueue().isEmpty());
    }

    @Test
    public void TestAufgabenInPriorityQueueEinfuegenMitZweiAufgaben() {
        AufgabenUndProjektverwaltungstool a = new AufgabenUndProjektverwaltungstool();
        a.aufgabenInPriorityQueueEinfuegen("lern zu programmieren", "2006-10-24", 4);
        a.aufgabenInPriorityQueueEinfuegen("sdfddsf", "2016-11-24", 5);
        assertFalse(a.getAufgabenPriorityQueue().isEmpty());
    }

    @Test
    public void TestProjekteZuProjektlisteHinzufügen(){
        AufgabenUndProjektverwaltungstool a = new AufgabenUndProjektverwaltungstool();
        a.projekteZuProjektlisteHinzufügen("Prog", "2006-10-24",3,"as,2323,3224","wreq,ewr,ewr");
        assertFalse(a.getProjektListe().isEmpty());
    }

    @Test
    public void TestProjekteAusProjetklisteEntfernenWennEsVorhandenIst(){
        AufgabenUndProjektverwaltungstool a = new AufgabenUndProjektverwaltungstool();
        a.projekteZuProjektlisteHinzufügen("Prog", "2006-10-24",3,"as,2323,3224","df,we,243");
        a.projekteAusProjetklisteEntfernen("Projekt 2");
        assertTrue(a.getProjektListe().isEmpty());
    }
    @Test
    public void TestProjekteAusProjetklisteEntfernenWennEsNichtVorhandenIst() {
        AufgabenUndProjektverwaltungstool a = new AufgabenUndProjektverwaltungstool();
        a.projekteZuProjektlisteHinzufügen("Prog", "2006-10-24", 3, "as,2323,3224", "1,2,3,4");
        a.projekteAusProjetklisteEntfernen("sdsd");
        assertFalse(a.getProjektListe().isEmpty());
    }

    @Test
    public void testFortschrittUndDeadlineAllerProjekteAusgeben() {
        AufgabenUndProjektverwaltungstool a = new AufgabenUndProjektverwaltungstool();

        a.projekteZuProjektlisteHinzufügen("Projekt 1", "2024-05-01", 25, "Details 1","123,23");
        a.projekteZuProjektlisteHinzufügen("Projekt 2", "2024-05-15", 50, "Details 2","8734,df,3");
        a.projekteZuProjektlisteHinzufügen("Projekt 3", "2024-06-01", 75, "Details 3","sdf,2d,34");

        System.out.println("Fortschritt und Deadline aller Projekte: ");
        a.fortschrittUndDeadlineAllerProjekteAusgeben();

    }
}
