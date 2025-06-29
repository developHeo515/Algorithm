import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = "";
		while (true) {
			str = sc.nextLine();

			if (str.equals("END")) {
				break;
			}

			String[] arr = str.split(""); 
			for (int i = arr.length - 1; i >= 0; i--) { 
				System.out.print(arr[i]);
			}
			System.out.println();

		}

		sc.close();
	}

}