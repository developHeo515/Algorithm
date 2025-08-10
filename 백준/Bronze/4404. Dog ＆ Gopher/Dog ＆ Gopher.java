import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double gopherX = sc.nextDouble();
        double gopherY = sc.nextDouble();
        double dogX = sc.nextDouble();
        double dogY = sc.nextDouble();

        String escapeHole = null;

        while (sc.hasNext()) {
            double holeX = sc.nextDouble();
            double holeY = sc.nextDouble();

            double gopherDist = distance(gopherX, gopherY, holeX, holeY);
            double dogDist = distance(dogX, dogY, holeX, holeY);

            if (gopherDist <= dogDist / 2) {
                // 고슴도치가 탈출 가능한 구멍 발견시 저장하고 루프 종료
                escapeHole = String.format("The gopher can escape through the hole at (%.3f,%.3f).", holeX, holeY);
                break;
            }
        }

        if (escapeHole == null) {
            System.out.println("The gopher cannot escape.");
        } else {
            System.out.println(escapeHole);
        }

        sc.close();
    }

    private static double distance(double x1, double y1, double x2, double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
