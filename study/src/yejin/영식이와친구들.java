package yejin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영식이와친구들 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 값 입력
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		// 사람 배열
		int[] nArr = new int[N];

		// 공을 받을 사람으 인덱스
		int bIdx = 0;

		// 공을 총 몇 번 주고 받은건지 카운트
		int count = 0;

		// 공을 M번 받게될 경우 종료하게 될 while문
		while (true) {

			// 공을 받은 사람의 값을 하나 증가
			nArr[bIdx]++;

			// end point 확인
			if (nArr[bIdx] == M) {
				break;
			}

			// 짝수이면
			if (nArr[bIdx] % 2 == 0) {
				// L만큼 더한다 (시계)
				bIdx += L;
				// 만약 인덱스 범위를 넘어가면 N을 빼주어 해당 위치로 넘어가게 계산
				while (bIdx >= N) {
					bIdx -= N;
				}
				// 홀수이면
			} else {
				// L만큼 뺀다 (반시계)
				bIdx -= L;
				// 만약 인덱스 범위를 넘어가면 N을 더해 해당 위치로 넘어가게 계산
				while (bIdx < 0) {
					bIdx += N;
				}
			}

			// 공을 주고받은 횟수 카운팅
			count++;

		}
		// 결과 출력
		System.out.println(count);
	}
}
