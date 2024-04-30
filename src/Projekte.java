import utils.List;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Projekte {
    private String name;
    private LocalDate erstellungsdatum;
    private LocalDate deadline;
    private double fortschritt;
    private List<String> ressourcen;
    private String[] split;
    private List<String> abhaengigkeiten;
    private String[] splitAbhaengigkeiten;

    /**
     * Konstruktor fuer eine Instanz der Klasse Projekte mit Getter und Setter Methoden
     * @param name
     * @param deadline
     * @param fortschritt
     * @param ressourcen
     * @param aufgabenstellung
     */
    public Projekte(String name, String deadline, double fortschritt, String ressourcen, String aufgabenstellung){
        this.name = name;
        this.erstellungsdatum = LocalDate.now();
        try {
            this.deadline = LocalDate.parse(deadline);
        } catch (DateTimeParseException e) {
            System.out.println("Ungültiges Datumsformat für die Deadline: " + deadline + " \nDeadline wurde automatisch auf 30.04.2024 gesetzt!");
            this.deadline = LocalDate.parse("2024-04-20");
        }
        this.fortschritt = fortschritt;
        this.ressourcen = new List<>();
        this.split = ressourcen.split(",");
        this.abhaengigkeiten = new List<>();
        this.splitAbhaengigkeiten = aufgabenstellung.split(",");
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
        try {
            this.deadline = LocalDate.parse(deadline);
        } catch (DateTimeParseException e) {
            System.out.println("Ungültiges Datumsformat für die Deadline: " + deadline);
            this.deadline = null;
        }
    }
    public List<String> getResourcen() {
        return ressourcen;
    }


    public void ResourcenInListEinfuegen(String ressource){
        ressourcen.insert(ressource);
    }

     public double getFortschritt() {
        return fortschritt;
    }

    public void setFortschritt(double fortschritt) {
        this.fortschritt = fortschritt;
    }

    public String[] getSplit() {
        return split;
    }

    public void setSplit(String[] split) {
        this.split = split;
    }

    public String[] getSplitAbheangigkeiten() {
        return splitAbhaengigkeiten;
    }

    public void setSplitAbheangigkeiten(String[] splitAbheangigkeiten) {
        this.splitAbhaengigkeiten = splitAbheangigkeiten;
    }
}

