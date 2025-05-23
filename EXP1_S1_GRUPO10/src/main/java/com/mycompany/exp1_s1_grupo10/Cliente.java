/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exp1_s1_grupo10;

/*@author bclaros y fparraa*/

public class Cliente {
    private String rut, nombre, apellidoP, apellidoM, domicilio, comuna, telefono;
    private Cuenta cuenta;

    public Cliente(String rut, String nombre, String apellidoP, String apellidoM, String domicilio, String comuna, String telefono, int numeroCuenta) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuenta = new Cuenta(numeroCuenta);
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void mostrarDatos() {
        System.out.println("Rut: " + rut);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido paterno: " + apellidoP);
        System.out.println("Apellido materno: " + apellidoM);
        System.out.println("Domicilio: " + domicilio);
        System.out.println("Comuna: " + comuna);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Cuenta Corriente: " + cuenta.getNumeroCuenta());
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    public String getRut() {
    return rut;
}
    
}