

package com.controlgastos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("INGRESO")
public class Ingreso extends Movimiento {

    protected Ingreso() {
        super();
    }

    public Ingreso(double monto, LocalDate fecha, String descripcion) {
        super(monto, fecha, descripcion);
    }

    @Override
    public String obtenerTipo() {
        return "Ingreso";
    }
}
