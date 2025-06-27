import java.util.Scanner;

public class AproximacaoSeno {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double angulo = scan.nextDouble(), nro_termos = scan.nextDouble(), termo_geral, divisor = 3;
        angulo = Math.toRadians(angulo);
        termo_geral = angulo;

        System.out.printf("%.10f\n", termo_geral);
        for (double termo_atual = 3; termo_atual < nro_termos + 2; termo_atual++) {
            double fatorial = 1;

            for (int i = 1; i <= divisor; i++) { // fatorial
                fatorial *= i;
            }

            if (!(termo_atual % 2 == 0)) {
                termo_geral = termo_geral - (Math.pow(angulo, divisor) / fatorial);
            } else {
                termo_geral = termo_geral + (Math.pow(angulo, divisor) / fatorial);
            }
            divisor += 2.0;
            System.out.printf("%.10f\n", termo_geral);
        }

        scan.close();
    }
}
