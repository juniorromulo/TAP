import java.util.Scanner;
import java.util.ArrayList;

public class OperacoesInteiros {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> inteiros = new ArrayList<Integer>();

        int pares = 0, impares = 0, soma = 0, maior = 0, menor = 0, entrada = 0, vazio = 0;
        entrada = scan.nextInt();
        while (true) {
            // Verificar se precisa realocar

            // 1 5 2 8 4 -1 10 54 23 78 -1 -1
            if (entrada == -1) {
                if (vazio == 1) {
                    break;
                }
                System.out.printf("%d\n", inteiros.size());
                System.out.printf("%d\n", pares);
                System.out.printf("%d\n", impares);
                System.out.printf("%d\n", soma);
                System.out.printf("%.2f\n", (double) soma / (double) inteiros.size());
                System.out.printf("%d\n", maior);
                System.out.printf("%d\n", menor);

                inteiros.clear();
                pares = 0;
                impares = 0;
                soma = 0;
                maior = 0;
                menor = 0;
                vazio = 1;

            } else {
                vazio = 0;
                inteiros.add(entrada);
                soma += entrada;
                // Contabilizar se é par ou ímpar
                if (entrada % 2 == 0) {
                    pares++;
                } else {
                    impares++;
                }
                //
                if (inteiros.size() == 1) {
                    maior = entrada;
                    menor = entrada;
                } else if (entrada > maior) {
                    maior = entrada;
                } else if (entrada < menor) {
                    menor = entrada;
                }

            }
            entrada = scan.nextInt();
        }
        scan.close();
    }

}
// 1 5 2 8 4 -1 10 54 23 78 -1 -1