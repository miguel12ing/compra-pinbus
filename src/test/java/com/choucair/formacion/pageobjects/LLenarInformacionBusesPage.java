package com.choucair.formacion.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class LLenarInformacionBusesPage extends PageObject {

    @FindBy(xpath = "//div[@class='internal-page no-padding-top']//li[2]//div[1]")
    WebElementFacade tipoBus;

    @FindBy(xpath = "//button[contains(text(),'Seleccionar Sillas')]")
    WebElementFacade btnSeleccionarSillas;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-block']")
    WebElementFacade btncontinuar;

    @FindBy(xpath = "//div[@class='checkbox']//label[contains(text(),'Class Plus')]")
    WebElementFacade tipoBus2;

    @FindBy(css = "input[value='REY DORADO LO MÁXIMO']")
    WebElementFacade deselcionarBus;

    @FindBy(xpath = "'/html[1]/body[1]/content[1]/div[3]/div[4]/div[2]/div[1]/div[2]/div[3]/ul[1]/li[1]/div[1]/label[1]']")
    WebElementFacade boxTipoBus;

    @FindBy(xpath = "//button[@class='btn btn-primary'][contains(text(),'Seleccionar Sillas')]")
    List<WebElementFacade> listDeBuses;




    public void escogerBuses(String numeroDeSillaIda, String numeroDeSillaRegreso) {

        Actions act = new Actions(getDriver());
        waitABit(20000);
        tipoBus.click();
        btnSeleccionarSillas.click();
        waitFor(5).seconds();
        $("//span[@class='seat-number'][text()="+numeroDeSillaIda+"]").click();
        btncontinuar.click();
        waitFor(5).seconds();
        act.moveToElement(deselcionarBus).click().perform();
        waitFor(4).seconds();
       // act.moveToElement(deselcionarBus).click().perform();

        act.moveToElement(tipoBus2).click().perform();
        listDeBuses.get(0).click();
        waitFor(3).seconds();
        $("//span[@class='seat-number'][text()="+numeroDeSillaRegreso+"]").click();
        act.moveToElement(btncontinuar).click().perform();
        waitFor(5).seconds();

    }
}
