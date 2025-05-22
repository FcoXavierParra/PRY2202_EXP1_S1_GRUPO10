/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exp1_s1_grupo10;

/*@author bclaros y fparraa*/

public class Cuenta {
    private int numeroCuenta;
    private int saldo;

    public Cuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void depositar(int monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("¡Depósito realizado de manera exitosa!");
            System.out.println("Usted tiene un saldo actual de " + saldo + " pesos.");
        } else {
            System.out.println("El monto ingresado no es válido.");
        }
    }

    public void girar(int monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a cero.");
        } else if (monto > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo -= monto;
            System.out.println("Giro realizado. Saldo actual: " + saldo + " pesos.");
        }
    }
}
