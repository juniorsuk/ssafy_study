package yejin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 딱지놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 뭔가 배열로 풀고싶지 않아서 그냥 해봄..ㅋ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스 입력
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			// a b가 입력한 숫자 하나씩 받아올 변수
			int a;
			int b;

			// 정수 총합 담을 변수
			long aSum = 0;
			long bSum = 0;

			StringTokenizer aStr = new StringTokenizer(br.readLine());
			StringTokenizer bStr = new StringTokenizer(br.readLine());

			int aLen = Integer.parseInt(aStr.nextToken());
			int bLen = Integer.parseInt(bStr.nextToken());

			for (int i = 0; i < aLen; i++) {
				a = Integer.parseInt(aStr.nextToken());
				if (a == 1) {
					aSum += 1;
				} else if (a == 2) {
					aSum += 1000;
				} else if (a == 3) {
					aSum += 1000000;
				} else {
					aSum += 1000000000;
				}
			}

			for (int k = 0; k < bLen; k++) {
				b = Integer.parseInt(bStr.nextToken());
				if (b == 1) {
					bSum += 1;
				} else if (b == 2) {
					bSum += 1000;
				} else if (b == 3) {
					bSum += 1000000;
				} else {
					bSum += 1000000000;
				}

			}

			if (aSum > bSum) {
				System.out.println("A");
			} else if (bSum > aSum) {
				System.out.println("B");
			} else {
				System.out.println("D");
			}

		}
	}
}
