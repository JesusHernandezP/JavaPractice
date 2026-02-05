package com.vehiculos.aplicacion;

import com.vehiculos.dominio.IVehiculoRepository;
import com.vehiculos.dominio.Vehiculo;
import com.vehiculos.dominio.excepciones.VehiculoNotFoundException;

import java.time.LocalDate;
import java.util.Optional;

public class ActualizarVehiculoService {

    private final IVehiculoRepository vehiculoRepository;

    public ActualizarVehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public void actualizarVehiculo(int id, String matricula, String marca, String modelo, float precio, LocalDate fechaMatricula) throws Exception {
        Vehiculo v = new Vehiculo(id, matricula, marca, modelo, precio, fechaMatricula);
        actualizarVehiculo(v);
    }

    public void actualizarVehiculo(Vehiculo vehiculo) throws Exception {
        ValidarVehiculoService.getInstance().validacionActualizacion(vehiculo);

        Optional<Vehiculo> localizado = vehiculoRepository.buscarPorId(vehiculo.getId());
        if (localizado.isEmpty()) {
            throw new VehiculoNotFoundException(vehiculo.getId());
        }

        vehiculoRepository.actualizar(vehiculo);
    }
}
