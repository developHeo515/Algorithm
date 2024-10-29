import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	static int[] arr;
	static StringBuilder sb;
	static boolean[] visited;
	static int n;
	static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        sb = new StringBuilder();
        visited = new boolean[n+1];
        arr = new int[m];
        
        dfs(0);
        
        System.out.println(sb);
    }
    
    static void dfs(int depth) {
    	
    	if(depth == m) {
    		for(int n : arr) {
    			sb.append(n).append(" ");
    		}
    		sb.append("\n");
    		
    		return;
    	}
    	
    	for(int i=1; i<=n; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			
    			arr[depth] = i;
    			dfs(depth+1);
    			
    			visited[i] = false;
    		}
    	}
    }
}