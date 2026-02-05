package com.vehiculos.dominio.excepciones;

public class VehiculoExistYetException extends Exception {

    public VehiculoExistYetException() {
        super("Vehiculo ya existe");
    }

    public VehiculoExistYetException(int id) {
        super("Ya existe un vehiculo con id " + id);
    }
}
