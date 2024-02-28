package jinseok;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 브루트포스_주사위쌓기 {

	static int T, max, sum, result;
	static int[][] dice;
	static int[] path = { 5, 3, 4, 1, 2, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		dice = new int[T][6];

		for (int index = 0; index < T; index++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int row = 0; row < 6; row++) {

				dice[index][row] = Integer.parseInt(st.nextToken());

			}

		}

		result = 0;

		for (int i = 0; i < 6; i++) {

			max = 0;
			sum = 0;

			int start = dice[0][i];

			for (int j = 0; j < 6; j++) {
				if (j != i) {
					max = dice[0][j] > max ? dice[0][j] : max;
				}
			}

			sum += max;

			for (int j = 1; j < T; j++) {

				int top = -1;
				int down = -1;
				max = 0;

				for (int k = 0; k < 6; k++) {

					if (i == 0 && dice[j][k] == start) {
						top = k;
						down = path[top];
					}
					
					if (dice[j][k] == top) {
						top = k;
						down = path[top];
					}

				}

				for (int k = 0; k < 6; k++) {

					if (dice[j][k] != dice[j][top] && dice[j][k] != dice[j][down]) {

						max = dice[j][k] > max ? dice[j][k] : max;

					}

				}

				sum += max;

			}

			result = sum > result ? sum : result;

		}

		System.out.println(result);
	}

}
