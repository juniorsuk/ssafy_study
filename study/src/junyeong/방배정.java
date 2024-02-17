import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 학생 수 담기 위한 2 X 7 배열 선언
		int[][] rooms = new int[2][7];
		int n = sc.nextInt();
		int k = sc.nextInt();
		int ans = 0;
		for (int i = 0; i<n; i++) {
			int gen = sc.nextInt();
			int gra = sc.nextInt();
			rooms[gen][gra]++;
			if (rooms[gen][gra] == k) {
				ans++;
				rooms[gen][gra] = 0;
			}
		}
		for (int i = 0; i<2; i++) {
			for (int j = 0; j<7; j++) {
				if (rooms[i][j] > 0) ans++; 
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
