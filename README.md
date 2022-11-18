# DygLib

Libs pour la création simplifié de JSON/YML

## Exemple

__JsonFile__
```java 

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

```
__JsonFileSub__
```java
public class JsonFilesSub implements Salvageable
{

    private int test;

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }
}

```
__JsonTest__
```java
public class JsonTest
{


    @Test
    public void test_json_save() {
        JsonFilesSub t = new JsonFilesSub();
        JsonFile test = (JsonFile) new JsonFile(12, "Je suis une description", "Je suis un titre", true, t).setPath("test.json");
        System.out.println(test);
        test.save();
    }

    @Test
    public void test_json_load() throws FileNotFoundException {
        JsonFile testload = (JsonFile) JsonFile.load("test.json", JsonFile.class);
        System.out.println(testload);
        assertEquals("Je titre n'est pas bon", "Je suis un titre", testload.getTitle());
    }

}

```
