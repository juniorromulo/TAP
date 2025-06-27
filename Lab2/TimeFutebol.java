import java.util.Scanner;
import java.util.ArrayList;

public class TimeFutebol {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> time1 = new ArrayList<Integer>();
        ArrayList<Integer> time2 = new ArrayList<Integer>();

        int entrada = scan.nextInt();

        while (entrada != -1) {
            time1.add(entrada);
            entrada = scan.nextInt();
        }
        entrada = scan.nextInt();

        while (entrada != -1) {
            time2.add(entrada);
            entrada = scan.nextInt();
        }
        int vitorias = 0, derrotas = 0, empates = 0;
        for (int i = 0; i < time1.size(); i++) {
            if (time1.get(i) > time2.get(i)) {
                vitorias++;
            } else if (time1.get(i) < time2.get(i)) {
                derrotas++;
            } else {
                empates++;
            }
        }
        System.out.printf("%d %d %d", vitorias, empates, derrotas);
        scan.close();
    }
}
