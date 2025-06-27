import java.util.Scanner;

public class AsciiArt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int qtd_ascii = scan.nextInt();
        int qtd_espacos = 0;
        for (int i = 0; i < qtd_ascii; i++) {
            String ascii = "";
            String espacos = "";
            for (int j = i; j < qtd_ascii; j++) {
                ascii = ascii + "*";
            }
            for (int k = 0; k < qtd_espacos * 2; k++) {
                espacos = espacos + " ";
            }

            System.out.printf("%s%s%s\n", ascii, espacos, ascii);
            qtd_espacos++;
        }

        scan.close();
    }
}
