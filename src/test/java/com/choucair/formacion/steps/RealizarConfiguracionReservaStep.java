package com.choucair.formacion.steps;

import au.com.bytecode.opencsv.CSVReader;
import com.choucair.formacion.pageobjects.LLenarInformacionDelPasajeroPage;
import com.choucair.formacion.pageobjects.RealizarConfiguracionReservaPage;
import com.choucair.formacion.pageobjects.LLenarInformacionBusesPage;
import net.thucydides.core.annotations.Step;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class RealizarConfiguracionReservaStep {

    RealizarConfiguracionReservaPage realizarConfiguracionReservaPage;
    LLenarInformacionBusesPage llenarInformacionBusesPage;
    LLenarInformacionDelPasajeroPage llenarInformacionDelPasajeroPage;



    String[] datos;

    public void leerCSV(String id) {
        au.com.bytecode.opencsv.CSVReader reader;
        try {
            reader = new CSVReader(new FileReader("src/test/resources/Datadriven/Datos.csv"));

            String[] fila;
            while ((fila = reader.readNext()) != null) {
                Logger.getLogger(fila[0]);
                if (id.equals(fila[0].trim())) {
                    datos = fila;
                }
            }
            reader.close();
        } catch (IOException e) {
            Logger.getLogger("" + e);
        }
    }

        @Step
        public void abrirNavegador() {
            realizarConfiguracionReservaPage.open();
        }



        public void llenarDatosViaje (String id) {
        leerCSV(id);


            realizarConfiguracionReservaPage.llenarDatosParaViaje(datos[5],datos[6],datos[3]);



        }

        public void llenarDatosParaBuses(String id){
            leerCSV(id);

            llenarInformacionBusesPage.escogerBuses(datos[8],datos[9]);

        }

    public void llenarDatosDelPasajero() {
        llenarInformacionDelPasajeroPage.completarInformacionYDatosDelPasajero();
    }
}

