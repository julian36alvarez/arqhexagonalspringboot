package com.ceiba.servicio.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.servicio.comando.ComandoServicio;
import com.ceiba.servicio.comando.manejador.ManejadorActualizarServicio;
import com.ceiba.servicio.comando.manejador.ManejadorCrearServicio;
import com.ceiba.servicio.comando.manejador.ManejadorEliminarServicio;
import com.ceiba.servicio.consulta.ManejadorListarServicios;
import com.ceiba.servicio.modelo.dto.DtoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/servicios")
@Api(tags = { "Controlador comando servicios"})
public class ComandoControladorServicio {

    private final ManejadorCrearServicio manejadorCrearServicio;
	private final ManejadorEliminarServicio manejadorEliminarServicio;
	private final ManejadorActualizarServicio manejadorActualizarServicio;

	private final ManejadorListarServicios manejadorListarServicios;

    @Autowired
    public ComandoControladorServicio(ManejadorCrearServicio manejadorCrearServicio,
									  ManejadorEliminarServicio manejadorEliminarServicio,
									  ManejadorActualizarServicio manejadorActualizarServicio, ManejadorListarServicios manejadorListarServicios) {
        this.manejadorCrearServicio = manejadorCrearServicio;
		this.manejadorEliminarServicio = manejadorEliminarServicio;
		this.manejadorActualizarServicio = manejadorActualizarServicio;
		this.manejadorListarServicios = manejadorListarServicios;
	}

    @PostMapping
    @ApiOperation("Crear servicio")
    public List<DtoServicio> crear(@RequestBody ComandoServicio comandoServicio) {
		ComandoRespuesta<Long> id = manejadorCrearServicio.ejecutar(comandoServicio);
		return this.manejadorListarServicios.ejecutarPorIdServicio(id.getValor());
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar servicio")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarServicio.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Servicio")
	public void actualizar(@RequestBody ComandoServicio comandoServicio,@PathVariable Long id) {
		comandoServicio.setId(id);
		manejadorActualizarServicio.ejecutar(comandoServicio);
	}
}
