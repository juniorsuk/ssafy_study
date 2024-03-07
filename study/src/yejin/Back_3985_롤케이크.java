package yejin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_3985_롤케이크 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 값 입력받기
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		// 롤케이크를 먹을 사람을 담을 배열
		int[] rollcake = new int[L];
		// 실제 최대값과 예상 최대값
		int max = 0;
		int predictMax = 0;
		int predictPerson = 0;
		int person = -1;

		// 사람 수만큼 반복하며 값을 입력
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int finish = Integer.parseInt(st.nextToken());
			// 예상 최대값 구하기
			if (finish - start + 1 > predictMax) {
				predictMax = finish - start + 1;
				predictPerson = n;
			}
			// 실제 최대값 구하기
			int cnt = 0;
			for (int s = start - 1; s < finish; s++) {
				// 입력된 값이 없으면, 값을 입력하고 카운트
				if (rollcake[s] == 0) {
					rollcake[s] = n;
					cnt++;
				}
			}
			if (cnt > max) {
				max = cnt;
				person = n;
			}

		}
		// 출력
		System.out.println(predictPerson);
		System.out.println(person);

	}
}
