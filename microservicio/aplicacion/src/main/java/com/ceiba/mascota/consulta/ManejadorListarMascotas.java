package com.ceiba.mascota.consulta;

import com.ceiba.usuario.modelo.dto.DtoMascota;
import com.ceiba.usuario.modelo.dto.DtoServicio;
import com.ceiba.usuario.puerto.dao.DaoMascota;
import com.ceiba.usuario.puerto.dao.DaoServicio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarMascotas {

    private final DaoMascota daoMascota;

    public ManejadorListarMascotas(DaoMascota daoMascota) {
        this.daoMascota = daoMascota;
    }

    public List<DtoMascota> ejecutar(){ return this.daoMascota.listar(); }
}
