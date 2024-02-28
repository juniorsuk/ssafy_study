package yejin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_10163_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 값 입력받기
		int N = Integer.parseInt(br.readLine()); // 색종이 수

		int[][] numArr = new int[1001][1001]; // 색종이 올라갈 배열
		int[] paper = new int[N + 1]; // 색종이 보이는 면적 카운트 할 배열

		for (int n = 0; n < N; n++) {
			// 색종이 정보 입력받기
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int rgo = Integer.parseInt(st.nextToken());
			int cgo = Integer.parseInt(st.nextToken());

			// 색종이를 판 위에 올리기
			for (int rr = 0; rr < rgo; rr++) {
				for (int cc = 0; cc < cgo; cc++) {
					numArr[r + rr][c + cc] = n + 1; // 그 색종이의 숫자로 올리기
				}
			}
		}

		// 색종이 넘버로 해당 색종이가 보이는 면적 카운트
		for (int Cr = 0; Cr < 1001; Cr++) {
			for (int Cc = 0; Cc < 1001; Cc++) {
				paper[numArr[Cr][Cc]]++;
			}
		}

		// 출력
		for (int i = 1; i <= N; i++) {
			System.out.println(paper[i]);
		}

	}
}
