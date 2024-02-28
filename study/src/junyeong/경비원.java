import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 가로, 세로 길이 입력
		int h = sc.nextInt();
		int v = sc.nextInt();
		// 상점 정보 입력
		int n = sc.nextInt();
		int[] shops = new int[n+1];
		for (int i = 0; i<=n; i++) {
			int dir = sc.nextInt();
			// 왼쪽 위가 0이고 시계방향으로 증가하는 직사각형 좌표계로 생각
			if (dir == 1) shops[i] = sc.nextInt();
			else if (dir == 2) shops[i] = 2*h+v-sc.nextInt();
			else if (dir == 3) shops[i] = 2*h+2*v-sc.nextInt();
			else shops[i] = h+sc.nextInt();
		}
		int dg = shops[n];
		int distanceSum = 0;
		for (int i = 0; i<=n; i++) {
			int imin = Math.min(shops[i], dg);
			int imax = Math.max(shops[i], dg);
			distanceSum += Math.min(imax-imin, 2*h+2*v+imin-imax);
		}
		System.out.println(distanceSum);
		sc.close();
	}
}
