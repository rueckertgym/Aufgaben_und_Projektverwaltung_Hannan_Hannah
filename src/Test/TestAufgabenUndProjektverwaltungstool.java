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
    public void TestProjekteZuProjektlisteHinzufügen(){
        AufgabenUndProjektverwaltungstool a = new AufgabenUndProjektverwaltungstool();
        a.ProjekteZuProjektlisteHinzufügen("Prog", "2006-10-24",3,"as,2323,3224");
        assertFalse(a.getProjektListe().isEmpty());
    }

    @Test
    public void TestProjekteAusProjetklisteEntfernen(){
        AufgabenUndProjektverwaltungstool a = new AufgabenUndProjektverwaltungstool();
        a.ProjekteZuProjektlisteHinzufügen("Prog", "2006-10-24",3,"as,2323,3224");
        a.ProjekteAusProjetklisteEntfernen("Prog");
        assertTrue(a.getProjektListe().isEmpty());
    }
}