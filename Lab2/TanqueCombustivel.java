import java.util.Scanner;

public class TanqueCombustivel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int raio = scan.nextInt();
        int altura = scan.nextInt();

        if (scan.nextInt() == 1) {
            double volume_ar = (Math.PI / 3.0) * Math.pow(altura, 2) * (3 * raio - altura);
            System.out.printf("%.4f", volume_ar);
        } else {
            double volume_esfera = (4.0 / 3.0) * Math.PI * Math.pow(raio, 3);
            double volume_ar = (Math.PI / 3) * Math.pow(altura, 2) * (3 * raio - altura);
            System.out.printf("%.4f", (volume_esfera - volume_ar));

        }

        scan.close();
    }
}
