package yejin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_2851_슈퍼마리오 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 값 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] numArr = new int[10];
		for (int i = 0; i < 10; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}

		// 정답 값 출력할 변수
		int num = 0;

		// 배열 순회
		for (int i = 0; i < 10; i++) {
			// 처음부터 더하다가
			num += numArr[i];

			// 만약 100을 넘었을 경우 종료
			if (num > 100) {

				// 100을 넘은 현재와 그 전을 고려하여 차이가 더 작은 값을 출력
				// 만약 차이가 같다면 현재 값을 출력하도록 부등호 설정
				if (100 - (num - numArr[i]) < num - 100) {
					num -= numArr[i];
				}

				break;
			}
		}

		// 출력
		System.out.println(num);

	}
}
