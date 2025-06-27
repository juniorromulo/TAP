import java.util.Scanner;

public class ContaEnergia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double kilo_watts = scanner.nextDouble();
        char tipo_energia = scanner.next().charAt(0);

        if (tipo_energia == 'R' && kilo_watts > 0) {
            if (kilo_watts <= 500) {
                kilo_watts = kilo_watts * 0.40;
            } else {
                kilo_watts = kilo_watts * 0.65;
            }
            System.out.printf("%.2f", kilo_watts);
        } else if (tipo_energia == 'C' && kilo_watts > 0) {
            if (kilo_watts <= 1000) {
                kilo_watts = kilo_watts * 0.55;
            } else {
                kilo_watts = kilo_watts * 0.60;
            }
            System.out.printf("%.2f", kilo_watts);
        } else if (tipo_energia == 'I' && kilo_watts > 0) {
            if (kilo_watts <= 5000) {
                kilo_watts = kilo_watts * 0.65;
            } else {
                kilo_watts = kilo_watts * 0.60;
            }
            System.out.printf("%.2f", kilo_watts);
        } else {
            System.out.print("-1.00");
        }

        scanner.close();
    }
}
