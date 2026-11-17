
package com.controlgastos.controller;

import com.controlgastos.modelo.Ingreso;
import com.controlgastos.modelo.Gasto;
import com.controlgastos.servicio.GestorFinanciero;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class InicioController {

    private final GestorFinanciero gestorFinanciero;

    public InicioController(GestorFinanciero gestorFinanciero) {
        this.gestorFinanciero = gestorFinanciero;
    }

    @GetMapping("/")
    public String inicio(Model model) {

        model.addAttribute("saldo",
                gestorFinanciero.calcularSaldo());

        model.addAttribute("ingresos",
                gestorFinanciero.calcularIngresos());

        model.addAttribute("gastos",
                gestorFinanciero.calcularGastos());

        model.addAttribute("movimientos",
                gestorFinanciero.obtenerMovimientos());

        return "inicio";
    }

    @GetMapping("/ingresos")
    public String mostrarFormularioIngreso(Model model) {

        model.addAttribute("ingreso",
                new Ingreso(1, LocalDate.now(), ""));

        return "ingreso";
    }

    @PostMapping("/ingresos/registrar")
    public String registrarIngreso(
            @ModelAttribute Ingreso ingreso) {

        gestorFinanciero.registrarMovimiento(ingreso);

        return "redirect:/";
    }

    @GetMapping("/gastos")
    public String mostrarFormularioGasto(Model model) {

        model.addAttribute("gasto",
                new Gasto(1, LocalDate.now(), ""));

        return "gasto";
    }

    @PostMapping("/gastos/registrar")
    public String registrarGasto(
            @ModelAttribute Gasto gasto) {

        gestorFinanciero.registrarMovimiento(gasto);

        return "redirect:/";
    }
}
