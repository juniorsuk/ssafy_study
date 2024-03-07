package yejin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Back_3052_나머지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 중복 검사를 위하 set
		Set<Integer> num = new HashSet<>();

		for (int i = 0; i < 10; i++) {
			// 값 입력받아서
			int N = Integer.parseInt(br.readLine());
			// num 조합에 추가
			num.add(N % 42);
		}

		System.out.println(num.size());
	}
}
