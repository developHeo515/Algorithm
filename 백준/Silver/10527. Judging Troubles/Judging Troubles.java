import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	static int result = 0;
	static ArrayList<String>[] list = new ArrayList[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());

		list[0] = new ArrayList<>();
		list[1] = new ArrayList<>();

		for (int index = 0; index < 2; index++) {
			for (int i = 0; i < size; i++) {
				list[index].add(br.readLine());
			}
		}

		Collections.sort(list[0]);
		Collections.sort(list[1]);

		int left = 0, right = 0;
		while (left < size && right < size) {
			if (list[0].get(left).equals(list[1].get(right))) {
				result++;
				left++;
				right++;
			} else if (list[0].get(left).compareTo(list[1].get(right)) < 0) {
				left++;
			} else {
				right++;
			}
		}
		System.out.println(result);

	}
}

