/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validaciones;

/**
 *
 * @author 34625
 */
public class Validaciones {

    private static final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";

    public static boolean validarNIF(String nif) {
        
        //lo primero que hacemos es comprobar si contiene el numero de caracteres adecuados
        if (nif.length() != 9) {
            return false;
        }
//dividimos en 2, contando con que los 8 primeros caracteres seran numeros y los guardamos en la variable numero
        String numero = nif.substring(0, 8);
        //y en la variable letra vamos a guardar el caracter 9 que se corresponde con la letra
        char letra = Character.toUpperCase(nif.charAt(8));

        try {
            //convertimos la cadena en un numero entero y lo guardamos en num
            //en caso de que no sea un numero lazará una excepción
            int num = Integer.parseInt(numero);
            //ME QUEDO POR AQUI
            char letraCalculada = LETRAS.charAt(num % 23);
            return letra == letraCalculada;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //revisar y dar una vuelta
    public static boolean validarNIE(String nie) {
        if (nie.length() != 9) {
            return false;
        }

        char inicial = Character.toUpperCase(nie.charAt(0));
        String numero = nie.substring(1, 8);
        char letra = Character.toUpperCase(nie.charAt(8));

        try {
            int num = Integer.parseInt(numero);
            switch (inicial) {
                case 'X': num += 0; break;
                case 'Y': num += 10000000; break;
                case 'Z': num += 20000000; break;
                default: return false;
            }
            char letraCalculada = LETRAS.charAt(num % 23);
            return letra == letraCalculada;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean validarCorreo(String correo) {
        // Expresión regular para validar el formato de correo electrónico
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return correo.matches(regex);
    }
}
    
    
    

