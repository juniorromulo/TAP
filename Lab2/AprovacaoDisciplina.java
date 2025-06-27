import java.util.Scanner;
import java.util.ArrayList;

public class AprovacaoDisciplina {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Double> notas = new ArrayList<Double>();
        ArrayList<Integer> frequencias = new ArrayList<Integer>();
        double entrada1 = scan.nextDouble();

        while (entrada1 != -1) {
            notas.add(entrada1);
            entrada1 = scan.nextDouble();
        }

        int entrada2 = scan.nextInt();

        while (entrada2 != -1) {
            frequencias.add(entrada2);
            entrada2 = scan.nextInt();
        }

        int carga_horaria = scan.nextInt();

        int aprovados = 0, reprov_notas = 0, reprov_freq = 0;

        for (int i = 0; i < notas.size(); i++) {
            double presenca = (double) frequencias.get(i) / (double) carga_horaria;
            // System.out.printf("%f\n", presenca);
            if (notas.get(i) >= 5.0 && presenca >= 0.75) {
                aprovados++;
                // System.out.print("A\n");
            } else if (presenca < 0.75) {
                reprov_freq++;
                // System.out.print("F\n");
            } else {
                reprov_notas++;
                // System.out.print("N\n");
            }
        }

        System.out.printf("%d %d %d", aprovados, reprov_notas, reprov_freq);
        scan.close();
    }
}

// Entrada: 10,0 10,0 9,0 -1 44 45 46 -1 60
