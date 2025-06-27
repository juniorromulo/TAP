import java.util.Scanner;
import java.util.ArrayList;

public class Mediana {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Double> inteiros = new ArrayList<Double>();

        double entrada = scan.nextDouble();

        while (entrada != -1) {
            inteiros.add(entrada);
            entrada = scan.nextDouble();
        }
        int meio = inteiros.size() / 2;
        double mediana;

        if (inteiros.size() % 2 == 0) {
            mediana = (inteiros.get(meio) + inteiros.get(meio - 1)) / 2;
        } else {
            mediana = inteiros.get(meio);
        }
        System.out.printf("%.1f", mediana);
        scan.close();
    }
}
