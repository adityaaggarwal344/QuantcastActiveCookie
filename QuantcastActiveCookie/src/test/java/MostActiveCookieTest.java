import javafx.beans.binding.When;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareOnlyThisForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareOnlyThisForTest({MostActiveCookie.class,CookiesChecker.class})
public class MostActiveCookieTest {

    @Test
    public void runTest(){
        CookiesChecker cookiesChecker = Mockito.mock(CookiesChecker.class);
        cookiesChecker.getMostActiveCookie("cookies_log.csv",new DateTime());

    }
}
