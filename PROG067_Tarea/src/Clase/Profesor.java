/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import java.util.Date;

public class Profesor extends Persona implements GestionAcademica {
   private String identificador;
   private Date fechaAlta;
   private Asignaturas asignatura; // que viene de la clase Asignatura

   //constructor 
    public Profesor() {
    }
    
    public Profesor(String identificador, Date fechaAlta, Asignaturas asignatura, String DNI, String nombreCompleto, String correo) {
        super(DNI, nombreCompleto, correo);
        this.identificador = validarIdentificador(identificador);
        this.fechaAlta = fechaAlta;
        this.asignatura = asignatura;
    }

    
   //getters y setters

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Asignaturas getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignaturas asignatura) {
        this.asignatura = asignatura;
    }
    
  //creamos el metodo para validar el identificador
    
   public static String validarIdentificador(String identificador){
       String regex = "^(590|591|592)\\d{5}(INF|ING|FOL|SIA)$";
       if (identificador.matches(regex)) {
           return identificador;
       }else {
           throw new IllegalArgumentException("Identificador no valido");
       }
   }
    @Override
    public String informeResultados() {
        // Implementación específica para Profesor
       return null;
        // Implementación específica para Profesor
    }
}