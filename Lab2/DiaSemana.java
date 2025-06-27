import java.util.Scanner;
import java.util.ArrayList;

public class DiaSemana {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> matriz = new ArrayList<Integer>();
        ArrayList<Integer> maioresOcorrencias = new ArrayList<Integer>();
        int entrada = scan.nextInt(), ultimoSomatorio = -1;

        while (entrada != -1) {
            matriz.add(entrada);
            entrada = scan.nextInt();
        }

        for (int i = 0; i < 7; i++) {
            int somatorioAtual = 0;
            for (int j = 0; j < matriz.size(); j += 7) {
                somatorioAtual += matriz.get(j + i);
            }
            if (somatorioAtual >= ultimoSomatorio) {
                if (somatorioAtual > ultimoSomatorio) {
                    maioresOcorrencias.clear();
                }

                maioresOcorrencias.add(i + 1);
                ultimoSomatorio = somatorioAtual;

            }
            // System.out.printf("dia: %d ; ocorrencia: %d\n", i + 1, somatorioAtual);
        }

        for (int i = 0; i < maioresOcorrencias.size(); i++) {
            System.out.printf("%d\n", maioresOcorrencias.get(i));
        }
        scan.close();
    }
}
