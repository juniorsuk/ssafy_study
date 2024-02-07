package jinseok;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 딱지놀이 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int A_num = Integer.parseInt(st.nextToken());

			int[] A_Cards = new int[A_num];
			int[] A_Count = new int[5];

			for (int j = 0; j < A_num; j++) {

				A_Cards[j] = Integer.parseInt(st.nextToken());

			}

			for (int j = 1; j <= 4; j++) {

				for (int k = 0; k < A_Cards.length; k++) {
					if (A_Cards[k] == j) {
						A_Count[j]++;
					}
				}
			}

			st = new StringTokenizer(br.readLine());

			int B_num = Integer.parseInt(st.nextToken());

			int[] B_Cards = new int[B_num];
			int[] B_Count = new int[5];

			for (int j = 0; j < B_num; j++) {

				B_Cards[j] = Integer.parseInt(st.nextToken());

			}

			for (int j = 1; j <= 4; j++) {

				for (int k = 0; k < B_Cards.length; k++) {
					if (B_Cards[k] == j) {
						B_Count[j]++;
					}
				}
			}

			for (int j = 4; j > 0; j--) {
				if (A_Count[j] > B_Count[j]) {
					System.out.println('A');
					break;
				} else if (A_Count[j] < B_Count[j]) {
					System.out.println('B');
					break;
				} else if (A_Count[j] == B_Count[j]) {
					if (j == 1) {
						System.out.println('D');
						break;
					} else {
						continue;
					}
				}
			}

		}

	}

}
