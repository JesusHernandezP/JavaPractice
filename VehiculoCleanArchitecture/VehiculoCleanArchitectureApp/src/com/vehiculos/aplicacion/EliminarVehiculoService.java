package com.vehiculos.aplicacion;

import com.vehiculos.dominio.IVehiculoRepository;
import com.vehiculos.dominio.Vehiculo;
import com.vehiculos.dominio.excepciones.VehiculoNotFoundException;

import java.util.Optional;

public class EliminarVehiculoService {

    private final IVehiculoRepository vehiculoRepository;

    public EliminarVehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public void eliminarPorId(int id) throws Exception {
        Optional<Vehiculo> localizado = vehiculoRepository.buscarPorId(id);
        if (localizado.isEmpty()) {
            throw new VehiculoNotFoundException(id);
        }

        vehiculoRepository.eliminarPorId(id);
    }
}
