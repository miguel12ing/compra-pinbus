package com.choucair.formacion.definition;

import com.choucair.formacion.steps.RealizarConfiguracionReservaStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class viajePinbusDefinition {
    @Steps
    RealizarConfiguracionReservaStep realizarConfiguracionReservaStep;


    String casoPrueba;
    String casoPrueba2;


    @Given("^que me encuentro en la pagina inicial$")
        public void que_me_encuentro_en_la_pagina_inicial(){

        realizarConfiguracionReservaStep.abrirNavegador();

    }


    @Given("^seleccionar un bus y fecha para el viaje \"([^\"]*)\"$")
    public void seleccionar_un_bus_y_fecha_para_el_viaje (String id) {

        this.casoPrueba = id;
        this.casoPrueba2 =id;

    realizarConfiguracionReservaStep.llenarDatosViaje("01");
    realizarConfiguracionReservaStep.llenarDatosParaBuses("02");



    }

    @When("^lleno las informacion de los pasajeros$")
    public void lleno_las_informacion_de_los_pasajeros() {

     realizarConfiguracionReservaStep.llenarDatosDelPasajero();

    }

    @Then("^valido la sumatoria del viaje$")
    public void valido_la_sumatoria_del_viaje()  {

    }

}
