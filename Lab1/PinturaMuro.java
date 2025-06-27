import java.util.Scanner;

public class PinturaMuro {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double preco_pintor = scan.nextDouble();
        double preco_final = 100 + (36 * preco_pintor);
        System.out.printf("%.1f", preco_final);
        scan.close(); // fechando o scan (necessario)
    }

}