
import java.util.Scanner;

public class BatallaNaval {
    //Bloque de Declaraciones
    static String[][] tableroJugadorUno = new String[10][10];

    static int[][] posicionJugadorUno = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 3, 3, 3, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {3, 0, 1, 0, 0, 0, 0, 2, 2, 2},
            {3, 0, 1, 0, 4, 0, 0, 0, 0, 0},
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 2, 2, 2, 0, 0, 2, 0, 0},
            {0, 3, 3, 3, 0, 0, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 2, 0, 0}};

    static String[][] tableroJugadorDos = new String[10][10];
    static int[][] posicionJugadorDos = {
            {0, 0, 0, 0, 0, 2, 2, 2, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 4, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 3, 3, 3, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 3},
            {3, 0, 1, 0, 0, 0, 0, 0, 0, 3},
            {3, 0, 1, 0, 0, 0, 0, 2, 0, 3},
            {3, 0, 1, 0, 2, 0, 0, 2, 0, 0},
            {0, 0, 0, 0, 2, 0, 0, 2, 0, 0},
            {0, 0, 0, 0, 2, 0, 0, 0, 0, 0}};

    Scanner reader = new Scanner(System.in);
    static String portaAvion = "\u001B[31mP\u001B[37m";
    static String submarino = "\u001B[36mS\u001B[37m";
    static String destructor = "\u001B[35mD\u001B[37m";
    static String fragata = "\u001B[32mF\u001B[37m";
    static String mar = "\u001B[34m" + "*" + "\u001B[37m";//variable con color azul

    int fila = 0;
    int columna = 0;

    String disparos = "\u001B[38m-\u001B[37m";
    String barcosImpactados = "X";
    String nombreJugador1;
    String nombreJugador2;

    boolean finDelJuego = false;
    //Variables pa el manejo de errores
    String auxiliar;
    boolean esNumero = false;

    //Constructor
    public BatallaNaval() {

        System.out.println("\u001B[31mJugador 1: Ingrese su nombre\u001B[37m");
        nombreJugador1 = reader.nextLine();
        System.out.println("\u001B[33m«Bienvenido/a " + nombreJugador1 + ", te habla el capitán Jean Pierre Royaume-Uni, junto con el");
        System.out.println("resto de la tripulación formada por el gobierno británico, te encomendamos esta gran misión ");
        System.out.println("única para valientes como tú,  libera a nuestro país del enemigo");
        System.out.println("\u001B[33m                                                             - Éxitos\u001B[37m");
        System.out.println("\u001B[31mJugador 2: Ingrese su nombre\u001B[37m");
        nombreJugador2 = reader.nextLine();
        System.out.println("\u001B[33m«Bienvenido/a " + nombreJugador2 + ", te habla el capitán Charles Cox Versalles, junto con el");
        System.out.println("resto de la tripulación formada por el gobierno alemán, te encomendamos esta gran misión ");
        System.out.println("única para valientes como tú, libera a nuestro país del enemigo");
        System.out.println("\u001B[33m                                                             - Éxitos\u001B[37m");
        System.out.println("\u001B[35m░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\u001B[37m");
        System.out.println("       QUE COMIENCE LA BATALLA");
        System.out.println("\u001B[35m░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\u001B[37m");

        crearTablero(tableroJugadorUno, posicionJugadorUno);
        crearTablero(tableroJugadorDos, posicionJugadorDos);

        while (!finDelJuego) {
            realizarAtaques(nombreJugador1, tableroJugadorDos, tableroJugadorUno);
            analizarTablero(nombreJugador1, nombreJugador2, tableroJugadorDos);
            if (!finDelJuego) {
                realizarAtaques(nombreJugador2, tableroJugadorUno, tableroJugadorDos);
                analizarTablero(nombreJugador2, nombreJugador1, tableroJugadorUno);
                System.out.println("\u001B[32m▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\u001B[37m");
            }
        }
    }

    public void crearTablero(String[][] matrizDeAdquisicion, int[][] matrizDeAporte) {
        for (int i = 0; i < matrizDeAporte.length; i++) {
            for (int j = 0; j < matrizDeAporte[i].length; j++) {
                if (matrizDeAporte[i][j] == 1) {
                    matrizDeAdquisicion[i][j] = portaAvion;
                }
                if (matrizDeAporte[i][j] == 2) {
                    matrizDeAdquisicion[i][j] = submarino;
                }
                if (matrizDeAporte[i][j] == 3) {
                    matrizDeAdquisicion[i][j] = destructor;
                }
                if (matrizDeAporte[i][j] == 4) {
                    matrizDeAdquisicion[i][j] = fragata;
                }
                if (matrizDeAporte[i][j] == 0) {
                    matrizDeAdquisicion[i][j] = mar;
                }
            }
        }

    }


    public void mostrarTableros(String[][] tableroJugador, String[][] tableroEnemigo) {
        System.out.println("");
        System.out.println(" \u001B[32m▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\u001B[37m");

        System.out.print("   ");
        for (int tableroI = 1; tableroI < tableroJugador.length + 1; tableroI++) {
            System.out.print(tableroI + " ");
        }
        System.out.println("");
        for (int i = 0; i < tableroJugador.length; i++) {
            if (i + 1 < 10) {
                System.out.print(i + 1 + "  ");
            } else {
                System.out.print(i + 1 + " ");
            }
            for (int j = 0; j < tableroJugador[i].length; j++) {
                System.out.print(tableroJugador[i][j] + " ");
            }
            if (i == (tableroJugador.length / 2) - 1) {
                System.out.print("\u001B[32mESTE ES TU TABLERO\u001B[37m");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println(" \u001B[32m▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\u001B[37m");

        System.out.print("   ");
        for (int tableroJ = 1; tableroJ < tableroJugador.length + 1; tableroJ++) {
            System.out.print(tableroJ + " ");
        }
        System.out.println("");

        for (int i = 0; i < tableroJugador.length; i++) {
            if (i + 1 < 10) {
                System.out.print(i + 1 + "  ");
            } else {
                System.out.print(i + 1 + " ");
            }
            for (int j = 0; j < tableroJugador[i].length; j++) {
                if (tableroEnemigo[i][j].equals(portaAvion)) {
                    System.out.print(mar + " ");
                } else if (tableroEnemigo[i][j].equals(submarino)) {
                    System.out.print(mar + " ");
                } else if (tableroEnemigo[i][j].equals(destructor)) {
                    System.out.print(mar + " ");
                } else if (tableroEnemigo[i][j].equals(fragata)) {
                    System.out.print(mar + " ");
                } else {
                    System.out.print(tableroEnemigo[i][j] + " ");
                }
            }
            if (i == (tableroJugador.length / 2) - 1) {
                System.out.print("\u001B[32mTABLERO ENEMIGO\u001B[37m");
            }
            System.out.println("");
        }

    }

    public void realizarAtaques(String nombre, String[][] tableroAtacado, String[][] nombreTablero) {
        boolean impactos = false;
        while (!impactos) {

            mostrarTableros(nombreTablero, tableroAtacado);
            System.out.println("\u001B[35mTurno del jugador: \u001B[37m" + nombre);
            while (!esNumero) {
                System.out.println("Ingrese un número de fila (Entre 1 y " + tableroAtacado.length + " )");
                try {
                    auxiliar = reader.nextLine();
                    fila = Integer.parseInt(auxiliar) - 1;
                    if (fila < tableroAtacado.length && fila > -1) {
                        esNumero = true;
                    } else {
                        mostrarTableros(nombreTablero, tableroAtacado);
                        System.out.println("\u001B[35mTurno del jugador: \u001B[37m" + nombre);
                        System.out.println("EL número ingresado está fuera del límite");
                    }
                } catch (NumberFormatException e) {
                    mostrarTableros(nombreTablero, tableroAtacado);
                    System.out.println("\u001B[35mTurno del jugador: \u001B[37m" + nombre);
                    System.out.println("Acaba de ingresar una letra o símbolo");
                } catch (Exception e) {
                    mostrarTableros(nombreTablero, tableroAtacado);
                    System.out.println("\u001B[35mTurno del jugador: \u001B[37m" + nombre);
                    System.out.println("Debe ingresar un número (Entre 1 y " + tableroAtacado.length + "");
                }
            }
            esNumero = false;
            while (!esNumero) {

                System.out.println("Ingrese un número de columna (Entre 1 y " + tableroAtacado.length + " )");
                try {
                    auxiliar = reader.nextLine();
                    columna = Integer.parseInt(auxiliar) - 1;
                    if (columna < tableroAtacado.length && columna > -1) {
                        esNumero = true;
                    } else {
                        mostrarTableros(nombreTablero, tableroAtacado);
                        System.out.println("\u001B[35mTurno del jugador: \u001B[37m" + nombre);
                        System.out.println("EL número ingresado está fuera del límite");
                    }
                } catch (NumberFormatException e) {
                    mostrarTableros(nombreTablero, tableroAtacado);
                    System.out.println("\u001B[35mTurno del jugador: \u001B[37m" + nombre);
                    System.out.println("Acaba de ingresar una letra o símbolo");
                } catch (Exception e) {
                    mostrarTableros(nombreTablero, tableroAtacado);
                    System.out.println("\u001B[35mTurno del jugador: \u001B[37m" + nombre);
                    System.out.println("Debe ingresar un número (Entre 1 y " + tableroAtacado.length + "");
                }
            }
            esNumero = false;

            if (tableroAtacado[fila][columna].equals(mar)) {
                System.out.println("Su tiro ha impactado contra el mar");
                tableroAtacado[fila][columna] = disparos;

                impactos = true;
            } else if (tableroAtacado[fila][columna].equals(portaAvion)) {

                tableroAtacado[fila][columna] = barcosImpactados;
                mostrarTableros(nombreTablero, tableroAtacado);
                System.out.println("");
                System.out.println("Ha impacto con un portavión, de otro disparo");

            } else if (tableroAtacado[fila][columna].equals(submarino)) {

                tableroAtacado[fila][columna] = barcosImpactados;
                mostrarTableros(nombreTablero, tableroAtacado);
                System.out.println("");
                System.out.println("Ha impacto con un submarino, de otro disparo");
            } else if (tableroAtacado[fila][columna].equals(destructor)) {

                tableroAtacado[fila][columna] = barcosImpactados;
                mostrarTableros(nombreTablero, tableroAtacado);
                System.out.println("");
                System.out.println("Ha impacto con un destructor, de otro disparo");

            } else if (tableroAtacado[fila][columna].equals(fragata)) {

                tableroAtacado[fila][columna] = barcosImpactados;
                mostrarTableros(nombreTablero, tableroAtacado);
                System.out.println("");
                System.out.println("Ha impacto con una fragata, de otro disparo");
            }
        }
    }


    public void analizarTablero(String nombreGanador, String nombrePerdedor, String[][] tableroAnalisis) {

        boolean hayBarcos = false;
        for (int i = 0; i < tableroAnalisis.length; i++) {
            for (int j = 0; j < tableroAnalisis[i].length; j++) {
                if (tableroAnalisis[i][j].equals(portaAvion) || tableroAnalisis[i][j].equals(submarino) || tableroAnalisis[i][j].equals(destructor) || tableroAnalisis[i][j].equals(fragata)) {
                    hayBarcos = true;
                }
            }
        }
        if (!hayBarcos) {
            finDelJuego = true;
            System.out.println("\u001B[36m" + nombreGanador + " HA DESTRUIDO TODO LOS BARCOS DE SU ENEMIGO " + nombrePerdedor + "\u001B[37m");
        }
    }


}



