import java.util.Scanner;

public class CifraCesar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int deslocamento = scan.nextInt();
        String novoTexto = "";
        String texto = scan.nextLine();

        for (int i = 1; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            if ((letra >= 97 && letra <= 122)) {
                letra = (char) (letra - 'a');
                letra = (char) ((letra + deslocamento) % 26);
                letra += 'A';
            }
            novoTexto += letra;
        }
        System.out.printf("%s", novoTexto);
        scan.close();
        // scan2.close();
    }
}
