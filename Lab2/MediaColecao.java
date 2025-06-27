import java.util.Scanner;

public class MediaColecao {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int acumulador = 0, entrada = 0, elementos = 0;

        while (entrada != -1) {
            entrada = scan.nextInt();
            if (entrada != -1) {
                acumulador += entrada;
                elementos++;
            }

        }

        System.out.printf("%.2f", ((double) acumulador / (double) elementos));

        scan.close();
    }
}
