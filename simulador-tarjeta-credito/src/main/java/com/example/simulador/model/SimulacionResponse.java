package com.example.simulador.model;

import java.util.List;

public class SimulacionResponse {
    private String resumen;
    private List<Cuota> cuotas;
    private String totalPagado;
    private String totalIntereses;

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Cuota> cuotas) {
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

    public static class Cuota {
        private int numero;
        private String mesAnio;
        private String valorCuota;
        private String interes;
        private String abonoCapital;
        private String saldoRestante;

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public String getMesAnio() {
            return mesAnio;
        }

        public void setMesAnio(String mesAnio) {
            this.mesAnio = mesAnio;
        }

        public String getValorCuota() {
            return valorCuota;
        }

        public void setValorCuota(String valorCuota) {
            this.valorCuota = valorCuota;
        }

        public String getInteres() {
            return interes;
        }

        public void setInteres(String interes) {
            this.interes = interes;
        }

        public String getAbonoCapital() {
            return abonoCapital;
        }

        public void setAbonoCapital(String abonoCapital) {
            this.abonoCapital = abonoCapital;
        }

        public String getSaldoRestante() {
            return saldoRestante;
        }

        public void setSaldoRestante(String saldoRestante) {
            this.saldoRestante = saldoRestante;
        }
    }
}
