import fr.yghore.dyglib.Data.Json;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.testng.AssertJUnit.assertEquals;

public class JsonTest
{

    private JsonFile json;

    @Test
    public void test_json_save() throws FileNotFoundException {
        Json j = new Json(JsonFile.class, "test.json");
        JsonFile test = new JsonFile(12, "Je suis une description", "Je suis un titre", true, "Attribut");
        j.save(test);
    }

    @Test
    public void test_json_load() throws FileNotFoundException {
        Json j = new Json(JsonFile.class, "test.json");
        JsonFile testload = (JsonFile) j.load();
        System.out.println(testload.toString());
        assertEquals("Je titre n'est pas bon", "Je suis un titre", testload.getTitle());
    }

}
