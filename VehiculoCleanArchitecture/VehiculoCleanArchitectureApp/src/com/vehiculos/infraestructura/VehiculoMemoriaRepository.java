package com.vehiculos.infraestructura;

import com.vehiculos.dominio.IVehiculoRepository;
import com.vehiculos.dominio.Vehiculo;

import java.util.*;

public class VehiculoMemoriaRepository implements IVehiculoRepository {

    private static int NEXT_ID = 0;
    private final HashMap<Integer, Vehiculo> storage = new HashMap<>();

    @Override
    public int getNextId() {
        NEXT_ID++;
        return NEXT_ID;
    }

    @Override
    public void guardar(Vehiculo v) {
        storage.put(v.getId(), v);
    }

    @Override
    public Optional<Vehiculo> buscarPorId(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Vehiculo> listarTodas() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void actualizar(Vehiculo v) {
        storage.put(v.getId(), v);
    }

    @Override
    public void eliminarPorId(int id) {
        storage.remove(id);
    }
}
