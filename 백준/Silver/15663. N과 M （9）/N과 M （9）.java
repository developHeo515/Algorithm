import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static Integer[] input;
	static Integer[] res;
	static boolean[] toSelected;
	static LinkedHashSet<String> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new Integer[N];
		res = new Integer[M];
		toSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		set  = new LinkedHashSet<>();
//		Arrays.sort(input, Collections.reverseOrder());
//		System.out.println(Arrays.toString(input));
		
		dfs(0);
//		System.out.println(set);
		set.forEach(System.out::println);
	}
	static void dfs(int depth) {
		if(depth == M) {
			String temp = "";
			for(Integer num : res) {
				temp += num+" ";
			}
			set.add(temp);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!toSelected[i]) {
				toSelected[i] = true;
				res[depth] = input[i];
				dfs(depth+1);
				toSelected[i] = false;
			}
			
		}
		
	}
}




