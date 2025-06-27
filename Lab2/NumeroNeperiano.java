import java.util.Scanner;

public class NumeroNeperiano {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double qtd_termos = scan.nextDouble(), termo_geral = 0.0;

        for (double termo_atual = 0; termo_atual < qtd_termos; termo_atual++) {

            double fatorial = 1;

            for (int i = 1; i <= termo_atual; i++) { // fatorial
                fatorial *= i;
            }

            termo_geral = termo_geral + 1.0 / fatorial; // calculando o termo
        }
        System.out.printf("%.6f\n", termo_geral);
        scan.close();
    }
}
