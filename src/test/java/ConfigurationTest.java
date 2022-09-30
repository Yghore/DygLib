import fr.yghore.dyglib.Configuration.Configuration;
import fr.yghore.dyglib.Configuration.ConfigurationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ConfigurationTest
{

    private Configuration config;

    @BeforeEach
    public void before()
    {
        this.config = new Configuration("configTest.yml", false, "DygTest");
    }

    @Test
    public void Load_Test() throws ConfigurationException {

        new Configuration("configTest.yml", false, "Dygger").loadConfig(ConfigTest.class);

        this.config.loadConfig(ConfigTest.class);
        ConfigTest config1 = (ConfigTest) this.config.getConfig();
        assertEquals("La configuration n'est pas bonne :","salut", config1.test);
        assertEquals("La configuration n'est pas bonne :", config1.bool, true);
    }


}
