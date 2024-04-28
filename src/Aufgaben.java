import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Aufgaben implements Comparable<Aufgaben> {
    private String aufgabenstellung;
    private LocalDate erstellungsdatum;
    private LocalDate deadline;
    private int wichtig;

    /**
     * Konstruktor fuer eine Instanz der Klasse Aufgaben mit Getter und Setter Methoden
     * @param aufgabenstellung
     * @param deadline
     * @param wichtig
     */
    public Aufgaben(String aufgabenstellung, String deadline, int wichtig){
        this.aufgabenstellung = aufgabenstellung;
        this.erstellungsdatum = LocalDate.now();
        try {
            this.deadline = LocalDate.parse(deadline);
        } catch (DateTimeParseException e) {
            System.out.println("Ungültiges Datumsformat für Deadline: " + deadline);
        }
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

    public int compareTo(Aufgaben other) {
        int result = Integer.compare(this.wichtig, other.wichtig);
        if (result == 0) {
            // Wenn die Wichtigkeiten gleich sind, vergleiche nach Deadline
            result = this.deadline.compareTo(other.deadline);
        }
        return result;
    }
}
