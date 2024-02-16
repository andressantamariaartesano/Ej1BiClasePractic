/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1bidimensionales;

/**
 *
 * @author dam
 */
public class Modelo {
    private String denominacion;
    private int tipo; // aquí guardo la posición de un array tipo
    private float[] ventas;

    public Modelo() {
        ventas = new float[6];
    }

    public float[] getVentas() {
        return ventas;
    }

    public void setVentas(float[] ventas) {
        this.ventas = ventas;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public float getUnaVenta(int mes){
        return ventas[mes];
    }
    
    public void setVentaUnMes(int mes, float importe){
        this.ventas[mes] = importe;
    }
    
    public void setDenominacionTipo(String denominacion, int tipo){
        this.denominacion = denominacion;
        this.tipo = tipo;
    }
    
    
}
