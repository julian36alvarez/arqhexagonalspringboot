package com.ceiba.mascota.consulta;

import com.ceiba.mascota.modelo.dto.DtoMascota;
import com.ceiba.mascota.puerto.dao.DaoMascota;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarMascotas {

    private final DaoMascota daoMascota;

    public ManejadorListarMascotas(DaoMascota daoMascota) {
        this.daoMascota = daoMascota;
    }

    public List<DtoMascota> ejecutar(){ return this.daoMascota.listar(); }

    public List<DtoMascota> ejecutarPorIdMascota(Long idMascota){
        return this.daoMascota.listarPorIdMascota(idMascota);
    }

    public List<DtoMascota> ejecutarMascotaPorIdCliente(Long idCliente){
        return this.daoMascota.listarMascotasPorIdCliente(idCliente);
    }
}
