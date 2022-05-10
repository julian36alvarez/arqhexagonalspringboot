package com.ceiba.mascota.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.mascota.comando.ComandoMascota;
import com.ceiba.mascota.testdatabuilder.ComandoMascotaTestDataBuilder;
import com.ceiba.usuario.controlador.ComandoControladorUsuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorUsuario.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorMascotaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear una Mascota")
    void deberiaCrearUnaMascotao() throws Exception{
        // arrange
        ComandoMascota mascota = new ComandoMascotaTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/mascotas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mascota)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 301}"));
    }

    @Test
    @DisplayName("Deberia actualizar una mascota")
    void deberiaActualizarUnaMascota() throws Exception{
        // arrange
        Long id = 1L;
        ComandoMascota mascota = new ComandoMascotaTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/mascotas/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mascota)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar un usuario")
    void deberiaEliminarUnaMascota() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(delete("/mascotas/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/mascotas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(299)));
    }

}
