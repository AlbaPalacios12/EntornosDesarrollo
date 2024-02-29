/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import java.util.Date;

public class Estudiante extends Persona implements GestionAcademica{
    private String identificador;
    private Date fechaMatriculacion;  
    private Curso curso;
    
    //getters y setters

    public String getIdentificador() {
        return identificador;
    }

    public Date getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setIdentificador(String identificador) {
        this.identificador = validarIdentificador(identificador);
    }

    public void setFechaMatriculacion(Date fechaMatriculacion) {
        if (esFechaMatriculacionValida(fechaMatriculacion)){
            this.fechaMatriculacion = fechaMatriculacion;
        } else {
            throw new IllegalArgumentException("La fecha de matriculación no es correcta");
        }
    }
    
    //constructor
    public Estudiante() {
    }
    
    public Estudiante(String DNI, String nombreCompleto, String correo, Date fechaMatriculacion, String identificador, Curso curso) {
        super(DNI, nombreCompleto, correo); //llama al constructor de la clase Persona
        this.identificador = validarIdentificador(identificador);
        this.curso = curso;
        if (esFechaMatriculacionValida(fechaMatriculacion)){
            this.fechaMatriculacion = fechaMatriculacion;
        } else {
            throw new IllegalArgumentException("La fecha de matriculación no es correcta");
        }
    }
    
    //metodo para validar la fecha de matriculacion
    public boolean esFechaMatriculacionValida(Date fechaMatriculacion) {
        return !fechaMatriculacion.before(curso.getFechaInicio()) && !fechaMatriculacion.after(curso.getFechaFin());
    }
    
   
    //metodo para validar el identificador
    public String validarIdentificador (String identificador){
        String regex = "^NIES\\d{6}[ABCRCTGUESXX]$";
        if (identificador.matches(regex)){
            return identificador;
        }else{
            throw new IllegalArgumentException("Identificador no valido");
        }
    }
    
    @Override
    public String informeResultados() {
        // Implementación específica para Estudiante
    return "Nombre: " + getNombreCompleto() + ", DNI: " + getDNI() + ", Correo electrónico: " + getCorreo();
    }
}