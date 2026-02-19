package com.example.simulador.dto;

public class CuotaDetalle {
    private int numero;
    private String mesAnio;
    private String valorCuota;
    private String interes;
    private String abonoCapital;
    private String saldoRestante;

    public CuotaDetalle() {
    }

    public CuotaDetalle(int numero, String mesAnio, String valorCuota, String interes,
                        String abonoCapital, String saldoRestante) {
        this.numero = numero;
        this.mesAnio = mesAnio;
        this.valorCuota = valorCuota;
        this.interes = interes;
        this.abonoCapital = abonoCapital;
        this.saldoRestante = saldoRestante;
    }

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
