
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap<Integer, int[]> directions;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static List<Integer> save;
    static final int END = 5;
    static int N;
    static int[][] map;
    static int[][] copy;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        copy = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                copy[i][j] = map[i][j];
            }
        }

        save = new ArrayList<>();
        directions = new HashMap<>();
        for(int i=0; i<4; i++){
            directions.put(i, new int[]{dr[i], dc[i]});
        }

        result = 0;
        permutation(0);

        System.out.println(result);
    }

    static void permutation(int depth){
        if(depth == END){
            game();
            return;
        }

        for(int i=0; i<4; i++){
            save.add(depth, i);
            permutation(depth+1);
            save.remove(depth);
        }
    }

    static void game(){
        for(int i=0; i<save.size(); i++){
            int dir = save.get(i);
            move(dir);
        }

        initMap();
    }

    static void move(int dir){
        if(dir == 2){
            //System.out.println("debug");
        }
        switch (dir){
            case 0:
                moveRight();
                break;
            case 1:
                moveDown();
                break;
            case 2:
                moveLeft();
                break;
            case 3:
                moveUp();
                break;
        }

        updateResult();
    }

    static void initMap(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = copy[i][j];
            }
        }
    }

    static void updateResult(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                result = Math.max(result, map[i][j]);
            }
        }
    }

    static void moveUp(){
        for(int i=0; i<N; i++){
            Stack<Integer> stack = new Stack<>();

            for(int j=0; j<N; j++){
                if(map[j][i]!=0){
                    stack.push(map[j][i]);
                    map[j][i] = 0;
                }
            }

            if(stack.isEmpty())continue;

            //숫자 재배치
            for(int j=0; j<N; j++){
                if(stack.isEmpty())break;
                int fore = stack.pop();

                if(stack.isEmpty()){
                    map[j][i] = fore;
                    break;
                }

                int next = stack.peek();

                if(fore == next){
                    stack.pop();
                    map[j][i] = fore+next;
                    continue;
                }

                //다를 경우
                map[j][i] = fore;
            }
        }
    }

    static void moveDown(){
        for(int i=0; i<N; i++){
            Stack<Integer> stack = new Stack<>();

            for(int j=N-1; j>=0; j--){
                if(map[j][i]!=0){
                    stack.push(map[j][i]);
                    map[j][i] = 0;
                }
            }

            if(stack.isEmpty())continue;

            //숫자 재배치
            for(int j=N-1; j>=0; j--){
                if(stack.isEmpty())break;
                int fore = stack.pop();

                if(stack.isEmpty()){
                    map[j][i] = fore;
                    break;
                }

                int next = stack.peek();

                if(fore == next){
                    stack.pop();
                    map[j][i] = fore+next;
                    continue;
                }

                //다를 경우
                map[j][i] = fore;
            }
        }
    }

    static void moveRight(){
        for(int i=0; i<N; i++){
            Stack<Integer> stack = new Stack<>();

            //모든 숫자 스택에 저장
            for(int j=N-1; j>=0; j--){
                if(map[i][j]!=0){
                    stack.push(map[i][j]);
                    map[i][j] = 0;
                }
            }

            if(stack.isEmpty())continue;

            //숫자 재배치
            for(int j=N-1; j>=0; j--){
                if(stack.isEmpty())break;
                int fore = stack.pop();

                if(stack.isEmpty()){
                    map[i][j] = fore;
                    break;
                }

                int next = stack.peek();

                if(fore == next){
                    stack.pop();
                    map[i][j] = fore+next;
                    continue;
                }

                //다를 경우
                map[i][j] = fore;
            }
        }
    }

    static void moveLeft(){
        for(int i=0; i<N; i++){
            Stack<Integer> stack = new Stack<>();

            //모든 숫자 스택에 저장
            for(int j=0; j<N; j++){
                if(map[i][j]!=0){
                    stack.push(map[i][j]);
                    map[i][j] = 0;
                }
            }

            if(stack.isEmpty())continue;

            //숫자 재배치
            for(int j=0; j<N; j++){
                if(stack.isEmpty())break;
                int fore = stack.pop();

                //스택에 수가 없을 경우
                if(stack.isEmpty()){
                    map[i][j] = fore;
                    break;
                }

                int next = stack.peek();

                //같은 수가 있을 경우
                if(fore==next){
                    stack.pop();
                    map[i][j] = fore+next;
                    continue;
                }

                //다를 경우
                map[i][j] = fore;
            }
        }
    }
}
