# Proyecto Java: Simulador de Gestión Bancaria — BankBoston

Este proyecto simula un sistema básico de gestión de cuentas bancarias para la institución ficticia **BankBoston**, como parte de la actividad *Exp1_S1* de la asignatura **Desarrollo Orientado a Objetos I** del primer año de la carrera de Analista Programador.

## 🎯 Objetivo pedagógico

Aplicar los conceptos fundamentales de Programación Orientada a Objetos (POO):

- Encapsulamiento
- Clases y objetos
- Constructores
- Métodos accesadores (getters) y mutadores (setters)
- Estructura básica de proyectos en Java
- Uso del entorno Apache NetBeans

---

## 🧩 Estructura del proyecto

El proyecto está compuesto por:

- `Cuenta.java`: clase que representa una cuenta bancaria con número y saldo.
- `Cliente.java`: clase que representa un cliente con datos personales y una cuenta asociada.
- `Main.java`: contiene la lógica del menú interactivo de consola para registrar clientes y realizar operaciones.
  
---

## ✅ Funcionalidades actuales

- Registrar cliente (máx. una cuenta por cliente)
- Validación de RUT chileno (formato y dígito verificador)
- Validación de número de cuenta único
- Menú interactivo con control de errores e intentos
- Operaciones de:
  - Depósito
  - Giro
  - Consulta de saldo
  - Visualización de datos
- Confirmación antes de modificar datos (mostrando nombre del cliente)

---

## 🔧 Sugerencias de mejoras futuras

Estas ideas pueden ser desarrolladas en las próximas entregas incrementales del proyecto:

. **Control de errores más robusto**
- Validar que el número de cuenta tenga exactamente 9 dígitos.
- Validar formato de teléfono y dirección.

 **Modularización**
- Separar la lógica del menú en una clase independiente para mayor claridad.

---

## 📚 Créditos

Desarrollado como parte de la actividad **Exp1_S1 — Semana 1**  
Asignatura: *Desarrollo Orientado a Objetos I*  
Institución: **[Duoc] Escuela de Administración y Negocios**
