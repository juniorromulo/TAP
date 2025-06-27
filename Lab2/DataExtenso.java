import java.util.Scanner;

public class DataExtenso {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int data = scan.nextInt(), dia, mes, ano;
        String new_mes;
        dia = data / 1000000;
        ano = data % 10000;
        mes = (data - dia * 1000000 - ano) / 10000;

        if (mes == 1) {
            new_mes = "janeiro";
        } else if (mes == 2) {
            new_mes = "fevereiro";
        } else if (mes == 3) {
            new_mes = "marco";
        } else if (mes == 4) {
            new_mes = "abril";
        } else if (mes == 5) {
            new_mes = "maio";
        } else if (mes == 6) {
            new_mes = "junho";
        } else if (mes == 7) {
            new_mes = "julho";
        } else if (mes == 8) {
            new_mes = "agosto";
        } else if (mes == 9) {
            new_mes = "setembro";
        } else if (mes == 10) {
            new_mes = "outubro";
        } else if (mes == 11) {
            new_mes = "novembro";
        } else {
            new_mes = "dezembro";
        }

        System.out.printf("%d de %s de %d", dia, new_mes, ano);
        scan.close();
    }
}
