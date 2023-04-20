/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;


public class Datos {
    
    int n;
    int po;
    String funcion;
    String derivada;
    

    public Datos(int n,int po, String funcion, String derivada) {
        this.n = n;
        this.po = po;
        this.funcion = funcion;
        this.derivada = derivada;
            
}

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getPo() {
        return po;
    }

    public void setPo(int po) {
        this.po = po;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getDerivada() {
        return derivada;
    }

    public void setDerivada(String derivada) {
        this.derivada = derivada;
    }
}