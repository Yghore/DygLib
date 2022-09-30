import fr.yghore.dyglib.Data.Salvageable;

public class JsonFile extends Salvageable
{

    private int jour;
    private String desc;
    private String title;
    private boolean afficher;

    private String nouvelleAttribut;

    public String getNouvelleAttribut() {
        return nouvelleAttribut;
    }

    public void setNouvelleAttribut(String nouvelleAttribut) {
        this.nouvelleAttribut = nouvelleAttribut;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAfficher() {
        return afficher;
    }

    public void setAfficher(boolean afficher) {
        this.afficher = afficher;
    }

    public JsonFile(int jour, String desc, String title, boolean afficher, String nouvelleAttribut) {
        this.jour = jour;
        this.desc = desc;
        this.title = title;
        this.afficher = afficher;
        this.nouvelleAttribut = nouvelleAttribut;
    }

    @Override
    public String toString() {
        return "JsonFile{" +
                "jour=" + jour +
                ", desc='" + desc + '\'' +
                ", title='" + title + '\'' +
                ", afficher=" + afficher +
                ", nouvelleAttribut='" + nouvelleAttribut + '\'' +
                '}';
    }
}
