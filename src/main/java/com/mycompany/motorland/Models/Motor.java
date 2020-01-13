/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.motorland.Models;

/**
 *
 * @author julut
 */

//Esta clase creará objetos con las mismas características de nuestra base de datos
public class Motor {
    
    private String modelo, fabricante;
    private int potencia, peso, cantidad;

    //Constructor en Vacio
    public Motor() {
    }
    
    //Constructor a través de datos 
    public Motor(String modelo, String fabricante, int potencia, int peso, int cantidad) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.potencia = potencia;
        this.peso = peso;
        this.cantidad = cantidad;
    }

    //Creamos getters y setters
    public String getModelo() {
        return modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getPeso() {
        return peso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
