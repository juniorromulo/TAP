import java.util.Scanner;

public class AreaTriangulo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();

        if (((a + b) > c) && ((a + c) > b) && ((b + c) > a)) {
            double s = (a + b + c) / 2;
            double resultado = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            System.out.printf("%.2f", resultado);
        } else {
            System.out.print("Triangulo invalido");
        }

        scan.close();
    }
}
