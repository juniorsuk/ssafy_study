package yejin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Back_2116_주사위쌓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		//값 입력
		int[][] num = new int[N][6];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int s = 0; s < 6; s++) {
				num[n][s] = Integer.parseInt(st.nextToken());
			}
		}
		// 델타배열
		int[] up = { 0, 1, 2, 4, 3, 5 };
		int[] down = { 5, 3, 4, 2, 1, 0 };
		// 반대편 찾아줄 map
		Map<Integer, Integer> findpair = new HashMap<>();
		findpair.put(0, 5);
		findpair.put(1, 3);
		findpair.put(2, 4);
		findpair.put(3, 1);
		findpair.put(4, 2);
		findpair.put(5, 0);

		int downIdx = 0;
		int upIdx = 0;
		int downNum = 0;
		int upNum = 0;
		int tmpAns;
		// 정답 담을 변수
		int max = 0;

		for (int n = 0; n < 6; n++) {
			// 주사위 각 면의 초기값은 6으로 생각
			tmpAns = 6 * N;
			// 델타배열 돌면서 주사위 맞은편 순회
			upIdx = up[n];
			downIdx = down[n];
			// 주사위 위 숫자와 아래 숫자 초기화
			upNum = num[0][upIdx];
			downNum = num[0][downIdx];
			// 6이나 5가 있는지 검사
			if (upNum == 6 || downNum == 6) {
				tmpAns--;
				if (downNum == 5 || upNum == 5) {
					tmpAns--;
				}
			}
			// 주사위 한층한층 순회
			for (int i = 1; i < N; i++) {
				// 주사위 수 담긴 배열 순회
				for (int j = 0; j < 6; j++) {
					// 현재주사위의 위 숫자와 같은 수를 다음 주사위에서 찾는다
					if (num[i][j] == upNum) {
						// 찾은 인덱스를 아래 숫자의 인덱스로 바꾼다
						// 주사위를 한 칸 올려서 생각한다
						downIdx = j;
						downNum = upNum;
						// 맵 함수에서 키 값을 검색하여 페어를 이루는 반대편 값을 찾아온다
						// 그 값을 위 숫자로 초기화한다
						upIdx = findpair.get(j);
						upNum = num[i][upIdx];
						// 6이나 5가 있는지 검사
						if (upNum == 6 || downNum == 6) {
							tmpAns--;
							if (downNum == 5 || upNum == 5) {
								tmpAns--;
							}
						}
						break;
					}
				}
			}

			if (tmpAns > max) {
				max = tmpAns;
			}

		}
		System.out.println(max);


	}
}
