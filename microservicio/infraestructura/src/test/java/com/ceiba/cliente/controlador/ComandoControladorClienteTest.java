package com.ceiba.cliente.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ComandoClienteTestDataBuilder;
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
@WebMvcTest(ComandoControladorCliente.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorClienteTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deberia crear un cliente")
    void deberiaCrearUnCliente()throws Exception{
        //Arrange
        ComandoCliente cliente = new ComandoClienteTestDataBuilder().build();
        //act-assert
        mockMvc.perform(post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andExpect(content().json("{valor:4}"));
    }

    @Test
    @DisplayName("Deberia fallar al crear un cliente con numero identificacion repetida")
    void deberiaFallarAlCrearClienteConNumeroIdentificacionRepetida()throws Exception{
        //Arrange
        ComandoCliente cliente = new ComandoClienteTestDataBuilder().conNumeroIdentificacion("1005754420").build();
        //act-assert
        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{'nombreExcepcion':'ExcepcionDuplicidad','mensaje':'El cliente ya existe en el sistema'}"));
    }



    @Test
    @DisplayName("Deberia actualizar un cliente")
    void deberiaActualizarUnCliente()throws Exception{
        //Arrange
        Long id = 1L;
        ComandoCliente cliente = new ComandoClienteTestDataBuilder().conNumeroIdentificacion("1005754420").build();
        //act-assert
        mockMvc.perform(put("/clientes/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk());

    }


    @Test
    @DisplayName("Deberia eliminar un cliente")
    void deberiaEliminarUnCliente()throws Exception{
        //Arrange
        Long id = 3L;
        //act-assert
        mockMvc.perform(delete("/clientes/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
        mockMvc.perform(get("/clientes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)));

    }




}
