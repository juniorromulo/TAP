import java.util.Scanner;

public class TipoTriangulo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b, c;
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();

        if (!((a < 0) || (b < 0) || (c < 0) || ((a + b) <= c)
                || ((a + c) <= b) || ((b + c) <= a))) {
            if ((a == b) && (a == c)) {
                System.out.printf("equilatero");
            } else if ((a != b) && (a != c)) {
                System.out.printf("escaleno");
            } else {
                System.out.printf("isoceles");
            }
        } else {
            System.out.printf("invalido");
        }
        scan.close();
    }
}
