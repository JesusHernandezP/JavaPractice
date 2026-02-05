package com.vehiculos.aplicacion;

import com.vehiculos.dominio.IVehiculoRepository;
import com.vehiculos.dominio.Vehiculo;

import java.util.List;

public class ListarVehiculoService {

    private final IVehiculoRepository vehiculoRepository;

    public ListarVehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public List<Vehiculo> listarTodas() throws Exception {
        return vehiculoRepository.listarTodas();
    }
}
