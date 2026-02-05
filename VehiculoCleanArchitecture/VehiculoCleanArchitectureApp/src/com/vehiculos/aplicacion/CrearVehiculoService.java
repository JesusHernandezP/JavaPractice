package com.vehiculos.aplicacion;

import com.vehiculos.dominio.IVehiculoRepository;
import com.vehiculos.dominio.Vehiculo;
import com.vehiculos.dominio.excepciones.VehiculoExistYetException;

import java.time.LocalDate;
import java.util.Optional;

public class CrearVehiculoService {

    private final IVehiculoRepository vehiculoRepository;

    public CrearVehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public void crearVehiculo(String matricula, String marca, String modelo, float precio, LocalDate fechaMatricula) throws Exception {
        Vehiculo v = new Vehiculo(0, matricula, marca, modelo, precio, fechaMatricula);
        crearVehiculo(v);
    }

    public void crearVehiculo(Vehiculo vehiculo) throws Exception {
        // asigna id desde repo
        vehiculo.setId(vehiculoRepository.getNextId());

        // valida
        ValidarVehiculoService.getInstance().validacionCreacion(vehiculo);

        // comprueba que no exista ese id (patrón del ejemplo)
        Optional<Vehiculo> localizado = vehiculoRepository.buscarPorId(vehiculo.getId());
        if (localizado.isPresent()) {
            throw new VehiculoExistYetException(vehiculo.getId());
        }

        // guarda
        vehiculoRepository.guardar(vehiculo);
    }
}
