import java.util.Scanner;

public class CaixaEletronico {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dinheiro = scan.nextInt();
        int notas_50 = 0, notas_10 = 0, notas_2 = 0;
        while (dinheiro >= 2) {
            if (dinheiro >= 50) {
                dinheiro = dinheiro - 50;
                notas_50++;

            } else if (dinheiro >= 10) {
                dinheiro = dinheiro - 10;
                notas_10++;

            } else {
                dinheiro = dinheiro - 2;
                notas_2++;

            }
        }
        scan.close();
        if (dinheiro == 0) {
            System.out.printf("%d notas de R$50, %d notas de R$10 e %d notas de R$2", notas_50, notas_10, notas_2);
        } else {
            System.out.print("Valor Invalido");
        }
    }
}
