package org.expres.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import org.expres.pages.HomePage;

import static jxl.biff.FormatRecord.logger;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenExpresPage implements Task {

    private HomePage homePage;


    @Override
    public <T extends Actor> void performAs(T actor) {
        try{
            actor.attemptsTo(
                    Open.browserOn(homePage));
        }catch (Exception exception){
            logger.error("Error: ", exception);
        }
    }

    public static OpenExpresPage openExpresPage() {
        return instrumented(OpenExpresPage.class);
    }
}
