
package com.controlgastos.servicio;

import com.controlgastos.modelo.Movimiento;
import com.controlgastos.repositorio.MovimientoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestorFinanciero {

    private final MovimientoRepository movimientoRepository;

    public GestorFinanciero(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    // REGISTRAR MOVIMIENTO

    public void registrarMovimiento(Movimiento movimiento) {
        movimientoRepository.save(movimiento);
    }

    // CALCULAR INGRESOS

    public double calcularIngresos() {

        double total = 0;

        List<Movimiento> movimientos =
                movimientoRepository.findAll();

        for (Movimiento movimiento : movimientos) {

            if (movimiento.obtenerTipo().equals("Ingreso")) {
                total += movimiento.getMonto();
            }
        }

        return total;
    }

    // CALCULAR GASTOS

    public double calcularGastos() {

        double total = 0;

        List<Movimiento> movimientos =
                movimientoRepository.findAll();

        for (Movimiento movimiento : movimientos) {

            if (movimiento.obtenerTipo().equals("Gasto")) {
                total += movimiento.getMonto();
            }
        }

        return total;
    }

    // CALCULAR SALDO

    public double calcularSaldo() {
        return calcularIngresos() - calcularGastos();
    }

    // OBTENER HISTORIAL

    public List<Movimiento> obtenerMovimientos() {
        return movimientoRepository.findAllByOrderByFechaDesc();
    }
}
