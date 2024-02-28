package jinseok;

import java.io.*;
import java.util.StringTokenizer;

public class 구현_색종이 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(reader.readLine());
		boolean[][] paper = new boolean[100][100];

		for (int k = 0; k < N; k++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 이미 덮혀진곳은 true로 표시
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					paper[i][j] = true;
				}
			}
		}

		int area = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				// true이면 area 증가
				if (paper[i][j]) {
					area++;
				}
			}
		}

		writer.write(String.valueOf(area));

		writer.flush();
		writer.close();
		reader.close();
	}
}
