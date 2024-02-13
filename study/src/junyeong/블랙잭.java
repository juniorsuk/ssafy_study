package swea;

import java.util.Scanner;

public class N2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		// 카드 숫자 저장용 배열 선언 및 저장
		int[] cards = new int[n];
		for (int i = 0; i<n; i++) cards[i] = sc.nextInt();
		// 최댓값 저장용 int형 변수 선언
		int maxsum = 0;
		// 3장으로 나올 수 있는 모든 조합 실행
		for (int i = 0; i<n-2; i++) {
			for (int j = i+1; j<n-1; j++) {
				for (int k = j+1; k<n; k++) {
					int imax = cards[i]+cards[j]+cards[k];
					if (imax > m) continue;
					maxsum = Math.max(maxsum, imax);
				}
			}
		}
		System.out.println(maxsum);
		sc.close();
	}
}
