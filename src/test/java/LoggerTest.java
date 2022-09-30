
import fr.yghore.dyglib.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoggerTest {




    @BeforeEach
    public void before()
    {
        new Logger(Logger.PURPLE + "T_DygLib");
    }

    @Test
    public void test_Print()
    {
        Logger.getLogger().sendPrint("Je suis un message de test");
    }

    @Test
    public void test_Print_Debug()
    {
        Logger.getLogger().sendDebug("Je suis un message de debug");
    }

    @Test
    public void test_Print_Error() { Logger.getLogger().sendError("Je suis une erreur visible!");}

}
