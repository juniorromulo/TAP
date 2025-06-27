import java.util.Scanner;

public class PorcentagemAcerto {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int vet_respostas[] = new int[10], vet_gabarito[] = new int[10];
        int entrada = 0, ocupacao_vetor = 0;

        entrada = scan.nextInt();
        while (entrada != -1) {

            if (ocupacao_vetor + 1 == vet_respostas.length) {
                int[] tmp = new int[vet_respostas.length * 2];
                System.arraycopy(vet_respostas, 0, tmp, 0, vet_respostas.length);
                vet_respostas = tmp;
                tmp = null;
            }
            vet_respostas[ocupacao_vetor] = entrada;
            entrada = scan.nextInt();
            ocupacao_vetor++;
        }

        entrada = scan.nextInt();
        ocupacao_vetor = 0;
        while (entrada != -1) {
            if (ocupacao_vetor + 1 == vet_gabarito.length) {
                int[] tmp = new int[vet_gabarito.length * 2];
                System.arraycopy(vet_gabarito, 0, tmp, 0, vet_gabarito.length);
                vet_gabarito = tmp;
                tmp = null;
            }
            vet_gabarito[ocupacao_vetor] = entrada;
            entrada = scan.nextInt();
            ocupacao_vetor++;
        }

        // for (int i = 0; i < ocupacao_vetor; i++) {
        // System.out.printf("[%d]: %d\n", i, vet_respostas[i]);
        // }
        // for (int i = 0; i < ocupacao_vetor; i++) {
        // System.out.printf("[%d]: %d\n", i, vet_gabarito[i]);
        // }

        double acertos = 0;
        for (int i = 0; i < ocupacao_vetor; i++) {
            if (vet_respostas[i] == vet_gabarito[i]) {
                acertos++;
            }
        }
        System.out.printf("%.2f", ((acertos / ocupacao_vetor) * 100.0));
        scan.close();
    }
}
