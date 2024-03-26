package Test;

import java.time.LocalDate;

public class Aufgaben {
    private String aufgabenstellung;
    private LocalDate erstellungsdatum;
    private LocalDate deadline;
    private int wichtig;

    /**
     * Erstellung eines Konstruktors fuer die Klasse "Aufgaben" mit einer Aufgabenstellung, ein Erstellungsdatum,
     * eine Deadline die im "yyyy-mm-dd" Format dargestellt wird und einen Wichitgkeitswert von 0-10, 0-100, etc..
     *
     * Und getter + setter Methoden ._.
     *
     * @param aufgabenstellung
     * @param deadline
     * @param wichtig
     */
    public Aufgaben(String aufgabenstellung, String deadline, int wichtig){
        this.aufgabenstellung = aufgabenstellung;
        this.erstellungsdatum = LocalDate.now();
        this.deadline = LocalDate.parse(deadline);
        this.wichtig = wichtig;
    }

    public String getAufgabenstellung() {
        return aufgabenstellung;
    }

    public void setAufgabenstellung(String aufgabenstellung) {
        this.aufgabenstellung = aufgabenstellung;
    }

    public LocalDate getErstellungsdatum() {
        return erstellungsdatum;
    }

    public void setErstellungsdatum(LocalDate erstellungsdatum) {
        this.erstellungsdatum = erstellungsdatum;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public int getWichtig() {
        return wichtig;
    }

    public void setWichtig(int wichtig) {
        this.wichtig = wichtig;
    }
}
