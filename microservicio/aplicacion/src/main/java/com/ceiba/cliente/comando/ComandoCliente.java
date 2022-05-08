package com.ceiba.cliente.comando;

import com.ceiba.usuario.modelo.dto.DtoMascota;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCliente {

    private Long id;
    private Long identificacion;
    private String nombre;
    private String direccion;
    private Long telefono;
    private List<DtoMascota> mascotas;

}
