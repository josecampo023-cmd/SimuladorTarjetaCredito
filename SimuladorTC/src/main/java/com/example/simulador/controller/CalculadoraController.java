package com.example.simulador.controller;

import com.example.simulador.dto.SimulacionResponse;
import com.example.simulador.exception.BusinessException;
import com.example.simulador.model.SimulacionRequest;
import com.example.simulador.service.CalculadoraCreditoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RestController
@RequestMapping("/api/calculadora")
@CrossOrigin(origins = "*") // <- Agrega esta línea
public class CalculadoraController {

    @PostMapping("/simular")
    public ResponseEntity<SimulacionResponse> simularCredito(@RequestBody SimulacionRequest request) {
        // Validaciones con excepciones de negocio
        if (request.getValorCompra() == null || request.getValorCompra().isEmpty()) {
            throw new BusinessException("BUS_001", "Campo requerido", "El valor de la compra es obligatorio.");
        }
        if (request.getTasaPactada() == null || request.getTasaPactada().isEmpty()) {
            throw new BusinessException("BUS_002", "Campo requerido", "La tasa pactada mensual es obligatoria.");
        }
        if (request.getTasaEAFacturada() == null || request.getTasaEAFacturada().isEmpty()) {
            throw new BusinessException("BUS_003", "Campo requerido", "La tasa efectiva anual es obligatoria.");
        }
        if (request.getCuotas() == null || request.getCuotas() <= 0) {
            throw new BusinessException("BUS_004", "Valor inválido", "El número de cuotas debe ser mayor que 0.");
        }
        if (request.getFechaInicio() == null || request.getFechaInicio().isEmpty()) {
            throw new BusinessException("BUS_005", "Campo requerido", "La fecha de inicio es obligatoria.");
        }
        if (request.getFechaCorte() == null || request.getFechaCorte().isEmpty()) {
            throw new BusinessException("BUS_006", "Campo requerido", "La fecha de corte es obligatoria.");
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            double valorCompra = parseColombianNumber(request.getValorCompra());
            double tasaMensual = Double.parseDouble(request.getTasaPactada().replace(",", ".")) / 100;
            double tasaEA = Double.parseDouble(request.getTasaEAFacturada().replace(",", ".")) / 100;
            LocalDate fechaInicio = LocalDate.parse(request.getFechaInicio(), formatter);
            LocalDate fechaCorte = LocalDate.parse(request.getFechaCorte(), formatter);
            double cuotaManejo = (request.getCuotaManejo() != null && !request.getCuotaManejo().isEmpty())
                    ? parseColombianNumber(request.getCuotaManejo())
                    : 0.0;

            SimulacionResponse response = CalculadoraCreditoService.calcularCuotasJson(
                    valorCompra,
                    tasaMensual,
                    tasaEA,
                    request.getCuotas(),
                    fechaInicio,
                    fechaCorte,
                    cuotaManejo,
                    new Locale("es", "CO")
            );

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new BusinessException("BUS_999", "Error inesperado", "Ocurrió un error en la simulación: " + e.getMessage());
        }
    }

    private double parseColombianNumber(String input) throws NumberFormatException {
        String cleaned = input.replace(".", "").replace(",", ".").replace("$", "").trim();

        // Validación: solo puede haber un punto decimal
        if (cleaned.chars().filter(c -> c == '.').count() > 1) {
            throw new NumberFormatException("Formato inválido: más de un punto decimal");
        }

        return Double.parseDouble(cleaned);
    }

}