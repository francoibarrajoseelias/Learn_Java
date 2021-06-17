package avion;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ProyectoAeropuerto {

    public static void main(String[] args) {

        final int MAX_AEROPUERTOS = 20;

        final int TIPO_PUBLICO = 1;
        final int TIPO_PRIVADO = 2;

        final int AVION_ACTIVO = 1;
        final int AVION_NO_ACTIVO = 2;

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        sc.useLocale(Locale.US);

        boolean salir = false;
        int numeroAeropuertos = 0;

        Aeropuerto aeropuertos[] = new Aeropuerto[MAX_AEROPUERTOS];

        int opcion, numero, anioInaguracion, capacidad, eleccionTipo, eleccionActivo, numeroTrabajadores, numeroSocios, numAsientos, idAeropuerto;
        String nombre, pais, calle;

        double financiacion, velMaxima, ganancia;

        Aeropuerto aeropuertoAux;
        Direccion direccion;
        Avion avionAux;

        while (!salir) {
            System.out.println("1.- Anadir aeropuerto");
            System.out.println("2.- Anadir Avion");
            System.out.println("3.- Mostrar datos del Aeropuerto");
            System.out.println("4.- Mostrar años q lleva el aeropuerto ");
            System.out.println("5.- Mostrar ganancias del aeropuerto ");
            System.out.println("6.- Salir");

            //opcion = sc.nextInt();
            try {

                System.out.println("Introduce unas de las opciones");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:

                        if (numeroAeropuertos > MAX_AEROPUERTOS) {
                            System.out.println("NO se puede ingresar mas Aeropuertos");
                        } else {

                            System.out.println("Escribe el nombre del aeropuerto");
                            nombre = sc.next();

                            System.out.println("Escribe el pais del aeropuerto");
                            pais = sc.next();

                            System.out.println("Escribe el calle del aeropuerto");
                            calle = sc.next();

                            System.out.println("Escribe el numero del aeropuerto");
                            numero = validarNumero(0, Integer.MAX_VALUE);
                            /* En nuestra direccion no tiene este atributo
                            System.out.println("Escribe el nombre de la ciudad");
                            ciudad = sc.next();
                             */
                            System.out.println("Escribe el año de inauguracion del aeropuerto");
                            anioInaguracion = validarNumero(0, Integer.MAX_VALUE);

                            System.out.println("Escribe la capacidad del aeropuerto");
                            capacidad = validarNumero(0, Integer.MAX_VALUE);

                            System.out.println("¿Aeropuerto publico o privado? (1=publico, 2=privado)");
                            eleccionTipo = validarNumero(1, 2);

                            direccion = new Direccion(pais, calle, numero);

                            if (eleccionTipo == TIPO_PUBLICO) {
                                System.out.println("Escribe la cantidad de financiacion dado al del aeropuerto");
                                financiacion = sc.nextDouble();

                                System.out.println("Escribe el numero de trabajadores del aeropuerto");
                                numeroTrabajadores = validarNumero(0, Integer.MAX_VALUE);

                                aeropuertoAux = new AeropuertoPublico(financiacion, numeroTrabajadores, nombre, direccion, capacidad, anioInaguracion);

                            } else {
                                System.out.println("Escribe el numero de socios del aeropuerto");
                                numeroSocios = validarNumero(0, Integer.MAX_VALUE);

                                aeropuertoAux = new AeropuertoPrivado(numeroSocios, nombre, direccion, capacidad, anioInaguracion);
                            }

                            aeropuertos[numeroAeropuertos] = aeropuertoAux;
                            numeroAeropuertos++;

                            System.out.println("Tu aeropuerto es: " + aeropuertoAux);
                        }

                        break;
                    case 2:

                        if (numeroAeropuertos == 0) {
                            System.out.println("No hay aeropuertos debes añadir alguno");
                        } else {
                            System.out.println("Escribe el nombre del avion");
                            nombre = sc.next();

                            System.out.println("Escribe el numero de asientos del avion");
                            numAsientos = validarNumero(1, Integer.MAX_VALUE);

                            System.out.println("Escribe la velocidad maxima del avion");
                            velMaxima = sc.nextDouble();

                            System.out.println("¿El avione esta activo? (1=activo, 2=no activo)");
                            eleccionActivo = validarNumero(1, 2);

                            avionAux = new Avion(nombre, numAsientos, velMaxima);

                            if (eleccionActivo == AVION_ACTIVO) {
                                avionAux.setActivado(true);
                            }

                            System.out.println("Elige un aeropuerto");
                            mostrarAeropuertos(aeropuertos, numeroAeropuertos);

                            System.out.println("Ingrese el id del aeropuerto al q desea ingresar el avion");
                            idAeropuerto = sc.nextInt();

                            aeropuertoAux = seleccionarAeropuerto(aeropuertos, numeroAeropuertos, idAeropuerto);
                            if (aeropuertoAux != null) {
                                aeropuertoAux.aniadirAviones(avionAux);
                            } else {
                                System.out.println("No existe el aeropuerto. El avion es desechado|");
                            }

                        }

                        break;
                    case 3:

                        System.out.println("Elige un aeropuerto");
                        mostrarAeropuertos(aeropuertos, numeroAeropuertos);

                        System.out.println("Ingrese el id del aeropuerto al q desea ingresar el avion");
                        idAeropuerto = sc.nextInt();

                        aeropuertoAux = seleccionarAeropuerto(aeropuertos, numeroAeropuertos, idAeropuerto);
                        if (aeropuertoAux != null) {
                            System.out.println(aeropuertoAux);
                        } else {
                            System.out.println("No existe el aeropuerto ");
                        }

                        break;
                    case 4:

                        System.out.println("Elige un aeropuerto");
                        mostrarAeropuertos(aeropuertos, numeroAeropuertos);

                        System.out.println("Ingrese el id del aeropuerto al q desea ingresar el avion");
                        idAeropuerto = sc.nextInt();

                        aeropuertoAux = seleccionarAeropuerto(aeropuertos, numeroAeropuertos, idAeropuerto);
                        if (aeropuertoAux != null) {
                            System.out.println("Los años q lleva activo son: " + aeropuertoAux.anioDeServicio());
                        } else {
                            System.out.println("No existe el aeropuerto.");
                        }

                        break;
                    case 5:

                        System.out.println("Elige un aeropuerto");
                        mostrarAeropuertos(aeropuertos, numeroAeropuertos);

                        System.out.println("Ingrese el id del aeropuerto al q desea ingresar el avion");
                        idAeropuerto = sc.nextInt();

                        aeropuertoAux = seleccionarAeropuerto(aeropuertos, numeroAeropuertos, idAeropuerto);
                        if (aeropuertoAux != null) {
                            System.out.println("Introduzca la ganancia");
                            ganancia = sc.nextDouble();
                            aeropuertoAux.ganancias(ganancia);
                        } else {
                            System.out.println("No existe el aeropuerto. El avion es desechado|");
                        }

                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numero entre 1 y 7");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                sc.next();
            }
        }
    }

    public static int validarNumero(int minimo, int maximo) {
        Scanner sc = new Scanner(System.in);

        if (minimo > maximo) {
            int aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        int numero;
        do {

            System.out.println("Escribe un numero");
            numero = sc.nextInt();

            if (!(numero >= minimo && numero <= maximo)) {
                System.out.println("Debes escribir un numero entre " + minimo + " y " + maximo);
            }

        } while (!(numero >= minimo && numero <= maximo));

        return numero;
    }

    public static void mostrarAeropuertos(Aeropuerto[] aeropuertos, int numeroAeropuertos) {
        for (int i = 0; i < numeroAeropuertos; i++) {

            // El "instanceof" nos sirve para saber si aeropuerto[i] en la posicion "i" es una instancia de aeropuertoPrivado o aeropuertoPublico
            if (aeropuertos[i] instanceof AeropuertoPrivado) {
                System.out.println("ID :" + aeropuertos[i].getId() + " nombre: " + aeropuertos[i].getNombre() + "(privado)");

            } else {
                System.out.println("ID :" + aeropuertos[i].getId() + " nombre: " + aeropuertos[i].getNombre() + "(publico)");

            }

        }
    }

    public static Aeropuerto seleccionarAeropuerto(Aeropuerto[] aeropuertos, int numeroAeropuertos, int idAeropuerto) {
        for (int i = 0; i < numeroAeropuertos; i++) {
            if (aeropuertos[i].getId() == idAeropuerto) {
                return aeropuertos[i];
            }
        }
        return null;
    }

}
