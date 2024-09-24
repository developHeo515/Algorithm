import java.io.*;
import java.util.*;

public class Main {
    static class TreeNode implements Comparable<TreeNode> {
        int x;
        int y;
        int age;

        public TreeNode(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(TreeNode o) {
            return this.age - o.age; // 나이 순 정렬
        }
    }

    static int N, M, K, cnt;
    static int[][] A;   // 겨울에 더할 양분
    static int[][] land; // 현재 양분 상태
    static ArrayList<TreeNode> trees; // 나무들
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; // 인접 8개 칸
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N + 1][N + 1]; // 겨울에 주는 양분 정보
        land = new int[N + 1][N + 1]; // 현재 땅의 양분 상태
        trees = new ArrayList<>(); // 나무 정보

        // 겨울에 추가되는 양분 정보
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                land[i][j] = 5; // 초기 양분은 5
            }
        }

        // 나무 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            trees.add(new TreeNode(x, y, age));
        }

        // 나무 나이 기준으로 오름차순 정렬
        Collections.sort(trees);

        // 시뮬레이션 진행
        for (int year = 1; year <= K; year++) {
            springAndSummer();
            fall();
            winter();
        }

        // 나무의 개수를 출력
        bw.write(trees.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void springAndSummer() {
        ArrayList<TreeNode> alive = new ArrayList<>();
        ArrayList<TreeNode> dead = new ArrayList<>();

        // 봄: 나무가 자신의 나이만큼 양분을 먹고, 나이가 증가한다.
        // 양분을 먹지 못한 나무는 죽고, 그 나무는 죽은 나무 리스트로 이동
        for (TreeNode tree : trees) {
            if (land[tree.x][tree.y] >= tree.age) {
                land[tree.x][tree.y] -= tree.age;
                tree.age++;
                alive.add(tree); // 양분을 먹은 나무는 살아남음
            } else {
                dead.add(tree); // 양분을 먹지 못한 나무는 죽음
            }
        }

        // 여름: 죽은 나무가 양분이 된다.
        for (TreeNode tree : dead) {
            land[tree.x][tree.y] += tree.age / 2;
        }

        trees = alive; // 살아남은 나무만 유지
    }

    static void fall() {
        ArrayList<TreeNode> newTrees = new ArrayList<>();
        
        for (TreeNode tree : trees) {
            if (tree.age % 5 == 0) { // 나이가 5의 배수인 나무는 번식
                for (int i = 0; i < 8; i++) {
                    int nx = tree.x + dx[i];
                    int ny = tree.y + dy[i];
                    if (nx >= 1 && ny >= 1 && nx <= N && ny <= N) {
                        newTrees.add(new TreeNode(nx, ny, 1)); // 나이 1의 나무 생성
                    }
                }
            }
        }
        trees.addAll(0, newTrees); // 새로운 나무들을 리스트 앞에 추가
    }

    static void winter() {
        // 겨울: 각 칸에 추가 양분을 더한다.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                land[i][j] += A[i][j];
            }
        }
    }
}
