package com.choucair.formacion.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;

import java.util.List;

@DefaultUrl("https://pinbus.com")

public class RealizarConfiguracionReservaPage extends PageObject {

    @FindBy(xpath = "//input[@placeholder='Salida']")
    WebElementFacade btnSalida;

    @FindBy(xpath = "//input[@placeholder='Ingresa la ciudad de donde sales']")
    WebElementFacade textOrigen;

    @FindBy(xpath = "//input[@placeholder='Ingresa la ciudad a donde viajas']")
    WebElementFacade textDestino;

    @FindBy(xpath = "//span[contains(text(),'Noviembre 2019')]")
    WebElementFacade mesSalida;

    @FindBy(xpath = "//input[@placeholder='Regreso (opcional)']")
    WebElementFacade btnRegreso;

    @FindBy(xpath = "//span[contains(text(),'Noviembre 2019')]")
    WebElementFacade mesLLegada;

    @FindBy(xpath = "//div[3]//div[1]//div[2]//header[1]//span[3]")
    WebElementFacade btnSiguiente;

    @FindBy(xpath = "//div[4]//div[1]//div[2]//header[1]//span[3]")
    WebElementFacade btnSiguiente2;

    @FindBy(xpath = "//div[@class='vdp-datepicker__calendar']//div//span[@track-by='timestamp']")
    List<WebElementFacade> listDias;

    @FindBy(xpath = "/html[1]/body[1]/content[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/span[26]")
    WebElementFacade fechaRegreso;

    @FindBy(xpath = "//button[@id='btn_buscar']")
    WebElementFacade btnbuscar;

    public void llenarDatosParaViaje(String Origen, String Destino, String salida) {

        textOrigen.sendKeys(Origen, Keys.ENTER);
        textDestino.sendKeys(Destino, Keys.ENTER);
        btnSalida.click();
        btnSiguiente.click();

        int salida2= Integer.parseInt(salida);
        for (int i = 0; i < salida2; i++) {// tomanos el tamaño de la lista

            if (listDias.get(i).getText().equals(salida)) {// hace un get text y compara
                // con patter machest si ka expresion tiene el mismo texto y el da click
                listDias.get(i).click();
            }

        }

        btnRegreso.click();
        btnSiguiente2.click();
        fechaRegreso.waitUntilClickable();
        fechaRegreso.click();
        btnbuscar.click();
    }

}