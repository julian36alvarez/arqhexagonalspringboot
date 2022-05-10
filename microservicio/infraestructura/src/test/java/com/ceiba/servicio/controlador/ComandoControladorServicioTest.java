package com.ceiba.servicio.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.servicio.comando.ComandoServicio;
import com.ceiba.servicio.testdatabuilder.ComandoServicioTestDataBuilder;
import com.ceiba.usuario.comando.ComandoUsuario;
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

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorUsuario.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorServicioTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear un servicio")
    void deberiaCrearUnServicio() throws Exception{
        // arrange
        LocalDateTime dateTime = LocalDate.now().atTime(10, 0);
        LocalDateTime fechaServicio = dateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        ComandoServicio servicio = new ComandoServicioTestDataBuilder().conFechaProgramada(fechaServicio).build();
        // act - assert
        mocMvc.perform(post("/servicios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(servicio)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(2)))
                .andExpect(jsonPath("$[0].idUsuario", is(1)))
                .andExpect(jsonPath("$[0].tipoUsuario", is(1)))
                .andExpect(jsonPath("$[0].idMascota", is(1)))
                .andExpect(jsonPath("$[0].total", is(45500d)))
                .andExpect(jsonPath("$[0].fechaProgramada", is(fechaServicio.format(formatter))))
                .andExpect(jsonPath("$[0].fechaEntrega", is(fechaServicio.plusHours(2).format(formatter))))
                .andExpect(jsonPath("$[0].fechaContable", is(fechaServicio.format(formatter))));
    }

    @Test
    @DisplayName("Deberia actualizar un servicios")
    void deberiaActualizarUnServicio() throws Exception{
        // arrange
        Long id = 1L;
        ComandoServicio servicio = new ComandoServicioTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/servicios/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(servicio)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar un usuario")
    void deberiaEliminarUnServicioo() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(delete("/servicios/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/servicios")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

}
