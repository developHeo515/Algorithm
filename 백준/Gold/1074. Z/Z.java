//BOJ1074 Z, 골드5
//재귀, 분할정복
//생각보다 이해하는데 오래걸렸다(1시간 50분)
import java.io.*;
import java.util.*;

public class Main {
	static int res = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int Znum = (int)Math.pow(2, n);
		Z(Znum, r, c);
		System.out.println(res);
	}
	static void Z(int n, int r, int c) {
		if(n == 1) {
			return;
		}
		int num = n/2;
		if(r < num && c < num) { //좌표가 왼쪽 위일때
//			res += (num * num * 0);
			Z(num, r, c);
		}
		else if(r < num && c >= num) { //좌표가 오른쪽 위일때
			res += (num * num * 1);
			Z(num, r, c - num); //이렇게 num을 빼주는거를 이해하는데 오래걸림
		}
		else if(r >= num && c < num) { //좌표가 왼쪽 아래일때
			res += (num * num * 2);
			Z(num, r - num, c);
		}
		else if(r >= num && c >= num) { // (r >= num && c >= num)  좌표가 오른쪽 아래일때
			res += (num * num * 3);
			Z(num, r - num, c - num);
		}
	}
}
