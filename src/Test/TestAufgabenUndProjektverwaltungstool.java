package Test;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAufgabenUndProjektverwaltungstool {

    @Test
    public void TestAufgabenInPriorityQueueEinfuegen() {
        AufgabenUndProjektverwaltungstool a = new AufgabenUndProjektverwaltungstool();
        a.AufgabenInPriorityQueueEinfuegen("lern zu programmieren", "2006-10-24", 4);
        assertFalse(a.getAufgabenPriorityQueue().isEmpty());
    }

    @Test
    public void TestAufgabenInPriorityQueueEinfuegenMitZweiAufgaben() {
        AufgabenUndProjektverwaltungstool a = new AufgabenUndProjektverwaltungstool();
        a.AufgabenInPriorityQueueEinfuegen("lern zu programmieren", "2006-10-24", 4);
        a.AufgabenInPriorityQueueEinfuegen("sdfddsf", "2016-11-24", 5);
        assertFalse(a.getAufgabenPriorityQueue().isEmpty());
    }

    @Test
    public void TestProjekteZuProjektlisteHinzufügen(){
        AufgabenUndProjektverwaltungstool a = new AufgabenUndProjektverwaltungstool();
        a.ProjekteZuProjektlisteHinzufügen("Prog", "2006-10-24",3,"as,2323,3224");
        assertFalse(a.getProjektListe().isEmpty());
    }

    @Test
    public void TestProjekteAusProjetklisteEntfernenWennEsVorhandenIst(){
        AufgabenUndProjektverwaltungstool a = new AufgabenUndProjektverwaltungstool();
        a.ProjekteZuProjektlisteHinzufügen("Prog", "2006-10-24",3,"as,2323,3224");
        a.ProjekteAusProjektlisteEntfernen("Prog");
        assertTrue(a.getProjektListe().isEmpty());
    }
    @Test
    public void TestProjekteAusProjetklisteEntfernenWennEsNichtVorhandenIst() {
        AufgabenUndProjektverwaltungstool a = new AufgabenUndProjektverwaltungstool();
        a.ProjekteZuProjektlisteHinzufügen("Prog", "2006-10-24", 3, "as,2323,3224");
        a.ProjekteAusProjektlisteEntfernen("Preret");
        assertFalse(a.getProjektListe().isEmpty());
    }

    @Test
    public void testFortschrittUndDeadlineAllerProjekteAusgeben() {
        AufgabenUndProjektverwaltungstool a = new AufgabenUndProjektverwaltungstool();

        a.ProjekteZuProjektlisteHinzufügen("Projekt 1", "2024-05-01", 25, "Details 1");
        a.ProjekteZuProjektlisteHinzufügen("Projekt 2", "2024-05-15", 50, "Details 2");
        a.ProjekteZuProjektlisteHinzufügen("Projekt 3", "2024-06-01", 75, "Details 3");

        System.out.println("Fortschritt und Deadline aller Projekte:");
        a.fortschrittUndDeadlineAllerProjekteAusgeben();
    }

}