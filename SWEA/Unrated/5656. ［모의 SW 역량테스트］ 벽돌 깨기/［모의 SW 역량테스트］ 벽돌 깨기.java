//[모의 SW 역량테스트] 벽돌 깨기
import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map, tmp;
	static int N, W, H, Answer;
	static int[] dx = {0, 1, 0, -1}; // 우 하 좌 상
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken()); // j , y 역할
			H = Integer.parseInt(st.nextToken()); // i , x 역할
			Answer = Integer.MAX_VALUE;
			map = new int[H][W];
			
			int arr[] = new int[W];
			int output[] = new int[N];
			boolean visited[] = new boolean[W];
			for(int i = 0; i < W; i++) {
				arr[i] = i;
			}
//			System.out.println(Arrays.toString(arr));
			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			for(int i = 0; i < H; i++) {
//				for(int j = 0; j < W; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			permutation(arr, output, visited, 0, N);
			bw.write("#"+tc+" " +Answer+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void func(int position, int[][] tmp) {
		boolean flag = false;
		for(int i = 0; i < H; i++) {
			if(flag) break; //벽돌 이미 맞았으면 탈출
			if(tmp[i][position] != 0) { //벽돌에 구슬이 명중했을 때
				flag = true; //벽돌 맞았으니 더 안 돌아도 됨
				
				//BFS 시작
				Queue<int[]> q = new LinkedList<>();
				q.add(new int[] {i, position});
				
				while(!q.isEmpty()) {
					int[] cur = q.poll();
					int curX = cur[0];
					int curY = cur[1];
					
					
					if(tmp[curX][curY] == 1) { // 숫자 1 벽돌에 떨어졌을때
						tmp[curX][curY] = 0;
					}else { 	// 숫자 2 이상 벽돌에 떨어졌을 때
						for(int dic = 0; dic < 4; dic++) {
							int nextX = curX; // 현재 x값 저장
							int nextY = curY; // 현재 y값 저장
							for(int freq = 0; freq < tmp[curX][curY] - 1; freq++) {
//								System.out.println(freq);
								nextX = nextX + dx[dic];
								nextY = nextY + dy[dic];
//								System.out.println(nextX + " "+ nextY);
								
								//범위체크해줘야함
								if(nextX < 0 || nextY < 0 || nextX >= H || nextY >= W) continue; 
								
								if(tmp[nextX][nextY] == 0) continue;
								else if(tmp[nextX][nextY] == 1) tmp[nextX][nextY] = 0;
								else {
									q.add(new int[] {nextX, nextY});
								}
							}
						}
						tmp[curX][curY] = 0; //벽돌 맞은 위치도 없애줘야함
					}
					
				}
			}
		}
		fall(tmp); //구슬로 벽돌을 폭파시켰으니 빈칸없이 벽돌들을 낙하시킨다.
	}
	static void fall(int[][] tmp) {
		for(int j = 0; j < W; j++) {
			Stack<Integer> rock = new Stack<>();
			for(int i = 0; i < H; i++) {
				if(tmp[i][j] != 0) {
					rock.add(tmp[i][j]);
					tmp[i][j] = 0;
				}
			}
			int idx = H-1; // 아래부터 쌓기 위해 index 초기화
			while(!rock.isEmpty()) {
				tmp[idx--][j] = rock.pop();
			}
		}
	}

	static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int N) {
		if(depth == N) {
			//중복허용 순열 생성 완료
			tmp = new int[H][W];
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					tmp[i][j] = map[i][j];
				}
			}
			
			for(int i = 0; i < N; i++) {
//				System.out.print(output[i] + " ");
				func(output[i], tmp);
			}
//			System.out.println();
			
			//여기서 최소값 탐색
			int total = 0;
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(tmp[i][j] != 0) {
						total++;
					}
				}
			}
			Answer = Math.min(total, Answer);
			return;
		}
		
		for(int i = 0; i < W; i++) {
			output[depth] = arr[i];
			permutation(arr, output, visited, depth+1, N);
		}
	}
}
