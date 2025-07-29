import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            // 패턴 입력
            String[] sz = br.readLine().split(" ");
            int Li = Integer.parseInt(sz[0]);
            int Ci = Integer.parseInt(sz[1]);
            char[][] image = new char[Li][Ci];

            for (int i = 0; i < Li; i++) {
                String line = br.readLine();
                image[i] = line.toCharArray();
            }

            // 맵 입력
            sz = br.readLine().split(" ");
            int Lm = Integer.parseInt(sz[0]);
            int Cm = Integer.parseInt(sz[1]);
            char[][] map = new char[Lm][Cm];

            for (int i = 0; i < Lm; i++) {
                String line = br.readLine();
                map[i] = line.toCharArray();
            }

            int count = 0;

            // 루프 돌며 패턴 체크
            for (int i = 0; i <= Lm - Li; i++) {
                for (int j = 0; j <= Cm - Ci; j++) {
                    if (matches(map, image, i, j, Li, Ci)) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    // 패턴이 해당 위치에 딱 맞는지 확인
    static boolean matches(char[][] map, char[][] image, int startRow, int startCol, int Li, int Ci) {
        for (int i = 0; i < Li; i++) {
            for (int j = 0; j < Ci; j++) {
                if (map[startRow + i][startCol + j] != image[i][j]) return false;
            }
        }
        return true;
    }
}
