//BOJ17135 캐슬 디펜스, 골3
//조합
//최대 적 처치 수 구하기
//구현, 시뮬 문제
//거리 구현에서 막혀서 해석봄
//bfs 좌 상 우 순으로 제거하면 되는줄 알았는데 잘못생각했다
//구현하는 단계가 많아서 시간이 많이걸리고 아직 나에게 어려운 문제인듯하다
//71줄에 depth == 5로 고정해서 틀렸음
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, D;
	static int[][] map;
	static int[][] copy;
	static int[] dx = {}; //좌 상 우
	static int[] dy = {};
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		copy = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = map[i][j];
			}
		}

		//1. 조합
		//2. 쏴서 죽임(D 거리 안)
		//궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적
		//그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격
		//같은 적이 여러 궁수에게 공격당할 수 있다
		//3. 적이 없으면 종료 or 적들 한칸 아래로 이동(범위 벗어나면 종료)
		
		boolean[] visited = new boolean[M+1];
		comb(1, visited, 0);

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	//1. 조합
	static void comb(int depth, boolean[] visited, int r) {
		if(r == 3) {
			ArrayList<Integer> archer = new ArrayList<>();
			for(int k = 1; k <= M; k++) {
				if(visited[k]) {
//					System.out.print(k + " ");
					archer.add(k);
				}
			}
//			System.out.println();
			
			init();
			attack(archer);
			return;
		}

		if(depth == M+1) {
			return;
		}
		
		visited[depth] = true;
		comb(depth+1, visited, r+1);
		visited[depth] = false;
		comb(depth+1, visited, r);
		
	}
	
	static void attack(ArrayList<Integer> archer) {
//		for(int cur: archer) {
//			System.out.print(cur + " ");
//		}
//		System.out.println();
		
		//2. 쏴서 죽임(D 거리 안)
		//궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적
		//그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격
		//같은 적이 여러 궁수에게 공격당할 수 있다
		//3. 적이 없으면 종료 or 적들 한칸 아래로 이동(범위 벗어나면 종료)
		int res = 0;
		
		//최대  N턴 진행(적들이 내려가니까)
		for(int n = 1; n <= N; n++) {
			boolean[][] kill = new boolean[N+1][M+1];
			for(int k = 0; k < archer.size(); k++) {
				int archerY = archer.get(k); //궁수 y
				
				int minD = 987654321;
				int minX = 987654321;
				int minY = 987654321;
				
				//맵 전체에서 궁수 기준 최단거리 찾기
				for(int i = 1; i <= N; i++) {
					for(int j = 1; j <= M; j++) {
						if(map[i][j] == 1) { //적일경우
							int dist = distance(i, N+1, j, archerY);
							if(minD >= dist) {
								//최소거리보다 더 짧을때
								if(minD > dist) {
									minD = dist;
									minX = i;
									minY = j;
								}
								//최소거리랑 같을때 y위치 더 작은쪽(즉 왼쪽)
								else {
									if(minY > j) {
										minX = i;
										minY = j;
									}
								}
							}
						}
					}
				}
				
				//최소거리가 D보다 작으면 킬 표시해준다.
				if(minD <= D) {
					kill[minX][minY] = true;
				}
			}
			
			//적 죽이면 없애준다 map에서
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					if(kill[i][j]) {
						map[i][j] = 0;
						res++;
					}
				}
			}
			
			//맨 아랫줄은 삭제
			for(int i = 1; i <= M; i++) {
				map[N][i] = 0;
			}
			
			//3. 적이 없으면 종료 or 적들 한칸 아래로 이동(범위 벗어나면 종료)
			for(int i = N; i >= 1; i--) {
				for(int j = 1; j <= M; j++) {
					map[i][j] = map[i-1][j];
				}
			}
		}

		result = Math.max(result, res);
	}
	
	static int distance(int x1, int x2, int y1, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
	static void init() {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				map[i][j] = copy[i][j];
			}
		}
	}
	
}
