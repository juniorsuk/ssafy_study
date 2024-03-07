package yejin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_2941_크로아티아알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문장 입력받기
		String str = br.readLine();

		// 크로아티아 알파벳 수를 담을 변수
		int wordCount = 0;

		// 해당 문자가 변경되는 길이만큼 s를 건너뜀
		for (int s = 0; s < str.length(); s++) {

			char c = str.charAt(s);
			if (c == 'd') {
				// 경계조건 안에 있으면서, dz= 인 경우
				if (s < str.length() - 2 && str.charAt(s + 1) == 'z' && str.charAt(s + 2) == '=') {
					// 총 3글자가 크로아티아 알파벳 1개
					s += 2;

				} else if (s < str.length() - 1 && str.charAt(s+1) == '-') {
					// 총 2글자가 크로아티아 알파벳 1개
					s++;
				}

			} else if (c == 's' || c == 'z') {
				// 총 2글자가 크로아티아 알파벳 1개
				if (s < str.length() - 1 && str.charAt(s + 1) == '=') {
					s++;
				}
			} else if (c == 'c') {
				// 총 2글자가 크로아티아 알파벳 1개
				if (s < str.length() - 1 && (str.charAt(s + 1) == '=' || str.charAt(s + 1) == '-')) {
					s++;
				}
			} else if (c == 'l') {
				// 총 2글자가 크로아티아 알파벳 1개
				if (s < str.length() - 1 && str.charAt(s + 1) == 'j') {
					s++;
				}
			} else if (c == 'n') {
				// 총 2글자가 크로아티아 알파벳 1개
				if (s < str.length() - 1 && str.charAt(s + 1) == 'j') {
					s++;
				}
			}
			// 단어 수 하나 증가
			wordCount++;
		}

		System.out.println(wordCount);

	}
}
