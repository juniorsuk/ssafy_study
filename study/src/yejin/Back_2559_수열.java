package yejin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2559_수열 {
	public static void main(String[] args) throws IOException {

		// 값 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 날짜별 온도 담을 배열
		int[] dayTemp = new int[N];

		// 시작 날짜를 하루씩 증가하며 K개만큼 더하기
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			dayTemp[n] = Integer.parseInt(st.nextToken());
		}

		// 최대 합을 담을 변수
		int max = Integer.MIN_VALUE;
		for (int n = 0; n <= N - K; n++) {
			int sum = 0;
			for (int k = n; k < n + K; k++) {
				sum += dayTemp[k];
			}
			// 현재 sum이 최대값보다 크면 변경
			if (sum > max) {
				max = sum;
			}
		}

		// 출력
		System.out.println(max);
	}
}
