package yejin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_2999_비밀이메일 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문자열 입력
		String str = br.readLine();
		// 길이 저장
		int N = str.length();

		// r과 c찾기
		int r;
		int c = N;

		// 루트 계산(R<=C 조건)해서 거기부터 0까지 순회하며 r값을 찾는다.
		r = (int) Math.sqrt(N);
		for (int i = r; i >= 1; i--) {
			if (N % i == 0) { // R*C=N을 찾기 위한 조건
				r = i;
				c = N / r;
				break;
			}
		}

		// r과 c교환
		int tmp = r;
		r = c;
		c = tmp;
		
		//열우선순회
		String ansStr = "";
		for (int cc = 0; cc < c; cc++) {
			for (int rr = 0; rr < r; rr++) {
				ansStr += str.charAt(rr * c + cc);
			}
		}

		System.out.println(ansStr);

	}
}
