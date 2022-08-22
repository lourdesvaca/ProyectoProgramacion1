public class Ejecutable {
    public static void main(String[] args) {
        System.out.println("                        ");
        System.out.println("                     \u001B[31m▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("                   ▒            « BATALLA NAVAL »             ▒");
        System.out.println("                     \u001B[31m▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\u001B[37m");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("                \u001B[32m░░░░░░░░░░░░░░░░░░ REGLAS DEL JUEGO ░░░░░░░░░░░░░░░░░░\u001B[37m");
        System.out.println("\u001B[33mJuego de 2 jugadores");
        System.out.println("Barcos en el mapa: ");
        System.out.println(" 1 PORTAAVIONES          --> 4 Casillas --> Signo: P");
        System.out.println(" 3 SUBMARINOS/ACORAZADOS --> 3 Casillas --> Signo: S");
        System.out.println(" 3 DESTRUCTORES          --> 3 Casillas --> Signo: D");
        System.out.println(" 2 FRAGATAS              --> 1 Casilla  --> Signo: F");
        System.out.println("Total: 9 barcos en el mar");
        System.out.println("El tablero está compuesto por 10 filas y 10 columnas");
        System.out.println("Gana el jugador que destruya todos los barcos");
        System.out.println("");

        System.out.println("              \u001B[32m ░░░░░░░░░░░░░░░░░░ DISFRUTE EL JUEGO ░░░░░░░░░░░░░░░░░░\u001B[37m");
        System.out.println("");
        BatallaNaval BatallaNaval = new BatallaNaval();
    }
}
