package com.example.simulador.service;

import com.example.simulador.dto.CuotaDetalle;
import com.example.simulador.dto.SimulacionResponse;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CalculadoraCreditoService {

    public static SimulacionResponse calcularCuotasJson(double valorCompra, double tasaMensual, double tasaEA, int cuotas,
                                                        LocalDate fechaInicio, LocalDate fechaCorte, double cuotaManejo, Locale localeColombia) {

        NumberFormat formatoCOP = NumberFormat.getCurrencyInstance(localeColombia);
        long diasPrimerPeriodo = ChronoUnit.DAYS.between(fechaInicio, fechaCorte);
        double interesPrimerPeriodo = (valorCompra * tasaMensual) * (diasPrimerPeriodo / 30.0);

        double saldo = valorCompra;
        double abonoCapital = valorCompra / cuotas;
        double totalInteres = 0;
        double totalPagado = 0;
        double totalCuotaManejo = 0;

        List<CuotaDetalle> detalleCuotas = new ArrayList<>();

        for (int i = 1; i <= cuotas; i++) {
            double interes;

            if (cuotas == 1) {
                interes = 0;
            } else {
                interes = (i == 1) ? interesPrimerPeriodo : saldo * tasaMensual;
            }

            double cuota = abonoCapital + interes;
            double totalCuotaConManejo = cuota + cuotaManejo;
            saldo -= abonoCapital;

            totalInteres += interes;
            totalPagado += totalCuotaConManejo;
            totalCuotaManejo += cuotaManejo;

            LocalDate fechaCuota = fechaCorte.plusMonths(i);
            Month mes = fechaCuota.getMonth();
            String nombreMes = mes.getDisplayName(TextStyle.FULL, localeColombia).toUpperCase();
            int anio = fechaCuota.getYear();

            CuotaDetalle cuotaDetalle = new CuotaDetalle(
                    i,
                    nombreMes + " " + anio,
                    formatoCOP.format(cuota),
                    formatoCOP.format(interes),
                    formatoCOP.format(abonoCapital),
                    formatoCOP.format(cuotaManejo),
                    formatoCOP.format(totalCuotaConManejo),
                    formatoCOP.format(Math.max(saldo, 0))
            );

            detalleCuotas.add(cuotaDetalle);
        }

        return new SimulacionResponse(
                detalleCuotas,
                formatoCOP.format(totalPagado),
                formatoCOP.format(totalInteres),
                formatoCOP.format(totalCuotaManejo)
        );
    }

}
