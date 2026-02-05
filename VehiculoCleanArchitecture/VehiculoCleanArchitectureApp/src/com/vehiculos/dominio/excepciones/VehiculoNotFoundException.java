package com.vehiculos.dominio.excepciones;

public class VehiculoNotFoundException extends Exception {

    public VehiculoNotFoundException() {
        super("Vehiculo no encontrado");
    }

    public VehiculoNotFoundException(int id) {
        super("No existe el vehiculo con id " + id);
    }
}
