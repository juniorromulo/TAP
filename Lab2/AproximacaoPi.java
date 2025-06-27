import java.util.Scanner;

public class AproximacaoPi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double qtd_termos = scan.nextDouble(), termo_geral = 3.0, divisor = 2.0;

        System.out.printf("%.6f\n", termo_geral);
        for (double termo_atual = 3; termo_atual < qtd_termos + 2; termo_atual++) {
            if (!(termo_atual % 2 == 0)) {
                termo_geral = termo_geral + (4.0 / (divisor * (divisor + 1) * (divisor + 2)));
            } else {
                termo_geral = termo_geral - (4.0 / (divisor * (divisor + 1) * (divisor + 2)));
            }
            divisor += 2.0;
            System.out.printf("%.6f\n", termo_geral);
        }

        scan.close();
    }
}
