// Este programa crea una cuenta bancaria con un saldo inicial y realiza operaciones de ingreso y retiro.
// Utiliza la clase CCuenta, que tiene los atributos nombre, cuenta, saldo y tipo de interés.
// También tiene los métodos estado, ingresar y retirar, que devuelven o modifican el saldo de la cuenta.

package Cuentas;

public class Main {

    public static void main(String[] args) {
        CCuenta cuenta1;
        double saldoActual;//cambio

        operativa_cuenta();
    }

    private static void operativa_cuenta() {
        float cantidad = 0;
        operativa_cuenta(cantidad);
    }

    private static void operativa_cuenta(float cantidad) {
        CCuenta cuenta1;
        double saldoActual;
        cuenta1 = new CCuenta("Antonio López","1000-2365-85-1230456789",2500,0);
        
        //ahora obtenemos el saldo de la cuenta y lo imprimimos por pantalla
        saldoActual = cuenta1.estado();
        System.out.println("El saldo actual es"+ saldoActual );
        try {
            cuenta1.retirar(2300);
            //con el metodo retirar, queremos bajar 2300 euros de la cuenta
        } catch (Exception e) {
            System.out.print("Fallo al retirar");
            //mensaje en caso de fallar
        }
        try {
            System.out.println("Ingreso en cuenta");
            cuenta1.ingresar(695);
            //Se procede a ingresar 695 euros en la cuenta
        } catch (Exception e) {
            System.out.print("Fallo al ingresar");
            // en caso de que falle
        }
    }
}
//luego el resultado de la ejecución del programa es el siguiente:...
// El saldo actual es2500.0
// Ingreso en cuenta
// Si no se produce ninguna excepción, el saldo final de la cuenta será de 895 euros.
// Si se produce una excepción al retirar, el saldo final de la cuenta será de 3195 euros.
// Si se produce una excepción al ingresar, el saldo final de la cuenta será de 200 euros.
