import java.util.Scanner;
import java.util.ArrayList;

public class AreaPoligono {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Double> abscissas = new ArrayList<Double>();
        ArrayList<Double> ordenadas = new ArrayList<Double>();

        double entrada = scan.nextDouble();
        while (entrada != -1 || entrada != -1.0) {
            abscissas.add(entrada);
            entrada = scan.nextDouble();

        }

        entrada = scan.nextDouble();
        while (entrada != -1) {
            ordenadas.add(entrada);
            entrada = scan.nextDouble();
        }

        double somatorio = 0;

        for (int i = 0; i <= abscissas.size() - 2; i++) {
            somatorio += (abscissas.get(i + 1) + abscissas.get(i)) * (ordenadas.get(i + 1) - ordenadas.get(i));
        }
        somatorio = Math.abs(somatorio) / 2.0;
        System.out.printf("%.4f", somatorio);
        scan.close();
    }
}
