package jinseok;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 브루트포스_블랙잭 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 카드 개수
		int N = Integer.parseInt(st.nextToken());

		// 카드의 최대 합
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] cards = new int[N];

		for (int i = 0; i < N; i++) {
			// 카드를 배열에 담아서
			cards[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;

		// 브루트포스로 조합
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					if (cards[i] + cards[j] + cards[k] <= M) {
						result = (cards[i] + cards[j] + cards[k]) > result ? (cards[i] + cards[j] + cards[k]) : result;
					}
				}
			}
		}

		System.out.println(result);

	}

}