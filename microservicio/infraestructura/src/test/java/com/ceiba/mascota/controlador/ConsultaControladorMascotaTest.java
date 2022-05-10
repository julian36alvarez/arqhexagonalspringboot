package com.ceiba.mascota.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.usuario.controlador.ConsultaControladorUsuario;
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
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorUsuario.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorMascotaTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia listar las mascotas")
    void deberiaListarMascotas() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/mascotas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(300)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("Nevil")))
                .andExpect(jsonPath("$[0].especie", is("PERRO")))
                .andExpect(jsonPath("$[0].raza", is("German Shepherd")))
                .andExpect(jsonPath("$[0].idCliente", is(36)));

    }

    @Test
    @DisplayName("Deberia listar las mascotas")
    void deberiaListarLasMascotasDeUnCliente() throws Exception {
        // arrange
        // act - assert
        Long idCliente = 36L;
        mocMvc.perform(get("/mascotas/cliente/{idCliente}", idCliente)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("Nevil")))
                .andExpect(jsonPath("$[0].especie", is("PERRO")))
                .andExpect(jsonPath("$[0].raza", is("German Shepherd")))
                .andExpect(jsonPath("$[0].idCliente", is(36)))
                .andExpect(jsonPath("$[1].id", is(76)))
                .andExpect(jsonPath("$[1].nombre", is("Arty")))
                .andExpect(jsonPath("$[1].especie", is("PERRO")))
                .andExpect(jsonPath("$[1].raza", is("Labrador")))
                .andExpect(jsonPath("$[1].idCliente", is(36)));

    }


}
