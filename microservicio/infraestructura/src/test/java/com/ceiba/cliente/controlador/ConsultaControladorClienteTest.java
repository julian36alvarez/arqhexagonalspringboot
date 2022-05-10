package com.ceiba.cliente.controlador;

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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorUsuario.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorClienteTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia listar usuarios")
    void deberiaListarUsuarios() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/clientes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(100)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].identificacion", is(88565419)))
                .andExpect(jsonPath("$[0].nombre", is("Marrilee Winridge")))
                .andExpect(jsonPath("$[0].direccion", is("9753 Mesta Hill")))
                .andExpect(jsonPath("$[0].telefono", is(6087895)));

    }


}
