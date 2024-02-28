package back_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2798_블랙잭 {

	static int N, M, dis, ans;
	static int[] card;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 갑 입력받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		// 카드배열 생성
		card = new int[N];

		for (int n = 0; n < N; n++) {
			card[n] = Integer.parseInt(st.nextToken());
		}

		// 카드 뽑는 조합 담을 배열
		int[] arr = new int[N];

		// 합과 M의 차이를 구할 변수 dis
		dis = Integer.MAX_VALUE;

		// 정답을 담을 변수
		ans = 0;

		// 조합 찾는 함수 실행
		find(arr, 0, 0);

		// 값 출력
		System.out.println(ans);
	}

	// c, count는 0부터
	static void find(int[] arr, int c, int count) {

		// 만약 합이 M인 카드 조합을 찾았을 경우 리턴
		if (dis == 0) {
			return;
		}

		// 3가지 선택 시 계산
		if (count == 3) {
			calculation(arr);
//			System.out.println(Arrays.toString(arr));
			return;
		}

		// 3가지 선택 조합 생성
		for (int i = c; i < arr.length; i++) {
			arr[i] += 1;
			count++;
			find(arr, i + 1, count);
			arr[i] -= 1;
			count--;
		}

	}

	// 3가지 카드 선택 시 계산
	static void calculation(int[] arr) {
		// 카드 합을 담을 변수
		int sum = 0;
		// 배열 돌면서 선택된 카드 합 구하기
		for (int n = 0; n < N; n++) {
			if (arr[n] == 1) {
				sum += card[n];
			}

			// 만약 합이 M보다 크면 리턴
			if (sum > M) {
				return;
			}
		}

		// M보다 작으면서 제일 큰 값을 찾아서 변경
		if (dis > (M - sum)) {
			dis = M - sum;
			ans = sum;
		}
	}

}
