package com.vehiculos.dominio.excepciones;

public class VehiculoValidationException extends Exception {

    public VehiculoValidationException(VehiculoValidationTypesExceptionsEnum type) {
        super(type.toString());
    }
}
