import java.util.Scanner;

public class RaizDois {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int repeticoes = scan.nextInt();

        for (int i = 0; i < repeticoes; i++) {
            double parteCiclica = 3.0;
            for (int j = 0; j < i; j++) {
                parteCiclica = 2.0 + (1.0 / parteCiclica);
            }
            parteCiclica = 1 + (1.0 / parteCiclica);
            System.out.printf("%.14f\n", parteCiclica);
        }

        scan.close();
    }
}