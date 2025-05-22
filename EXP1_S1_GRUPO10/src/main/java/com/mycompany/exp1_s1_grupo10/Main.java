/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/*@author bclaros y fparraa*/


package com.mycompany.exp1_s1_grupo10;
import java.util.ArrayList;
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

        int suma = 0;
        int factor = 2;
        for (int i = numero.length() - 1; i >= 0; i--) {
            suma += Character.getNumericValue(numero.charAt(i)) * factor;
            factor = (factor == 7) ? 2 : factor + 1;
        }

        int residuo = 11 - (suma % 11);
        String dvCalculado;
        dvCalculado = switch (residuo) {
            case 11 -> "0";
            case 10 -> "K";
            default -> String.valueOf(residuo);
        };

        return dvIngresado.equals(dvCalculado);
    }

    public static Cliente buscarClientePorCuenta(ArrayList<Cliente> clientes, int numCuenta) {
        for (Cliente c : clientes) {
            if (c.getCuenta().getNumeroCuenta() == numCuenta) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Cliente> clientes = new ArrayList<>();
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
                
                intentos = 0;
                
                switch (opcion) {
                    case 1 -> {
                        int rutIntentos = 0;
                        boolean rutValido = false;
                        String rut = "";
                        while (rutIntentos < 2) {
                            System.out.print("Ingrese Rut (sin puntos, con guion): ");
                            rut = scanner.nextLine();
                            if (validarRut(rut)) {
                                rutValido = true;
                                break;
                            } else {
                                System.out.println("RUT inválido. Verifique formato y dígito verificador.");
                                rutIntentos++;
                            }
                        }
                        if (!rutValido) {
                            System.out.println("Demasiados intentos inválidos. Volviendo al menú principal.");
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
                        scanner.nextLine();
                        
                        if (buscarClientePorCuenta(clientes, numCuenta) != null) {
                            System.out.println("Número de cuenta ya registrado.");
                            break;
                        }
                        
                        Cliente nuevoCliente = new Cliente(rut, nombre, apellidoP, apellidoM, domicilio, comuna, telefono, numCuenta);
                        clientes.add(nuevoCliente);
                        System.out.println("¡Cliente registrado con éxito!");
                    }
                        
                    case 2 -> {
                        System.out.print("Ingrese número de cuenta: ");
                        int cuentaBuscar = scanner.nextInt();
                        scanner.nextLine();
                        Cliente cliente2 = buscarClientePorCuenta(clientes, cuentaBuscar);
                        if (cliente2 != null) {
                            cliente2.mostrarDatos();
                        } else {
                            System.out.println("Cuenta no encontrada.");
                        }
                    }
                        
                    case 3 -> {
                        System.out.print("Ingrese número de cuenta: ");
                        int cuentaDep = scanner.nextInt();
                        Cliente clienteDep = buscarClientePorCuenta(clientes, cuentaDep);
                        if (clienteDep != null) {
                            System.out.println("Cliente: " + clienteDep.getCuenta().getNumeroCuenta());
                            System.out.println("Nombre: " + clienteDep.getCuenta().getNumeroCuenta());
                            System.out.print("¿Desea continuar? (s/n): ");
                            scanner.nextLine();
                            String confirm = scanner.nextLine();
                            if (confirm.equalsIgnoreCase("s")) {
                                System.out.print("Ingrese monto a depositar: ");
                                int monto = scanner.nextInt();
                                clienteDep.getCuenta().depositar(monto);
                            }
                        } else {
                            System.out.println("Cuenta no encontrada.");
                        }
                    }
                        
                    case 4 -> {
                        System.out.print("Ingrese número de cuenta: ");
                        int cuentaGiro = scanner.nextInt();
                        Cliente clienteGiro = buscarClientePorCuenta(clientes, cuentaGiro);
                        if (clienteGiro != null) {
                            System.out.println("Nombre: " + clienteGiro.getCuenta().getNumeroCuenta());
                            System.out.print("¿Desea continuar? (s/n): ");
                            scanner.nextLine();
                            String confirm = scanner.nextLine();
                            if (confirm.equalsIgnoreCase("s")) {
                                System.out.print("Ingrese monto a girar: ");
                                int monto = scanner.nextInt();
                                clienteGiro.getCuenta().girar(monto);
                            }
                        } else {
                            System.out.println("Cuenta no encontrada.");
                        }
                    }
                        
                    case 5 -> {
                        System.out.print("Ingrese número de cuenta: ");
                        int cuentaSaldo = scanner.nextInt();
                        Cliente clienteSaldo = buscarClientePorCuenta(clientes, cuentaSaldo);
                        if (clienteSaldo != null) {
                            System.out.println("Nombre: " + clienteSaldo.getCuenta().getNumeroCuenta());
                            System.out.print("¿Desea continuar? (s/n): ");
                            scanner.nextLine();
                            String confirm = scanner.nextLine();
                            if (confirm.equalsIgnoreCase("s")) {
                                System.out.println("Saldo actual: " + clienteSaldo.getCuenta().getSaldo() + " pesos");
                            }
                        } else {
                            System.out.println("Cuenta no encontrada.");
                        }
                    }
                        
                    case 6 -> {
                        System.out.println("Saliendo del sistema...");
                        scanner.close();
                        return;
                    }
                }
            }
            
            System.out.println("Demasiados intentos inválidos. Cerrando el programa.");
        }
    }
}
