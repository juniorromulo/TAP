import java.util.Scanner;

public class SomaDigitos {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numero = scan.nextInt(), soma = 0;

        while (numero > 0) {
            soma = soma + numero % 10;
            numero = numero / 10;
        }
        System.out.printf("%d\n", soma);
        scan.close();
    }
}
