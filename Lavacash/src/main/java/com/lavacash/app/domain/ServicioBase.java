/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavacash.app.domain;

import java.sql.Time;

/**
 *
 * @author fabri
 */
public class ServicioBase extends Servicio{
    
    public ServicioBase(int codigo, int tipo, String nombre, String descripcion, double  precio, Time tiempo) {
        super(codigo, tipo, nombre, descripcion, precio, tiempo);
    }

    @Override
    public Time calcularTiempo() {
        return super.getTiempo();
    }

    @Override
    public double calcularPrecio() {
        return super.getPrecio();
    }

    boolean esCompuesto() {
        return false;
    }

}
