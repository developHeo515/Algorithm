//BOJ4949 균형잡힌 세상
//스택 문제
import java.io.*;
import java.util.*;

public class Main {
	static Stack<Character> stack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		
		while(true) {
			if(str.equals(".")) {
				break;
			}else {
				stack = new Stack();
				boolean flag = true;
				
				for(int i = 0; i < str.length(); i++) {
//					System.out.print(str.charAt(i));
					if(str.charAt(i) == '(') {
						stack.add('(');
					}
					else if(str.charAt(i) == '[') {
						stack.add('[');
					}
					else if(str.charAt(i) == ')') {
						if(stack.isEmpty()) {
							flag = false;
						}
						else if(stack.pop() != '(') {
							flag = false;							
						}
					}
					else if(str.charAt(i) == ']') {
						if(stack.isEmpty()) {
							flag = false;
						}
						else if(stack.pop() != '[')
							flag = false;
					}
				}
				
				if(!stack.isEmpty()) {
					flag = false;
				}
				if(flag) {
					bw.write("yes" + "\n");
				}
				else {
					bw.write("no" + "\n");
				}
			}
			str = br.readLine();
//			System.out.println();
		}

		
		bw.flush();
		bw.close();
		br.close();
	}
}
