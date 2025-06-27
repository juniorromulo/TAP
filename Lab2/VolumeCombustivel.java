import java.util.Scanner;

public class VolumeCombustivel {
    static double volumeEsfera(double raioBojo, double altura) {
        double volume_ar = (Math.PI / 3.0) * Math.pow(altura, 2) * (3 * raioBojo - altura);
        double volume = (4.0 * Math.PI * Math.pow(raioBojo, 3)) / 3.0;
        return volume - volume_ar;
    }

    static double volumeCilindro(double raioBojo, double altura) {
        double volume = Math.PI * Math.pow(raioBojo, 2) * altura;
        return volume;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int alturaTanque = scan.nextInt();
        int nivelCombustivel = scan.nextInt();
        double raioBojo = scan.nextDouble();
        double alturaCilindro = alturaTanque - 2 * raioBojo;
        double volumeCombustivel = 0, alturaEsfera = 0, alturaTotalCilindro = 0;

        if (alturaTanque < 0 || nivelCombustivel < 0 || raioBojo < 0) {
            System.out.println("-1.000");
        } else {
            if (nivelCombustivel > raioBojo) {
                double novoNivel = nivelCombustivel - raioBojo;
                alturaEsfera = raioBojo;

                if (novoNivel > alturaCilindro) {
                    alturaTotalCilindro = alturaCilindro;
                    alturaEsfera = alturaEsfera + (nivelCombustivel - alturaCilindro);
                } else {
                    alturaTotalCilindro = novoNivel;
                }
            } else {
                alturaEsfera = nivelCombustivel;
            }
            double alturaCalota = 2 * raioBojo - alturaEsfera;
            double volumeCilindro = volumeCilindro(raioBojo, alturaTotalCilindro);
            double volumeEsfera = volumeEsfera(raioBojo, alturaCalota);

            volumeCombustivel = volumeEsfera + volumeCilindro;
            System.out.printf("%.3f", volumeCombustivel);

        }
        scan.close();
    }
}