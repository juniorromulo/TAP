import java.util.Scanner;

public class AnimaisCedulas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nota = scan.nextInt();

        if (nota == 2) {
            System.out.printf("Tartaruga");
        } else if (nota == 5) {
            System.out.printf("Garça");
        } else if (nota == 10) {
            System.out.printf("Arara");
        } else if (nota == 20) {
            System.out.printf("Mico-leão-dourado");
        } else if (nota == 50) {
            System.out.printf("Onça-pintada");
        } else if (nota == 100) {
            System.out.printf("Garoupa");
        } else {
            System.out.print("erro");
        }
        scan.close();
    }
}
