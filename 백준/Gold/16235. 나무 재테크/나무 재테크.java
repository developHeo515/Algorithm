
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
            return this.age - o.age;
        }
    }

    static int N, M, K, cnt;
    static int[][] A;
    static int[][] land;
    static ArrayList<TreeNode> tree;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N + 1][N + 1];
        land = new int[N + 1][N + 1];
        tree = new ArrayList<>();
        cnt = 0;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                A[i][j] = num;
                land[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            tree.add(new TreeNode(x, y, age));
        }

        investment();

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void investment() {
        for (int year = 1; year <= K; year++) {
            Collections.sort(tree);
            ArrayList<TreeNode> die = new ArrayList<>();
            ArrayList<TreeNode> alive = new ArrayList<>();
            
            //봄
            for (int i = 0; i < tree.size(); i++) {
                TreeNode cur = tree.get(i);
                int mapX = cur.x;
                int mapY = cur.y;
                if (cur.age <= land[mapX][mapY]) {
                    land[mapX][mapY] -= cur.age;
                    cur.age += 1;
                    alive.add(cur);
                } else {
                    die.add(cur);
                }
            }
            tree = alive;

            //여름
            for (int i = 0; i < die.size(); i++) {
                TreeNode dieTree = die.get(i);
                int dieNum = dieTree.age / 2;
                int dieX = dieTree.x;
                int dieY = dieTree.y;
                land[dieX][dieY] += dieNum;
            }

            //가을
            for (int i = 0; i < tree.size(); i++) {
                TreeNode cur = tree.get(i);
                if (cur.age % 5 == 0) {
                    int curX = cur.x;
                    int curY = cur.y;
                    for (int dic = 0; dic < 8; dic++) {
                        int nextX = curX + dx[dic];
                        int nextY = curY + dy[dic];
                        if (nextX <= 0 || nextY <= 0 || nextX > N || nextY > N) continue;
                        tree.add(new TreeNode(nextX, nextY, 1));
                    }
                }
            }

            //겨울
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    land[i][j] += A[i][j];
                }
            }
        }
        cnt = tree.size();
    }
    


}