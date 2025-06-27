import java.util.Scanner;

public class DistanciaAviao {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] distancias = { { 0, 2, 11, 6, 15, 11, 1 },
                { 2, 0, 7, 12, 4, 2, 15 },
                { 11, 7, 0, 11, 8, 3, 13 },
                { 6, 12, 11, 0, 10, 2, 1 },
                { 15, 4, 8, 10, 0, 5, 3 },
                { 11, 2, 3, 2, 5, 0, 14 },
                { 1, 15, 13, 1, 13, 14, 0 } };

        int linha, coluna, cidade = 0, acumulador = 0;

        cidade = scan.nextInt();
        linha = (cidade % 10) - 1;
        while (cidade != -1) {

            cidade = scan.nextInt();
            if (cidade < 0) {
                break;
            }
            coluna = (cidade % 10) - 1;
            // System.out.printf("%d\n", distancias[linha][coluna]);
            acumulador += distancias[linha][coluna];
            linha = coluna;
        }
        System.out.println(acumulador);
        scan.close();
    }

}
