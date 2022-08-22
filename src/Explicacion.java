import java.util.Scanner;

public class Explicacion {
    public static void main(String[] args) {
        //Bloque de declaraciones
        Scanner reader = new Scanner(System.in);
        int num1;
        int num2;
        //Bloque de instrucciones
        System.out.println("Suma de dos enteros");
        System.out.println("Ingrese el número 1 de 2");
        num1 = reader.nextInt();
        System.out.println("Ingrese un número 2 de 2");
        num2 = reader.nextInt();
        System.out.println("El resultado es: "+(num1 + num2));
        System.out.println("El resultado es: ");
        System.out.println(num1+ num2);
    }
}
