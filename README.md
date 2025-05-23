# Proyecto Java: Simulador de Gestión Bancaria — BankBoston

Este proyecto simula un sistema básico de gestión de cuentas bancarias para la institución ficticia **BankBoston**, como parte de la actividad *Exp1_S1* de la asignatura **Desarrollo Orientado a Objetos I** del primer año de la carrera de Analista Programador.

Opciones del Menú
Al ejecutar el programa, se despliega el siguiente menú:

Registrar cliente
Permite ingresar los datos de un nuevo cliente, incluyendo nombre, RUT y creación de una cuenta bancaria. El sistema valida que el RUT ingresado tenga el formato correcto y sea válido según el dígito verificador.

Ver datos de cliente
Solicita el número de cuenta y muestra los datos del cliente asociado, si existe.

Depositar
Permite ingresar un monto a depositar en la cuenta de un cliente, identificado por su número de cuenta. El sistema valida que el monto sea positivo y que la cuenta exista.

Girar
Permite retirar dinero de la cuenta de un cliente. Se verifica que la cuenta exista, que el monto sea positivo y que haya suficiente saldo disponible.

Consultar saldo
Muestra el saldo actual de una cuenta especificada por su número.

Salir
Termina la ejecución del programa.

Validaciones Implementadas
1. Validación de RUT Chileno
Se implementa una función para verificar si el RUT ingresado es válido, considerando:

Formato correcto (con puntos como separadores de miles y guión antes del dígito verificador).

Cálculo correcto del dígito verificador mediante el algoritmo estándar.

Ejemplo válido: 12.345.678-5

2. Validación del número de cuenta
Al ingresar el número de cuenta, se busca en la lista de clientes para verificar que exista. Si no se encuentra, se notifica al usuario.

3. Validación de entradas del menú
Se valida que:

El usuario ingrese un número del 1 al 6.

Si se ingresa texto o números fuera de rango, se cuenta como intento fallido.

El programa permite solo dos intentos inválidos antes de finalizar.

4. Validación de montos
Para depósitos y giros:

Se exige que el monto sea mayor que cero.

En giros, se valida que el saldo disponible sea suficiente.

## 📚 Créditos

Desarrollado como parte de la actividad **Exp1_S1 — Semana 1**  
Asignatura: *Desarrollo Orientado a Objetos I*  
Institución: **[Duoc] Escuela de Administración y Negocios**
