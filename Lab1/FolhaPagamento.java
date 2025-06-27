import java.util.Scanner;

public class FolhaPagamento {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int valor_hora = scan.nextInt();
        int horas = scan.nextInt();
        double salario = valor_hora * horas;
        double inss = salario * 0.08;
        double imposto_renda = salario * 0.11;
        double descontos = imposto_renda + inss;

        System.out.printf("Salario bruto: R$%.2f\nIR: R$%.2f\nINSS: R$%.2f\nTotal de descontos: R$%.2f\n", salario,
                imposto_renda, inss, descontos);

        salario = salario - descontos;
        System.out.printf("Salario liquido: R$%.2f", salario);
        scan.close();
    }
}