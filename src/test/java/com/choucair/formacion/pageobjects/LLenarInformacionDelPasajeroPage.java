package com.choucair.formacion.pageobjects;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.openqa.selenium.By.linkText;
import static org.hamcrest.MatcherAssert.assertThat;

public class LLenarInformacionDelPasajeroPage extends PageObject {

    @FindBy(xpath = "//input[@placeholder='Ingresa tu nombre']")
    WebElementFacade txtNombre;

    @FindBy(xpath = "//input[@placeholder='Ingresa tu apellido']")
    WebElementFacade txtApellido;

    @FindBy(xpath = "/html[1]/body[1]/content[1]/div[3]/div[2]/div[1]/div[1]/form[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/select[1]")
    WebElementFacade tipoDocumento;

    @FindBy(xpath = "//option[text()='Cedula de Ciudadania']")
    WebElementFacade selTipoDocumento;

    @FindBy(xpath = "//input[@placeholder='Ingresa tu número de doc.']")
    WebElementFacade txtNumeroDocumento;

    @FindBy(xpath = "//input[@placeholder='DD/MM/AAAA']")
    WebElementFacade txtDateNacimiento;

    @FindBy(xpath= "//input[@id='buyer_email']")
    WebElementFacade txtCorreoElectronico;

    @FindBy(xpath = "//input[@placeholder='Confirma tu email']")
    WebElementFacade txtConfirmarcorreo;

    @FindBy(xpath = "//input[@placeholder='Ingresa tu teléfono']")
    WebElementFacade txtNumeroTelefono;

    @FindBy(css = "input[value='efecty']")
    WebElementFacade medioPago;

    @FindBy(xpath = "//a[contains(text(),'Efecty')]")
    WebElementFacade btnmedioPago;

    @FindBy(xpath = "//span[contains(text(),'$')]")
    WebElementFacade btnRealizarCompra;

    @FindBy(css = "button#btnPaySale")
    WebElementFacade btnRealizarCompra2;

    @FindBy(xpath = "//th[contains(text(),'$')]")
    WebElementFacade txtTotalAPagar;

    @FindBy(xpath = "//h3[@class='total-price text-right'][contains(text(),'$')]")
    WebElementFacade txtTotalCompra;

    public void completarInformacionYDatosDelPasajero() {
       ((JavascriptExecutor)getDriver()).executeScript("window.focus();");


        Actions act = new Actions(getDriver());
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        txtNombre.sendKeys("Miguel");
        txtApellido.sendKeys("Vergara");
        tipoDocumento.click();
        selTipoDocumento.isDisplayed();
        selTipoDocumento.click();
        txtNumeroDocumento.sendKeys("1065005484");
        txtDateNacimiento.sendKeys("12/10/1994");
        txtCorreoElectronico.sendKeys("avergara94@hotmail.com");
        txtConfirmarcorreo.sendKeys("avergara94@hotmail.com");
        txtNumeroTelefono.sendKeys("3053346481");

        WebElement Element = getDriver().findElement(By.xpath("//a[contains(text(),'Efecty')]"));
        js.executeScript("arguments[0].scrollIntoView();", Element);

        btnmedioPago.click();
        btnRealizarCompra2.click();

        String labelv = txtTotalAPagar.getText().replace(" ","");
        String strMensaje = txtTotalCompra.getText();
        assertThat(strMensaje, equalTo(labelv));


    }
}
