package org.expres.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.expres.pages.LoginPage.*;

public class LoginExpresPage implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        String principalScreen = SerenityWebdriverManager.inThisTestThread().getCurrentDriver().getWindowHandle();
        try {
            actor.attemptsTo(
                    Click.on(LOGIN_BUTTON),
                    Switch.toTheOtherWindow(),
                    WaitUntil.the(EMAIL_INPUT, isVisible()).forNoMoreThan(Duration.ofSeconds(20)),
                    Enter.theValue(System.getenv("USER_NAME")).into(EMAIL_INPUT),
                    WaitUntil.the(EMAIL_NEXT_BUTTON, isVisible()).forNoMoreThan(Duration.ofSeconds(20)),
                    Click.on(EMAIL_NEXT_BUTTON),
                    WaitUntil.the(PASSWORD_INPUT, isVisible()).forNoMoreThan(Duration.ofSeconds(20)),
                    Enter.theValue(System.getenv("USER_PASSWORD")).into(PASSWORD_INPUT),
                    WaitUntil.the(PASSWORD_NEXT_BUTTON, isVisible()).forNoMoreThan(Duration.ofSeconds(20)),
                    Click.on(PASSWORD_NEXT_BUTTON)
            );
        } catch (NoSuchWindowException e) {
            e.printStackTrace();
        }

        actor.attemptsTo(
                Switch.toWindow(principalScreen)
        );
    }

    public static LoginExpresPage loginExpresPage() {
        return Tasks.instrumented(LoginExpresPage.class);
    }
}
