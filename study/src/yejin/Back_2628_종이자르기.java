package yejin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_2628_종이자르기 {
	public static void main(String[] args) throws IOException {
		// 가로배열 새로배열을 생성해서 자르는 위치에 1을 넣고 1이 들어가지 않은 부분의 최대 길이를 구한다.

		// 갑 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		// 가로배열 새로배열 생성
		// 실제 입력값대로 값을 넣기 위해 인덱스는 +1
		int[] row = new int[r + 1];
		int[] col = new int[c + 1];

		// 자르는 횟수를 담을 변수
		int cut = Integer.parseInt(br.readLine());

		// 최대값을 담을 변수
		int maxR = 0;
		int maxC = 0;

		for (int i = 0; i < cut; i++) {
			st = new StringTokenizer(br.readLine());

			if (st.nextToken().equals("1")) {
				// 가로로 자를 때
				row[Integer.parseInt(st.nextToken())] = 1;
				continue;
			}
			col[Integer.parseInt(st.nextToken())] = 1;
		}
		// 배열 순회하며 잘리지 않은 최대길이 찾기
		// 0번 인덱스는 건너뜀
		int tmp = 0;// 카운트해줄 변수
		for (int i = 1; i <= r; i++) {
			if (row[i] == 0) {
				tmp++;
				continue;
			}
			tmp++;
			if (tmp > maxR) {
				maxR = tmp;
			}
			tmp = 0;
		}
		// 중간에 0이 안나왔을 경우를 위해 한 번 더
		if (tmp > maxR) {
			maxR = tmp;
			tmp = 0;
		}
		tmp = 0; // tmp초기화
		for (int i = 1; i <= c; i++) {
			if (col[i] == 0) {
				tmp++;
				continue;
			}
			tmp++;
			if (tmp > maxC) {
				maxC = tmp;
			}
			tmp = 0;
		}
		if (tmp > maxC) {
			maxC = tmp;
		}
		System.out.println(maxR * maxC);

	}
}
