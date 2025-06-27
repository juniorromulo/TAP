import java.util.Scanner;
import java.lang.Math;

public class RaizQuadrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numero = scanner.nextDouble();
        numero = Math.pow(numero, 0.5);
        scanner.close();
        System.out.printf("%.4f", numero);
    }
}
