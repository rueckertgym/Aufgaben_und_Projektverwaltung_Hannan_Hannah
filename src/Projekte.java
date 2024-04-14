import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Projekte {
    private String name;
    private LocalDate erstellungsdatum;
    private LocalDate deadline;
    private int fortschritt;
    private List<String> ressourcen;
    /**
     * Konstruktor der Klasse "Projekte" mit dem Inhalt: Name, Deadline und Erstellungsdatum, Ressourcen
     *
     * Getter und Setter Methoden sind auch da ._. + Hinzufügen und wegnehmen von Ressourcen.
     *
     * @param name
     * @param deadline
     */
    public Projekte(String name, String deadline, int fortschritt, List<String> ressourcen){
        this.name = name;
        this.erstellungsdatum = LocalDate.now();
        this.deadline = LocalDate.parse(deadline);
        this.ressourcen = ressourcen;
        this.fortschritt = fortschritt;

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

    public void setRessourcen(List<String> ressourcen) {
        ressourcen = ressourcen;
    }

    public void ResourcenInListEinfuegen(String ressource){
        ressourcen.add(resource);
    }

    public void ResourcenAusListEntfernen(String ressource){
        ressourcen.remove(ressource);
    }

     public String getFortschritt() {
        return fortschritt;
    }

    public void setFortschritt(int fortschritt) {
        this.fortschritt = fortschritt;
    }
}
