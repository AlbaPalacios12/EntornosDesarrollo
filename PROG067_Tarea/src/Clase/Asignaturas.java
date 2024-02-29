/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import static Clase.Asignaturas.values;

/**
 *
 * @author 34625
 */
public enum Asignaturas {
    //lista de objetos, solo se podrian introducir mas desde esta misma lista. No de ninguna otra forma
    BD("Bases de datos", "BD", 4),
    ED("Entornos de desarrollo", "ED", 3),
    FOL("Formación y orientación laboral", "FOL", 2),
    ING("Inglés técnico", "ING", 3),
    LMSGI("Lenguajes de marcas", "LMSGI", 3),
    PROG("Programación", "PROG", 5),
    SI("Sistemas informáticos", "SI", 4);
 
    //declaracion de atributos
    private final String descripcion;
    private final String codigo;
    private final int creditos;
 
    private Asignaturas(String descripcion, String codigo, int creditos) { //constructor privado para que no se puedan crear nuevos objetos
        this.descripcion = descripcion;
        this.codigo = codigo; //este es el paramentro que se mete ene el primer metodo
        this.creditos = creditos;
    }
 
    //getter de los atributos
    public String getDescripcion()
{
        return descripcion;
    }
 
    public String getCodigo() {
        return codigo;
    }
 
    public int getCreditos() {
        return creditos;
    }
 
    //obtenemos la descripcion de la asignatura a partir de el 2 elemento que es el codigo de la misma.
    public static String obtenerDescripcionAsignatura(String codigo) {
        //de la clase Asignaturas cada objeto será asignatura y values coge los valores de ese objeto
        for (Asignaturas asignatura : values()) {
            //si el codigo de la asignatura que estoy mirando en esa vuelta es igual al codigo que le he pasado, entonces entra.
            if (asignatura.getCodigo().equals(codigo)) {
                //entonces si se cuemple el if, devuelve la descripcion asociada a ese codigo que estoy mirando en esa vuelta
                return asignatura.getDescripcion();
            }
        }
        //si hace el for entero y no encuentra el codigo me devuelve el return
        return "Código no encontrado";
    }

    // Método para obtener el código a partir de la posición en la clase
    public static String obtenerCodigoPorPosicion(int posicion) {
        //como condicion se pone que el numero de la posicion tiene que ser mayor o igual a cero pero no superar la longitud del nº de objetos de la lista
        if (posicion >= 0 && posicion < values().length) {
            //entonces si es un numero dentro del rango coge ese valor, lo mira en la lista y me devuelve el codigo asociado a ese valor.
            return values()[posicion].getCodigo();
        } else {
            //sino me devuelve nulo
            return null;
        }
    }
}

