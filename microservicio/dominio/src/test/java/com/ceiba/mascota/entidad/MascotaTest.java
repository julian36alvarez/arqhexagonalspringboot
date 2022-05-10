package com.ceiba.mascota.entidad;

import com.ceiba.BasePrueba;



import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.mascota.servicio.testdatabuilder.MascotaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

 class MascotaTest {

    @Test
    @DisplayName("Deberia crear correctamente la mascota")
    void deberiaCrearCorrectamenteLaMascota() {
        Mascota mascota = new MascotaTestDataBuilder().conId(301L).build();
        assertEquals(301, mascota.getId());
        assertEquals("Olix", mascota.getNombre());
        assertEquals("Schnauzer", mascota.getRaza());
        assertEquals("PERRO", mascota.getEspecie());
        assertEquals(3, mascota.getIdCliente());
    }

    @Test
    void deberiaFallarSinNombreDeMascota() {

        //Arrange
        MascotaTestDataBuilder mascotaTestDataBuilder = new MascotaTestDataBuilder().conNombre(null).conId(301l);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    mascotaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre");
    }

    @Test
    void deberiaFallarSinEspecie() {

        //Arrange
        MascotaTestDataBuilder mascotaTestDataBuilder = new MascotaTestDataBuilder().conEspecie(null).conId(301L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    mascotaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la especie de la mascota");
    }

    @Test
    void deberiaFallarSinRaza() {

        //Arrange
        MascotaTestDataBuilder mascotaTestDataBuilder = new MascotaTestDataBuilder().conRaza(null).conId(301L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    mascotaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la raza");
    }

    @Test
    void deberiaFallarSinIdCliente() {

        //Arrange
        MascotaTestDataBuilder mascotaTestDataBuilder = new MascotaTestDataBuilder().conIdCliente(null).conId(301L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    mascotaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar cliente");
    }

    @Test
    void deberiaFallarSiLaEspecieNoEsPerroGato(){
        MascotaTestDataBuilder mascotaTestDataBuilder = new MascotaTestDataBuilder().conEspecie("Caballo").conId(301L);

        BasePrueba.assertThrows(() -> {
                    mascotaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Especie no valida");
    }



}
