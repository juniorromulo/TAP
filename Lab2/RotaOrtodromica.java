import java.util.Scanner;

public class RotaOrtodromica {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double t1 = scan.nextDouble();
        double g1 = scan.nextDouble();
        double t2 = scan.nextDouble();
        double g2 = scan.nextDouble();
        double radian_t1 = Math.toRadians(t1);
        double radian_t2 = Math.toRadians(t2);
        double radian_g1 = Math.toRadians(g1);
        double radian_g2 = Math.toRadians(g2);

        double d = 6371.0
                * Math.acos((Math.sin(radian_t1) * Math.sin(radian_t2))
                        + (Math.cos(radian_t1) * Math.cos(radian_t2) * Math.cos((radian_g1 - radian_g2))));
        System.out.printf("A distancia entre os pontos (%f, %f) e (%f, %f) e de %.2f km", t1, g1, t2, g2, d);
        scan.close();

    }
}
