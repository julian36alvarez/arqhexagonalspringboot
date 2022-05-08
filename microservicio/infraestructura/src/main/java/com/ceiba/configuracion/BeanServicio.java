package com.ceiba.configuracion;

import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.mascota.servicio.ServicioActualizarMascota;
import com.ceiba.mascota.servicio.ServicioCrearMascota;
import com.ceiba.mascota.servicio.ServicioEliminarMascota;
import com.ceiba.servicio.servicio.ServicioActualizarServicio;
import com.ceiba.servicio.servicio.ServicioCrearServicio;
import com.ceiba.servicio.servicio.ServicioEliminarServicio;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.*;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;


import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;

import com.ceiba.mascota.puerto.repositorio.RepositorioMascota;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente) {
        return new ServicioCrearCliente(repositorioCliente);
    }

    @Bean
    public ServicioEliminarCliente servicioEliminarCliente(RepositorioCliente repositorioCliente) {
        return new ServicioEliminarCliente(repositorioCliente);
    }

    @Bean
    public ServicioActualizarCliente servicioActualizarCliente(RepositorioCliente repositorioCliente) {
        return new ServicioActualizarCliente(repositorioCliente);
    }

    @Bean
    public ServicioCrearServicio servicioCrearServicio(RepositorioServicio repositorioServicio) {
        return new ServicioCrearServicio(repositorioServicio);
    }

    @Bean
    public ServicioEliminarServicio servicioEliminarServicio(RepositorioServicio repositorioServicio) {
        return new ServicioEliminarServicio(repositorioServicio);
    }

    @Bean
    public ServicioActualizarServicio servicioActualizarServicio(RepositorioServicio repositorioServicio) {
        return new ServicioActualizarServicio(repositorioServicio);
    }


    @Bean
    public ServicioCrearMascota servicioCrearMascota(RepositorioMascota repositorioMascota) {
        return new ServicioCrearMascota(repositorioMascota);
    }

    @Bean
    public ServicioEliminarMascota servicioEliminarMascota(RepositorioMascota repositorioMascota) {
        return new ServicioEliminarMascota(repositorioMascota);
    }

    @Bean
    public ServicioActualizarMascota servicioActualizarMascota(RepositorioMascota repositorioMascota) {
        return new ServicioActualizarMascota(repositorioMascota);
    }



}
