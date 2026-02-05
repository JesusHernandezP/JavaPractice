package com.vehiculos.aplicacion;

import com.vehiculos.dominio.Vehiculo;
import com.vehiculos.dominio.excepciones.VehiculoValidationException;
import com.vehiculos.dominio.excepciones.VehiculoValidationTypesExceptionsEnum;

import java.time.LocalDate;

class ValidarVehiculoService {

    private static ValidarVehiculoService instance;

    private ValidarVehiculoService() {}

    static ValidarVehiculoService getInstance() {
        if (instance == null) {
            instance = new ValidarVehiculoService();
        }
        return instance;
    }

    void validacionCreacion(Vehiculo v) throws VehiculoValidationException {

        if (v.getMatricula() == null || v.getMatricula().trim().isEmpty() || v.getMatricula().trim().length() < 4) {
            throw new VehiculoValidationException(VehiculoValidationTypesExceptionsEnum.MATRICULA_INCORRECTA);
        }

        if (v.getMarca() == null || v.getMarca().trim().isEmpty() || v.getMarca().trim().length() < 2) {
            throw new VehiculoValidationException(VehiculoValidationTypesExceptionsEnum.MARCA_INCOMPLETA);
        }

        if (v.getModelo() == null || v.getModelo().trim().isEmpty()) {
            throw new VehiculoValidationException(VehiculoValidationTypesExceptionsEnum.MODELO_INCOMPLETO);
        }

        if (v.getPrecio() < 0) {
            throw new VehiculoValidationException(VehiculoValidationTypesExceptionsEnum.PRECIO_INCORRECTO);
        }

        if (v.getFechaMatricula() == null || v.getFechaMatricula().isAfter(LocalDate.now())) {
            throw new VehiculoValidationException(VehiculoValidationTypesExceptionsEnum.FECHA_MATRICULA_INCORRECTA);
        }
    }

    void validacionBuscar(int id) throws VehiculoValidationException {
        if (id <= 0) {
            throw new VehiculoValidationException(VehiculoValidationTypesExceptionsEnum.ID_INCORRECTO);
        }
    }

    void validacionActualizacion(Vehiculo v) throws VehiculoValidationException {
        validacionBuscar(v.getId());
        validacionCreacion(v);
    }
}
