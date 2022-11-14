import fr.yghore.dyglib.Data.Json;
import fr.yghore.dyglib.Data.Salvageable;

public class JsonFile extends Json implements Salvageable
{

    private int jour;
    private String desc;
    private String title;
    private boolean afficher;


    public JsonFilesSub sub;

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

    public JsonFile(int jour, String desc, String title, boolean afficher, JsonFilesSub sub)
    {
        this.jour = jour;
        this.desc = desc;
        this.title = title;
        this.afficher = afficher;
        this.sub = sub;
    }

    @Override
    public String toString() {
        return "JsonFile{" +
                "jour=" + jour +
                ", desc='" + desc + '\'' +
                ", title='" + title + '\'' +
                ", afficher=" + afficher +
                ", sub=" + sub +
                '}';
    }


}
