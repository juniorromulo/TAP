import java.util.Scanner;

public class Xadrez {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int qtd_linhas = scanner.nextInt();
        String str_par = "", str_impar = " ";
        for (int count = 0; count < qtd_linhas; count++) {
            str_par += "* ";
            str_impar += "* ";
        }

        for (int linha = 0; linha < qtd_linhas; linha++) {
            if (linha % 2 == 0) {
                System.out.printf("%s\n", str_par);
            } else {
                System.out.printf("%s\n", str_impar);
            }
        }
        scanner.close();
    }
}
