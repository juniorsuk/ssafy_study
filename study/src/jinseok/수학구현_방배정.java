package jinseok;

import java.util.Scanner;

public class 수학구현_방배정 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 학생 수
		int N = sc.nextInt();

		// 최대 인원 수
		int K = sc.nextInt();

		// 성별, 학년
		int[][] 전교생 = new int[2][6];

		for (int i = 0; i < N; i++) {
			int 성별 = sc.nextInt();
			int 학년 = sc.nextInt();

			전교생[성별][학년 - 1]++;
		}

		int count = 0;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				count += 전교생[i][j] / K;

				if (전교생[i][j] % K != 0) {
					count++;
				}
			}

		}

		System.out.println(count);
		sc.close();

	}

}
