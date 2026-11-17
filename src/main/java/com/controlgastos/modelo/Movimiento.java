
package com.controlgastos.modelo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "movimientos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double monto;

    @Column(nullable = false)
    private LocalDate fecha;

    private String descripcion;

    // Constructor vacío para Hibernate
    protected Movimiento() {
    }

    public Movimiento(double monto, LocalDate fecha, String descripcion) {

        setMonto(monto);
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    // GETTERS

    public Long getId() {
        return id;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // SETTERS

    public void setMonto(double monto) {

        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser mayor que cero"
            );
        }

        this.monto = monto;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // POLIMORFISMO

    public abstract String obtenerTipo();
}
