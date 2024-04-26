package Test;

import utils.List;

import java.time.LocalDate;

public class Projekte {
    private String name;
    private LocalDate erstellungsdatum;
    private LocalDate deadline;
    private double fortschritt;
    private List<String> ressourcen;
    private String[] split;
    /**
     * Konstruktor der Klasse "Projekte" mit dem Inhalt: Name, Deadline und Erstellungsdatum, Ressourcen
     *
     * Getter und Setter Methoden sind auch da ._. + Hinzufügen und wegnehmen von Ressourcen.
     *
     * @param name
     * @param deadline
     */
    public Projekte(String name, String deadline, int fortschritt, String ressource){
        this.name = name;
        this.erstellungsdatum = LocalDate.now();
        this.deadline = LocalDate.parse(deadline);
        this.ressourcen = ressourcen;
        this.fortschritt = fortschritt;
        ressourcen = new List<>();
        split = ressource.split(",");


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
}

