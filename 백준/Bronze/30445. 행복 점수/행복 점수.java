import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int PH = 0, PG = 0;

        for (char ch : line.toCharArray()) {
            if (ch == 'A') {
                PH += 1;
                PG += 1;
            } else if (ch == 'H' || ch == 'P' || ch == 'Y') {
                PH += 1;
            } else if (ch == 'S' || ch == 'D') {
                PG += 1;
            }
        }

        int H = 5000;

        if (!(PH == 0 && PG == 0)) {
            int temp = (PH * 100000) / (PH + PG);

            if (temp % 10 >= 5) {
                temp += 10;
            }

            H = temp / 10;
        }

        System.out.printf("%.2f\n", H * 0.01);
    }
}
