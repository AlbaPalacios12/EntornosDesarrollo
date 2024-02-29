package Clase;

import static Validaciones.Validaciones.validarCorreo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Curso {

    // Constantes
    private static final int MAX_ALUMNOS = 100;
    private static final int NUM_ASIGNATURAS = 7;
    private static final String NOMBRE_CURSO = "DAM  1 E-Learning";

    // Atributos
    private Date fechaInicio;
    private Date fechaFin;
    private Estudiante[] alumnos;
    private Profesor[] profesores;
    private int[][] notas; // Matriz para guardar las notas
    private int numAlumnosMatriculados = 0;

    // Constructor
    public Curso(Date fechaInicio, Date fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        // Inicializamos los arrays
        this.alumnos = new Estudiante[MAX_ALUMNOS];
        this.profesores = new Profesor[NUM_ASIGNATURAS];
        // Inicializamos la matriz de notas
        this.notas = new int[MAX_ALUMNOS][NUM_ASIGNATURAS];
    }

    public Curso() {

    }

    private boolean cursoCreado = false;

    // PUNTO 1 MENU --> CREAR CURSO
    public boolean crearCurso() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat formatear = new SimpleDateFormat("dd-MM-yyyy");

        System.out.println("Introduzca la fecha de inicio del curso (dd-MM-yyyy): ");
        String fechaIn = sc.nextLine();
        System.out.println("Introduzca la fecha de finalización del curso (dd-MM-yyyy): ");
        String fechaFi = sc.nextLine();

        try {
            this.fechaInicio = formatear.parse(fechaIn);
            this.fechaFin = formatear.parse(fechaFi);

            if (this.fechaInicio.before(this.fechaFin)) {
                System.out.println("Curso creado correctamente");
                return true;
            } else {
                System.out.println("La fecha de inicio debe ser anterior a la fecha de fin");
                return false;
            }
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Por favor, intente de nuevo");
            return false;
        }

    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    // PUNTO 2 MENU --> NUEVO PROFESOR
    public void nuevoProfesor() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat formatear = new SimpleDateFormat("dd-MM-yyyy");
        String identificador, nombreCompleto, fechaAlta, correo, asignatura;

        System.out.println("Introduce el documento identificador (X para cancelar): ");
        identificador = sc.nextLine();

        while (!identificador.equalsIgnoreCase("x")) {
            try {
                Profesor.validarIdentificador(identificador);
                System.out.println("Introduce el nombre del profesor: ");
                nombreCompleto = sc.nextLine();
                if (esNombreCompleto(nombreCompleto)) {
                    System.out.println("Introduce la fecha de alta (dd-MM-yyyy): ");
                    fechaAlta = sc.nextLine();
                    Date fechaAltaDate = formatear.parse(fechaAlta);
                    if (esFechaAlta(fechaAltaDate)) {
                        System.out.println("Introduce el correo electrónico: ");
                        correo = sc.nextLine();
                        if (validarCorreo(correo)) {
                            System.out.println("Introduce la clave de la asignatura: ");
                            asignatura = sc.nextLine();
                            if (esAsignaturaValida(asignatura)) {
                                System.out.println("Profesor añadido correctamente.");
                            } else {
                                System.out.println("Clave de asignatura no válida.");
                            }
                        } else {
                            System.out.println("Correo electrónico no válido.");
                        }
                    } else {
                        System.out.println("La fecha de alta debe ser anterior a la fecha de comienzo del curso.");
                    }
                } else {
                    System.out.println("El nombre debe tener entre  1 y  40 caracteres.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Identificador no válido. Por favor, intente de nuevo.");
            } catch (ParseException e) {
                System.out.println("Formato de fecha inválido. Por favor, intente de nuevo.");
            }
            System.out.println("Introduce el documento identificador (X para cancelar): ");
            identificador = sc.nextLine();
        }
    }

    public boolean esNombreCompleto(String nombre) {
        return nombre.length() > 0 && nombre.length() <= 40;
    }

    private boolean esFechaAlta(Date fechaAlta) {
        return !fechaAlta.before(fechaInicio) && !fechaAlta.after(fechaFin);
    }

    //PUNTO 3 MENU --> NUEVO ESTUDIANTE
    public void nuevoEstudiante() {
        Scanner sc = new Scanner(System.in);
        String identificador, nombreCompleto, fechaMatriculacion, nifNie, correo;
        Date fechaMatriculacionDate;
        SimpleDateFormat formatear = new SimpleDateFormat("dd-MM-yyyy");

        System.out.println("Introduce el identificador del estudiante (x para cancelar): ");
        identificador = sc.nextLine();

        while (!identificador.equalsIgnoreCase("x")) {
            try {
                Estudiante.validarIdentificador(identificador);
                System.out.println("Introduce el nombre del estudiante: ");
                nombreCompleto = sc.nextLine();
                if (esNombreCompleto(nombreCompleto)) {
                    System.out.println("Introduce la fecha de matriculación (dd-MM-yyyy): ");
                    fechaMatriculacion = sc.nextLine();
                    try {
                        fechaMatriculacionDate = formatear.parse(fechaMatriculacion);
                        if (Estudiante.esFechaMatriculacionValida(fechaMatriculacionDate)) {
                            System.out.println("Introduce el NIF/NIE: ");
                            nifNie = sc.nextLine();
                            if (comprobarDocumento(documento)) {
                                System.out.println("Introduce el correo electrónico: ");
                                correo = sc.nextLine();
                                if (validarCorreo(correo)) {
                                    Estudiante nuevoEstudiante = new Estudiante(identificador, nombreCompleto, correo, fechaMatriculacionDate, nifNie);

                                    System.out.println("Estudiante añadido correctamente.");
                                    System.out.println("Estudiante añadido correctamente.");
                                    // Aquí puedes implementar la lógica para pedir las notas
                                    // Por ejemplo:
                                    // pedirNotas(estudiante);
                                } else {
                                    System.out.println("Correo electrónico no válido.");
                                }
                            } else {
                                System.out.println("NIF/NIE no válido.");
                            }
                        } else {
                            System.out.println("Fecha de matriculación no válida o fuera del rango del curso.");
                        }
                    } catch (ParseException e) {
                        System.out.println("Formato de fecha inválido. Por favor, intente de nuevo.");
                    }
                } else {
                    System.out.println("Nombre completo no válido.");

                }
            } catch (IllegalArgumentException e) {
                System.out.println("Identificador no válido. Por favor, intente de nuevo.");
            }

            System.out.println("Introduce el identificador del estudiante (x para cancelar): ");
            identificador = sc.nextLine();
        }
    }

    //PUNTO 4 MENU --> ACTUALIZAR NOTA
    public void actualizarNota() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID del alumno");
        String idAlumno = sc.nextLine();
        System.out.println("Introduce el ID de la asignatura");
        String idAsignatura = sc.nextLine();
        System.out.println("Introduce la nueva nota");
        int nuevaNota = sc.nextInt();

        //comprobar que el alumno existe
        int indiceAlumno = -1;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].getIdentificador().equals(idAlumno)) {
                indiceAlumno = i;
                break;
            }
        }

        //ahora hay que comprobar que la asignatura existe
        int indiceAsignatura = -1;
        for (int i = 0; i < profesores.length; i++) {
            if (profesores[i] != null && profesores[i].getAsignatura().equals(idAsignatura)) {
                indiceAsignatura = i;
                break;
            }
        }

        //una vez comprobado que existen, se actualiza la nota
        if (indiceAlumno != -1 && indiceAsignatura != -1) {
            notas[indiceAlumno][indiceAsignatura] = nuevaNota;
            System.out.println("La nota ha sido actualizada");
        } else {
            System.out.println("El alumno o la asignatura no existen");
        }

    }

    //PUNTO 5 MENU -->INFORME DE LA ASIGNATURA
    public void informeAsignatura() {
        Scanner sc = new Scanner(System.in);
        //pedimos por teclado el ID del profesor
        System.out.println("Introduce el ID del profesor");
        String idProfesor = sc.nextLine();
        //comprobamos que este existe
        Profesor profesorEncontrado = null;
        for (Profesor profesor : profesores) {
            if (profesor != null && profesor.getIdentificador().equals(idProfesor)) {
                profesorEncontrado = profesor;
                break;
            }
        }
        if (profesorEncontrado == null) {
            System.out.println("El profesor no ha sido encontrado");
            return;
        }
        Asignaturas asignatura = profesorEncontrado.getAsignatura();

        // Mostrar la información del profesor y la asignatura
        System.out.println("ID y nombre del profesor: " + profesorEncontrado.getId() + ", " + profesorEncontrado.getNombre());
        System.out.println("ID y nombre de la asignatura: " + asignatura.getId() + ", " + asignatura.getNombre());

        // Asumiendo que tienes métodos para obtener las estadísticas de los alumnos y las notas
        int numAprobados = profesorEncontrado.getNumAprobados();
        int numSuspensos = profesorEncontrado.getNumSuspensos();
        double porcentajeAprobados = (double) numAprobados / (numAprobados + numSuspensos) * 100;
        double porcentajeSuspensos = (double) numSuspensos / (numAprobados + numSuspensos) * 100;
        double notaMedia = profesorEncontrado.getNotaMedia();
        double notaMinima = profesorEncontrado.getNotaMinima();
        double notaMaxima = profesorEncontrado.getNotaMaxima();

        System.out.printf("Nº de alumnos aprobados: %d, %%.2f%% del total%n", numAprobados, porcentajeAprobados);
        System.out.printf("Nº de alumnos suspensos: %d, %%.2f%% del total%n", numSuspensos, porcentajeSuspensos);
        System.out.printf("Nota media de la asignatura: %%.2f, Nota mínima: %%.2f, Nota máxima: %%.2f%n", notaMedia, notaMinima, notaMaxima);
    }

    private boolean esAsignaturaValida(String claveAsignatura) {
        String descripcionAsignatura = Asignaturas.obtenerDescripcionAsignatura(claveAsignatura);
        if (!descripcionAsignatura.equals("Código no encontrado")) {
            System.out.println("Asignatura válida.");
            return true;

        } else {
            System.out.println("Código de asignatura no válido.");
            return false;
        }
    }

    //PUNTO 6 MENU --> OBTENER INFORME ALUMNO
    public void informeAlumno() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID del alumno: ");
        String idAlumno = sc.nextLine();

        Estudiante estudiante = buscarEstudiantePorId(idAlumno);
        if (estudiante != null) {
            double notaMedia = calcularNotaMedia(estudiante);
            System.out.println("La nota media del alumno es: " + notaMedia);
        } else {
            System.out.println("El alumno no se encontró.");
        }
    }

    public void informeAlumno(String idAlumno) {
        // Buscar al estudiante por ID
        Estudiante estudiante = buscarEstudiantePorId(idAlumno);
        if (estudiante == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        // Imprimir detalles del estudiante
        System.out.println("Nombre del estudiante: " + estudiante.getNombre());
        System.out.println("ID del estudiante: " + estudiante.getId());

        // Imprimir las asignaturas y notas
        System.out.println("Asignaturas y notas:");
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] != 0) { // Asegurarse de que la nota no sea  0 (asumiendo  0 como valor no asignado)
                    System.out.println("Asignatura: " + Asignaturas.obtenerCodigoPorPosicion(j) + ", Nota: " + notas[i][j]);
                }
            }
        }

        // Calcular y mostrar si el estudiante ha aprobado o suspendido
        double notaMedia = calcularNotaMedia(idAlumno);
        System.out.println("Nota media: " + notaMedia);
        if (notaMedia >= 5) {
            System.out.println("El estudiante ha aprobado.");
        } else {
            System.out.println("El estudiante ha suspendido.");
        }
    }

    public double calcularNotaMedia(Estudiante estudiante) {
        int sumaNotas = 0;
        int numeroNotas = estudiante.getNotas().length; // Asume que getNotas() devuelve un array de notas

        for (int nota : estudiante.getNotas()) {
            sumaNotas += nota;
        }

        return (double) sumaNotas / numeroNotas;
    }

    //PUNTO 7 MENU --> OBTENER INFORME GENERAL
    public void informeGeneralCurso() {
        int totalEstudiantes = 0;
        int totalAprobados = 0;
        int totalSuspensos = 0;

        // Calcular estadísticas generales
        for (Estudiante estudiante : alumnos) {
            if (estudiante != null) {
                totalEstudiantes++;
                double notaMedia = calcularNotaMedia(estudiante.getId());
                if (notaMedia >= 5) {
                    totalAprobados++;
                } else {
                    totalSuspensos++;
                }
            }
        }

        // Imprimir estadísticas del curso
        System.out.println("Total de estudiantes: " + totalEstudiantes);
        System.out.println("Total aprobados: " + totalAprobados);
        System.out.println("Total suspensos: " + totalSuspensos);

        // Calcular y mostrar el promedio de notas por asignatura
        System.out.println("Promedios de notas por asignatura:");
        for (int i = 0; i < notas[0].length; i++) {
            double sumaNotas = 0;
            int contadorNotas = 0;
            for (int j = 0; j < notas.length; j++) {
                if (notas[j][i] != 0) { // Asegurarse de que la nota no sea  0 (asumiendo  0 como valor no asignado)
                    sumaNotas += notas[j][i];
                    contadorNotas++;
                }
            }
            double promedioAsignatura = sumaNotas / contadorNotas;
            System.out.println("Asignatura: " + Asignaturas.obtenerCodigoPorPosicion(i) + ", Promedio: " + promedioAsignatura);
        }
    }

}
