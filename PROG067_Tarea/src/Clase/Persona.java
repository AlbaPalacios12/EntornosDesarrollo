/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import Validaciones.Validaciones;

public class Persona {

    //declaramos los atributos de la clase
    private String DNI;
    private String nombreCompleto;
    private String correo;

    //constructor
    public Persona(String DNI, String nombreCompleto, String correo) {
        if (comprobarDocumento(DNI)) {
            this.DNI = DNI;
        } else {
            throw new IllegalArgumentException("NIE/NIE no valido");
        }
        this.nombreCompleto = nombreCompleto;
        //validamos el correo dentro del constructor por si se crease el objeto desde cero
        if (Validaciones.validarCorreo(correo)) {
            this.correo = correo;
        } else {
            throw new IllegalArgumentException("Correo electrónico no válido");
        }
    }
    public Persona() {
    }

    //getter y setter
    public String getDNI() {
        return DNI;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setDNI(String DNI) {
        if (comprobarDocumento(DNI)) {
            this.DNI = DNI;
        } else {
            throw new IllegalArgumentException("NIE/NIE no valido");
        }
    }
    
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
//validamos el correo dentro del set por si se modificase un objeto ya creado

    public void setCorreo(String correo) {
        if (Validaciones.validarCorreo(correo)) {
            this.correo = correo;
        } else {
            throw new IllegalArgumentException("Correo electrónico no válido");
        }
    }

    //metodo para comprobar si es NIF o NIE y luego ya hacer la comprobacion correspondiente
    // desde el constructor 
    public final boolean comprobarDocumento(String documento) {
        switch (documento.charAt(0)) {
            case 'X':
            case 'Y':
            case 'Z':
                return Validaciones.validarNIE(documento);
            default:
                return Validaciones.validarNIF(documento);
        }
    }

}
//2º OPCION POSIBLE PARA COMPROBAR DOCUMENTO

//boolean documentoCorrecto = false; //inicializamos la variable
//if (documento.startsWith("X", 0) || documento.startsWith("Y", 0) || documento.startsWith("Z", 0)) {
//  documentoCorrecto = Validaciones.validarNIE(documento);
//} else {
//  documentoCorrecto = Validaciones.validarNIF(documento);
//}
//return documentoCorrecto; //resultado

