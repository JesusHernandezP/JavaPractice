package com.vehiculos.dominio;

import java.util.List;
import java.util.Optional;

public interface IVehiculoRepository {

    int getNextId() throws Exception;

    void guardar(Vehiculo v) throws Exception;

    Optional<Vehiculo> buscarPorId(int id) throws Exception;

    List<Vehiculo> listarTodas() throws Exception;

    void actualizar(Vehiculo v) throws Exception;

    void eliminarPorId(int id) throws Exception;
}
