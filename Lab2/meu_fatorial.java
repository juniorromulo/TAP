
public class meu_fatorial {
    public static double main(int qtd_fatorial) {
        double fatorial = 1;

        for (int i = 1; i <= qtd_fatorial; i++) {
            fatorial *= i;
        }
        return fatorial;
    }

}
