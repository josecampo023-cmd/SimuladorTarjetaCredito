package com.example.simulador.model;

public class SimulacionRequest {

    private String valorCompra;
    private String tasaPactada;
    private String tasaEAFacturada;
    private Integer cuotas;
    private String fechaInicio;
    private String fechaCorte;
    private String cuotaManejo;

    // Getters
    public String getValorCompra() {
        return valorCompra;
    }

    public String getTasaPactada() {
        return tasaPactada;
    }

    public String getTasaEAFacturada() {
        return tasaEAFacturada;
    }

    public Integer getCuotas() {
        return cuotas;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaCorte() {
        return fechaCorte;
    }

    public String getCuotaManejo() {
        return cuotaManejo;
    }

    // Setters
    public void setValorCompra(String valorCompra) {
        this.valorCompra = valorCompra;
    }

    public void setTasaPactada(String tasaPactada) {
        this.tasaPactada = tasaPactada;
    }

    public void setTasaEAFacturada(String tasaEAFacturada) {
        this.tasaEAFacturada = tasaEAFacturada;
    }

    public void setCuotas(Integer cuotas) {
        this.cuotas = cuotas;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaCorte(String fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public void setCuotaManejo(String cuotaManejo) {
        this.cuotaManejo = cuotaManejo;
    }
}
