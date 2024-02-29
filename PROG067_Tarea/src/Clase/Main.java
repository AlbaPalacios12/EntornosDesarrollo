package Clase;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //creamos un objeto de la clase Curso
        Curso curso = new Curso();
        Scanner scanner = new Scanner(System.in);
        //boleean para comprobar si el curso esta o no creado
        boolean cursoCreado = false;
        int opcion;
        do {
            mostrarMenu(); //hacemos una llamada al menu en vez de ponerlo aqui para que el Main se quede mas corto
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    cursoCreado = curso.crearCurso();
                    break;
                case 2:
                    if(cursoCreado == true) {
                        curso.nuevoEstudiante();
                    } else {
                        System.out.println("Es necesario que cree un curso");
                    }
                    break;                    
                case 3:
                    if (cursoCreado == true) {
                        curso.nuevoProfesor();
                    } else {
                        System.out.println("Es necesario que cree un curso");
                    }
                case 4:
                    if (cursoCreado == true) {
                        curso.actualizarNota();
                    } else {
                        System.out.println("Es necesario que cree un curso");
                    }
                    break;
                case 5:
                    if (cursoCreado == true) {
                        curso.informeAsignatura();
                    } else {
                        System.out.println("Es necesario que cree un curso");
                    }
                    break;
                case 6:
                    if (cursoCreado == true) {
                        curso.informeAlumno();
                    } else {
                        System.out.println("Es necesario que cree un curso");
                    }
                    break;
                case 7:
                    if (cursoCreado == true) {
                        curso.informeGeneralCurso();
                    } else {
                        System.out.println("Es necesario que cree un curso");
                    }
                    break;
                case 8:
                    System.out.println("Saliendo del programa");
                    System.exit(0);
                default:
                    System.out.println("El numero introducido no es valido dentro del menu");

            }
        } while (opcion != 8);

    }

    private static void mostrarMenu() {
        System.out.println("MENU");
        System.out.println("1. Crear curso");
        System.out.println("2. Nuevo estudiante");
        System.out.println("3. Nuevo profesor");
        System.out.println("4. Actualizar nota");
        System.out.println("5. Obtener informe de profesor");
        System.out.println("6. Obtener informe de estudiante");
        System.out.println("7. Obtener informe general");
        System.out.println("8. Salir");
        System.out.print("Selecciona una opcion:  ");
    }
}


