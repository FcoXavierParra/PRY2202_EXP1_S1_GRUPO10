/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/*@author bclaros y fparraa*/


package com.mycompany.exp1_s1_grupo10;
import java.util.Scanner;

public class Main {

    public static boolean validarRut(String rutCompleto) {
        // Formato esperado: XXXXXXXX-Y (sin puntos, con guion)
        if (!rutCompleto.matches("^\\d{7,8}-[\\dkK]$")) {
            return false;
        }

        String[] partes = rutCompleto.split("-");
        String numero = partes[0];
        String dvIngresado = partes[1].toUpperCase();

        // Cálculo del dígito verificador
        int suma = 0;
        int factor = 2;
        for (int i = numero.length() - 1; i >= 0; i--) {
            suma += Character.getNumericValue(numero.charAt(i)) * factor;
            factor = (factor == 7) ? 2 : factor + 1;
        }

        int residuo = 11 - (suma % 11);
        String dvCalculado;
        if (residuo == 11) {
            dvCalculado = "0";
        } else if (residuo == 10) {
            dvCalculado = "K";
        } else {
            dvCalculado = String.valueOf(residuo);
        }

        return dvIngresado.equals(dvCalculado);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = null;
        int intentos = 0;

        while (intentos < 2) {
            System.out.println("\nMENÚ");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver datos de cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Girar");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Entrada inválida. Ingrese un número del 1 al 6.");
                intentos++;
                continue;
            }

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion < 1 || opcion > 6) {
                System.out.println("Opción no válida. Intente nuevamente.");
                intentos++;
                continue;
            }

            intentos = 0; // Reiniciar contador si opción es válida

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese Rut (sin puntos, con guion): ");
                    String rut = scanner.nextLine();
                    if (!validarRut(rut)) {
                        System.out.println("RUT inválido. Verifique formato y dígito verificador.");
                        break;
                    }
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese apellido paterno: ");
                    String apellidoP = scanner.nextLine();
                    System.out.print("Ingrese apellido materno: ");
                    String apellidoM = scanner.nextLine();
                    System.out.print("Ingrese domicilio: ");
                    String domicilio = scanner.nextLine();
                    System.out.print("Ingrese comuna: ");
                    String comuna = scanner.nextLine();
                    System.out.print("Ingrese teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Ingrese número de cuenta (9 dígitos): ");
                    int numCuenta = scanner.nextInt();
                    cliente = new Cliente(rut, nombre, apellidoP, apellidoM, domicilio, comuna, telefono, numCuenta);
                    System.out.println("¡Cliente registrado con éxito!");
                    break;
                case 2:
                    if (cliente != null) cliente.mostrarDatos();
                    else System.out.println("Debe registrar un cliente primero.");
                    break;
                case 3:
                    if (cliente != null) {
                        System.out.print("Ingrese un monto para depositar: ");
                        int monto = scanner.nextInt();
                        cliente.getCuenta().depositar(monto);
                    } else System.out.println("Debe registrar un cliente primero.");
                    break;
                case 4:
                    if (cliente != null) {
                        System.out.print("Ingrese un monto para girar: ");
                        int monto = scanner.nextInt();
                        cliente.getCuenta().girar(monto);
                    } else System.out.println("Debe registrar un cliente primero.");
                    break;
                case 5:
                    if (cliente != null) {
                        System.out.println("Saldo actual: " + cliente.getCuenta().getSaldo() + " pesos");
                    } else System.out.println("Debe registrar un cliente primero.");
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
            }
        }

        System.out.println("Demasiados intentos inválidos. Cerrando el programa.");
        scanner.close();
    }
}