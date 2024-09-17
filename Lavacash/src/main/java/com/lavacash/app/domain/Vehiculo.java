/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavacash.app.domain;

/**
 *
 * @author Usuario
 */

public class Vehiculo {
    
    //quitar variable codigo solo manejar id
    private int id;
    private int codigo;
    private int tipo;
    private String placa;
    private String marca;
    private String modelo;
    private String descripcion;

    public Vehiculo(int id, int codigo, int tipo, String placa, String marca, String modelo, String descripcion) {
        this.id = id;
        this.codigo = codigo;
        this.tipo = tipo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
    }

    public Vehiculo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", codigo=" + codigo + ", tipo=" + tipo + ", placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", descripcion=" + descripcion + '}';
    }
    
    
}
