//BOJ2239 스도쿠 골4
//백트래킹 문제
// 처음에 0들을 list에 넣을 생각을 못하고 그냥 2차원 배열로 돌려서 코드 방향성을 잘못짰다.
import java.io.*;
import java.util.*;

public class Main {
	static int[][] sudoku;
	static ArrayList<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		list = new ArrayList<>();
		sudoku = new int[9 + 1][9 + 1];
		for (int i = 1; i <= 9; i++) {
			String temp = br.readLine();
			for (int j = 1; j <= 9; j++) {
//				char c = temp.charAt(j-1);
//				String ch = Character.toString(c);
//				int n = Integer.parseInt(ch);
				sudoku[i][j] = temp.charAt(j - 1) - '0';
				if (sudoku[i][j] == 0)
					list.add(new int[] { i, j });
			}
		}
//		print(sudoku);

		back(0);
//		System.out.println("qwer");

		bw.flush();
		bw.close();
		br.close();
	}

	static void back(int level) {
		if (list.size() == level) {
			print();
//			return;
			System.exit(0); //return 하면 출력초과 나온다
		}

		int x = list.get(level)[0];
		int y = list.get(level)[1];

		boolean[] check = new boolean[9 + 1];

		for (int i = 1; i <= 9; i++) { // 가로 검사
			if (sudoku[x][i] != 0)
				check[sudoku[x][i]] = true;
		}

		for (int i = 1; i <= 9; i++) {// 세로 검사
			if (sudoku[i][y] != 0)
				check[sudoku[i][y]] = true;
		}

		int startX = ((x-1) / 3) * 3;
		int startY = ((y-1) / 3) * 3;
		for (int i = startX + 1; i < startX + 4; i++) { // 3x3 검사
			for (int j = startY + 1; j < startY + 4; j++) {
//				System.out.println(i + " " + j);
				if (sudoku[i][j] != 0)
					check[sudoku[i][j]] = true;
			}
		}

		for (int i = 1; i <= 9; i++) {
			if (!check[i]) {
				sudoku[x][y] = i;
				back(level + 1);
				sudoku[x][y] = 0;
			}
		}

	}

	static void print() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
	}
}
