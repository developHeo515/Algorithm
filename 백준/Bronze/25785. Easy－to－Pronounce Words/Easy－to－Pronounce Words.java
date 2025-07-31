import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int answer = 1;
        int checkNum;

        if (vowels.contains(word.charAt(0))) {
            checkNum = 1;
        } else {
            checkNum = 0;
        }

        // 단어의 나머지 부분을 반복 처리
        for (int i = 1; i < word.length(); i++) {
            char w = word.charAt(i);
            if (vowels.contains(w)) {
                checkNum++;
            } else {
                checkNum--;
            }

            if (checkNum > 1 || checkNum < 0) {
                answer = 0;
                break;
            }
        }
        
        System.out.println(answer); 
        scanner.close(); 
    }
}