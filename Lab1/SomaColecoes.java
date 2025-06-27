import java.util.Scanner;

public class SomaColecoes {
    public static void main(String[] args) {
        int colecao = 0, colecao_vazia = 0, entrada, ocupacao_vetor = 0;
        int colecoes[] = new int[10];
        Scanner scan = new Scanner(System.in);

        while (true) {
            entrada = scan.nextInt();
            if (ocupacao_vetor + 1 == colecoes.length) {
                int[] tmp = new int[colecoes.length * 2];
                System.arraycopy(colecoes, 0, tmp, 0, colecoes.length);
                colecoes = tmp;
                tmp = null;
            }

            if ((entrada == -1) && (colecao_vazia) == 0) {
                colecoes[ocupacao_vetor] = colecao;
                // System.out.printf("inserido na psoicao %d: %d\n", ocupacao_vetor, colecao);

                colecao = 0;
                colecao_vazia = 1;
                ocupacao_vetor++;
            } else if ((entrada == -1) && (colecao_vazia == 1)) {
                break;
            } else {
                colecao += entrada;
                colecao_vazia = 0;
                // System.out.printf("somatorio = %d\n", colecao);
            }

        }
        if (ocupacao_vetor > 0) {
            // System.out.printf("----------\n");
            for (int i = 0; i < ocupacao_vetor; i++) {
                System.out.printf("%d\n", colecoes[i]);
            }
        }
        scan.close();
    }
}
