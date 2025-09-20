import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cowphabet = scanner.nextLine();
        String heardString = scanner.nextLine();
        int humCount = 1;

        for (int i = 1; i < heardString.length(); i++) {
            
            char currentChar = heardString.charAt(i);
            char previousChar = heardString.charAt(i - 1);

            int currentPos = cowphabet.indexOf(currentChar);
            int previousPos = cowphabet.indexOf(previousChar);

            if (currentPos <= previousPos) {
                humCount++; // 흥얼거린 횟수를 1 증가
            }
        }

        System.out.println(humCount);

        scanner.close();
    }
}