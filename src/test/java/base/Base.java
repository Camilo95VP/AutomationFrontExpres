package base;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.openqa.selenium.WebDriver;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.expres.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;

public class Base {
    @Managed
    protected WebDriver browser;

    public void actorSetupTheBrowser(String actorName) {
        setUpLog4j2();
        setUpBrowser(browser);
        setUpUser(actorName, browser);
    }

    private void setUpBrowser(WebDriver browser) {
        browser.manage().deleteAllCookies();
        browser.manage().window().maximize();
    }

    private void setUpLog4j2() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    private void setUpUser(String name, WebDriver driver) {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(name).can(BrowseTheWeb.with(driver));
    }

    @After
    public void tearDown() {
        // No cerrar el navegador al final de la prueba
        // Esto permite que el navegador permanezca abierto después de la ejecución de las pruebas
        // Serenity se encargará de cerrar el navegador automáticamente
    }
}
