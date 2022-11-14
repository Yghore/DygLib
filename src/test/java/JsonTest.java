import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.testng.AssertJUnit.assertEquals;

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
