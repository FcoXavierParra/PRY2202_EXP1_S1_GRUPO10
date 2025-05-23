/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/*@author bclaros y fparraa*/


package com.mycompany.exp1_s1_grupo10;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

   
    public static boolean validarRut(String rutFormateado) {
    // Validar formato con puntos como separadores de miles
    if (!rutFormateado.matches("^\\d{1,3}(\\.\\d{3})*-?[\\dkK]$")) {
        return false;
    }

    // Eliminar puntos y separar en número y dígito verificador
    String rutSinPuntos = rutFormateado.replace(".", "");
    String[] partes = rutSinPuntos.split("-");
    if (partes.length != 2) return false;

    String numero = partes[0];
    String dvIngresado = partes[1].toUpperCase();

    int suma = 0;
    int factor = 2;
    for (int i = numero.length() - 1; i >= 0; i--) {
        suma += Character.getNumericValue(numero.charAt(i)) * factor;
        factor = (factor == 7) ? 2 : factor + 1;
    }

    int residuo = 11 - (suma % 11);
    String dvCalculado = switch (residuo) {
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
    
    public static Cliente buscarClientePorRUT(ArrayList<Cliente> clientes, String rut) {
    for (Cliente cliente : clientes) {
        if (cliente.getRut().equalsIgnoreCase(rut)) {
            return cliente;
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
        System.out.print("Ingrese Rut (puntos,guion ej: 12.345.678-K): ");
        rut = scanner.nextLine();

        if (!validarRut(rut)) {
            System.out.println("RUT inválido.");
            rutIntentos++;
        } else {
            rutValido = true;
            break;
        }
    }

    if (!rutValido) {
        System.out.println("Demasiados intentos fallidos.");
        break;
    }

    Cliente clienteExistente = buscarClientePorRUT(clientes, rut);
    
    if (clienteExistente != null) {
        System.out.println("El cliente ya existe.");
    } else {
        System.out.print("Ingrese número de cuenta: ");

        int cuentaIntentos = 0;
        String cuentaInput = "";
        boolean cuentaValida = false;

while (cuentaIntentos < 2) {
    System.out.print("Ingrese número de cuenta (9 dígitos): ");
    cuentaInput = scanner.nextLine();

    if (!cuentaInput.matches("^\\d{9}$")) {
        System.out.println("Número de cuenta inválido. Debe tener exactamente 9 dígitos.");
        cuentaIntentos++;
    } else {
        cuentaValida = true;
        break;
    }
}

if (!cuentaValida) {
    System.out.println("Demasiados intentos fallidos.");
    break;
}
        int numeroCuenta = Integer.parseInt(cuentaInput);
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
        System.out.print("Ingrese edad: ");
        int edad = Integer.parseInt(scanner.nextLine());

        Cliente nuevo = new Cliente(rut, nombre, apellidoP, apellidoM, domicilio, comuna, telefono, edad);
        nuevo.setCuenta(new Cuenta(numeroCuenta));
        clientes.add(nuevo);

        System.out.println("Cliente y cuenta creados exitosamente.");
    }
} 
                     case 2 -> {
                                            int intentos2 = 0;
                                            Cliente cliente2 = null;

                                            while (intentos2 < 2 && cliente2 == null) {
                                                System.out.print("Buscar por (1) RUT o (2) Número de cuenta: ");
                                                int tipoBusqueda = -1;
                                                try {
                                                    tipoBusqueda = Integer.parseInt(scanner.nextLine());
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Entrada inválida. Debe ingresar 1 o 2.");
                                                    intentos2++;
                                                    continue;
                                                }

                                                if (tipoBusqueda == 1) {
                                                    System.out.print("Ingrese RUT: ");
                                                    String rutBuscar = scanner.nextLine();
                                                    cliente2 = buscarClientePorRUT(clientes, rutBuscar);
                                                } else if (tipoBusqueda == 2) {
                                                    System.out.print("Ingrese número de cuenta: ");
                                                    int cuentaBuscar = Integer.parseInt(scanner.nextLine());
                                                    cliente2 = buscarClientePorCuenta(clientes, cuentaBuscar);
                                                } else {
                                                    System.out.println("Opción inválida. Ingrese 1 o 2.");
                                                    intentos++;
                                                    continue;
                                                }

                                                if (cliente2 != null) {
                                                } else {
                                                    intentos2++;
                                                    if (intentos2 < 2) {
                                                        System.out.println("Cliente no encontrado. Intente nuevamente.");
                                                    } else {
                                                        System.out.println("Demasiados intentos fallidos. Volviendo al menú principal.");
                                                    }
                                                }
                                            }

                                            if (cliente2 != null) {
                                                cliente2.mostrarDatos();
                                                break;
                                            }
                                        }
                 case 3 -> {
    int intentos3 = 0;
    Cliente cliente = null;
    while (intentos3 < 2 && cliente == null) {
        System.out.print("Ingrese número de cuenta: ");
        int cuentaBuscar = Integer.parseInt(scanner.nextLine());
        cliente = buscarClientePorCuenta(clientes, cuentaBuscar);
        if (cliente == null) {
            intentos3++;
            if (intentos3 < 2) {
                System.out.println("Cuenta no encontrada. Intente nuevamente.");
            } else {
                System.out.println("Demasiados intentos fallidos. Volviendo al menú principal.");
            }
        }
    }
    if (cliente != null) {
        System.out.print("Ingrese el monto a depositar: ");
        double monto = Double.parseDouble(scanner.nextLine());
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a cero.");
        } else {
            cliente.getCuenta().depositar(monto);
            System.out.println("Depósito exitoso. Saldo actual: " + cliente.getCuenta().getSaldo());
        }
    }
}

case 4 -> {
    int intentos4 = 0;
    Cliente cliente = null;
    while (intentos4 < 2 && cliente == null) {
        System.out.print("Ingrese número de cuenta: ");
        int cuentaBuscar = Integer.parseInt(scanner.nextLine());
        cliente = buscarClientePorCuenta(clientes, cuentaBuscar);
        if (cliente == null) {
            intentos4++;
            if (intentos4 < 2) {
                System.out.println("Cuenta no encontrada. Intente nuevamente.");
            } else {
                System.out.println("Demasiados intentos fallidos. Volviendo al menú principal.");
            }
        }
    }
    if (cliente != null) {
        if (cliente.getCuenta().getSaldo() <= 0) {
            System.out.println("No es posible girar. Saldo insuficiente.");
        } else {
            System.out.print("Ingrese el monto a girar: ");
            double monto = Double.parseDouble(scanner.nextLine());
            if (monto <= 0) {
                System.out.println("El monto debe ser mayor a cero.");
            } else if (monto > cliente.getCuenta().getSaldo()) {
                System.out.println("No puede girar más del saldo disponible.");
            } else {
                cliente.getCuenta().girar(monto);
                System.out.println("Giro exitoso. Saldo actual: " + cliente.getCuenta().getSaldo());
            }
        }
    }
}


                    case 5 -> {
                                            int intentos5 = 0;
                                            Cliente cliente = null;
                                            while (intentos5 < 2 && cliente == null) {
                                                System.out.print("Ingrese número de cuenta: ");
                                                int cuentaBuscar = Integer.parseInt(scanner.nextLine());
                                                cliente = buscarClientePorCuenta(clientes, cuentaBuscar);
                                                if (cliente == null) {
                                                    intentos5++;
                                                    if (intentos5 < 2) {
                                                        System.out.println("Cuenta no encontrada. Intente nuevamente.");
                                                    } else {
                                                        System.out.println("Demasiados intentos fallidos. Volviendo al menú principal.");
                                                    }
                                                }
                                            }
                                            if (cliente != null) {
                                                System.out.println("Saldo actual: " + cliente.getCuenta().getSaldo() + " pesos");
                                            }
                                        }
                    case 6 -> {
                        System.out.println("Saliendo del sistema...");
                        scanner.close();
                        return;
                    }
} 
        }
    }
}
}