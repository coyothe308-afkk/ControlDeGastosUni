
package com.controlgastos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("GASTO")
public class Gasto extends Movimiento {

    protected Gasto() {
        super();
    }

    public Gasto(double monto, LocalDate fecha, String descripcion) {
        super(monto, fecha, descripcion);
    }

    @Override
    public String obtenerTipo() {
        return "Gasto";
    }
}
