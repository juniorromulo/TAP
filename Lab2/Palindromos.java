import java.util.Scanner;

public class Palindromos {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String palavra = scan.nextLine();
        palavra = palavra.toUpperCase();
        palavra = palavra.replace(" ", "");
        int i = 0, j = palavra.length() - 1;

        while (i <= j) {
            if (palavra.charAt(i) != palavra.charAt(j)) {
                break;
            }
            i++;
            j--;
        }
        if (i > j) {
            System.out.printf("%s %d", palavra, 1);
        } else {
            System.out.printf("%s %d", palavra, 0);
        }

        scan.close();
    }
}
