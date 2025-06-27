import java.util.Scanner;

public class SomaColecao {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int acumulador = 0, entrada = 0;

        while (entrada != -1) {
            entrada = scan.nextInt();
            if (entrada != -1)
                acumulador += entrada;
        }

        System.out.printf("%d", acumulador);

        scan.close();
    }
}
