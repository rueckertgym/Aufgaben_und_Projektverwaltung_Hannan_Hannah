import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Projekte {
    private String name;
    private LocalDate erstellungsdatum;
    private LocalDate deadline;
    private List<String> resourcen;
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
        this.resourcen = new ArrayList<String>();

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
        return resourcen;
    }

    public void setResourcen(List<String> resourcen) {
        resourcen = resourcen;
    }

    public void ResourcenInListEinfuegen(String resource){
        resourcen.add(resource);
    }

    public void ResourcenAusListEntfernen(String resource){
        resourcen.remove(resource);
    }
}
