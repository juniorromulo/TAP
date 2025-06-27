import java.util.Scanner;

public class Desconto {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double preco = scan.nextDouble();
        if (preco >= 200.0) {
            preco = preco - preco * 0.05;
            System.out.printf("%.2f", preco);
        } else {
            System.out.printf("%.2f", preco);
        }
        scan.close();
    }
}
