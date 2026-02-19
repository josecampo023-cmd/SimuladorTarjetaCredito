package com.example.simulador.dto;

import java.util.List;

public class SimulacionResponse {

    private List<CuotaDetalle> cuotas;
    private String totalPagado;
    private String totalIntereses;

    public SimulacionResponse(List<CuotaDetalle> cuotas, String totalPagado, String totalIntereses) {
        this.cuotas = cuotas;
        this.totalPagado = totalPagado;
        this.totalIntereses = totalIntereses;
    }

    public List<CuotaDetalle> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<CuotaDetalle> cuotas) {
        this.cuotas = cuotas;
    }

    public String getTotalPagado() {
        return totalPagado;
    }

    public void setTotalPagado(String totalPagado) {
        this.totalPagado = totalPagado;
    }

    public String getTotalIntereses() {
        return totalIntereses;
    }

    public void setTotalIntereses(String totalIntereses) {
        this.totalIntereses = totalIntereses;
    }
}
