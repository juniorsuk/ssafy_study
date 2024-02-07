import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rds = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		round : for (int r = 0; r<rds; r++) {
			int na = sc.nextInt();
			// a, b 각각 길이 5의 배열 생성 후 4, 3, 2, 1번 인덱스에 카운팅 형식으로 저장 
			int[] a = new int[5];
			for (int i = 0; i<na; i++) a[sc.nextInt()]++;
			int nb = sc.nextInt();
			int[] b = new int[5];
			for (int i = 0; i<nb; i++) b[sc.nextInt()]++;
			// 우선순위 따라 개수 비교 후 승부가 나면 다음 라운드로
			for (int i = 4; i>0; i--) {
				if (a[i]>b[i]) {
					sb.append("A").append("\n");
					continue round;
				}
				else if (a[i]<b[i]) {
					sb.append("B").append("\n");
					continue round;
				}
			}
			// 무승부
			sb.append("D").append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
