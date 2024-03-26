package Test;

import java.time.LocalDate;

public class Projekte {
    private String name;
    private LocalDate erstellungsdatum;
    private LocalDate deadline;

    /**
     * Konstruktor der Klasse "Projekte" mit dem Inhalt: Name, Deadline und Erstellungsdatum
     *
     * Getter und Setter Methoden sind auch da ._.
     *
     * @param name
     * @param deadline
     */
    public Projekte(String name, String deadline){
        this.name = name;
        this.erstellungsdatum = LocalDate.now();
        this.deadline = LocalDate.parse(deadline);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setDeadline(String deadline) {
        String pDeadline = deadline;
    }
}
