package org.expres.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    public static final Target LOGIN_BUTTON = Target.the("Botón de Entrar")
            .located(By.cssSelector("div.navigate > ul > li:nth-child(1) > a"));
    public static final Target EMAIL_INPUT = Target.the("Campo de correo electrónico")
            .located(By.xpath("//*[@id=\"identifierId\"]"));
    public static final Target EMAIL_NEXT_BUTTON = Target.the("Boton siguiente")
            .located(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
    public static final Target PASSWORD_INPUT = Target.the("Contraseña")
            .located(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));

    public static final Target PASSWORD_NEXT_BUTTON = Target.the("Boton siguiente")
            .located(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
}
