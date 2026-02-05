package com.vehiculos.aplicacion;

import com.vehiculos.dominio.IVehiculoRepository;
import com.vehiculos.dominio.Vehiculo;
import com.vehiculos.dominio.excepciones.VehiculoNotFoundException;

import java.util.Optional;

public class BuscarVehiculoService {

    private final IVehiculoRepository vehiculoRepository;

    public BuscarVehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public Vehiculo buscarPorId(int id) throws Exception {
        ValidarVehiculoService.getInstance().validacionBuscar(id);

        Optional<Vehiculo> opt = vehiculoRepository.buscarPorId(id);
        if (opt.isPresent()) {
            return opt.get();
        }

        throw new VehiculoNotFoundException(id);
    }
}
