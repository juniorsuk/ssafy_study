package yejin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2564_경비원 {
	static int[] dong;
	static int[][] Arr;
	static int r, c, place, sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		place = Integer.parseInt(br.readLine());
//		Arr = new int[place+1][5];
		Arr = new int[5][place];

		dong = new int[2];
		for (int i = 0; i < place; i++) {
			st = new StringTokenizer(br.readLine());
			Arr[Integer.parseInt(st.nextToken())][i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		dong[0] = Integer.parseInt(st.nextToken());
		dong[1] = Integer.parseInt(st.nextToken());

		int ans = 0;

		if (dong[0] == 1) {
			// 동근이 북
			dongN();
		} else if (dong[0] == 2) {
			// 동근이 남
			dongS();
		} else if (dong[0] == 3) {
			// 동근이 서
			dongW();
		} else {
			// 동근이 동
			dongE();
		}
		System.out.println(sum);
	}

	static void dongN() {
		for (int s : Arr[2]) {
			if (s == 0)
				continue;
			sum += c;
			if (s + dong[1] < 2 * r - s - dong[1]) {
				sum += s + dong[1];
				continue;
			}
			sum += 2 * r - s - dong[1];
		}
		for (int s : Arr[1]) {
			if (s == 0)
				continue;
			if (s - dong[1] > 0) {
				sum += s - dong[1];
				continue;
			}
			sum += -(s - dong[1]);
		}
		for (int s : Arr[4]) {
			if (s == 0)
				continue;
			sum += r - dong[1] + s;
		}
		for (int s : Arr[3]) {
			if (s == 0)
				continue;
			sum += dong[1] + s;

		}

	}

	static void dongS() {
		for (int s : Arr[1]) {
			if (s == 0)
				continue;
			sum += c;
			if (s + dong[1] < 2 * r - s - dong[1]) {
				sum += s + dong[1];
				continue;
			}
			sum += 2 * r - s - dong[1];
		}
		for (int s : Arr[2]) {
			if (s == 0)
				continue;
			if (s - dong[1] > 0) {
				sum += s - dong[1];
				continue;
			}
			sum += -(s - dong[1]);
		}
		for (int s : Arr[4]) {
			if (s == 0)
				continue;
			sum += r - dong[1] + c - s;
		}
		for (int s : Arr[3]) {
			if (s == 0)
				continue;
			sum += dong[1] + c - s;

		}

	}

	static void dongW() {
		for (int s : Arr[4]) {
			if (s == 0)
				continue;
			sum += r;
			if (s + dong[1] < 2 * c - s - dong[1]) {
				sum += s + dong[1];
				continue;
			}
			sum += 2 * c - s - dong[1];
		}
		for (int s : Arr[3]) {
			if (s == 0)
				continue;
			if (s - dong[1] > 0) {
				sum += s - dong[1];
				continue;
			}
			sum += -(s - dong[1]);
		}
		for (int s : Arr[1]) {
			if (s == 0)
				continue;
			sum += dong[1] + s;
		}
		for (int s : Arr[2]) {
			if (s == 0)
				continue;
			sum += c - dong[1] + s;

		}

	}

	static void dongE() {
		for (int s : Arr[3]) {
			if (s == 0)
				continue;
			sum += r;
			if (s + dong[1] < 2 * c - s - dong[1]) {
				sum += s + dong[1];
				continue;
			}
			sum += 2 * c - s - dong[1];
		}
		for (int s : Arr[4]) {
			if (s == 0)
				continue;
			if (s - dong[1] > 0) {
				sum += s - dong[1];
				continue;
			}
			sum += -(s - dong[1]);
		}
		for (int s : Arr[1]) {
			if (s == 0)
				continue;
			sum += dong[1] + r - s;
		}
		for (int s : Arr[2]) {
			if (s == 0)
				continue;
			sum += c - dong[1] + r - s;

		}

	}

//	static int[] dong;
//	static int[][] placeArr;
//	static int r, c, place;
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		r = Integer.parseInt(st.nextToken());
//		c = Integer.parseInt(st.nextToken());
//
//		place = Integer.parseInt(br.readLine());
//		placeArr = new int[2][place];
//		dong = new int[2];
//		for (int i = 0; i < place; i++) {
//			st = new StringTokenizer(br.readLine());
//			placeArr[0][i] = Integer.parseInt(st.nextToken());
//			placeArr[1][i] = Integer.parseInt(st.nextToken());
//		}
//		st = new StringTokenizer(br.readLine());
//		dong[0] = Integer.parseInt(st.nextToken());
//		dong[1] = Integer.parseInt(st.nextToken());
//
//		int ans = 0;
//
//		if (dong[0] == 1) {
//			// 동근이 북
//		} else if (dong[0] == 2) {
//			// 동근이 남
//		} else if (dong[0] == 3) {
//			// 동근이 서
//			findNS();
//		} else {
//			// 동근이 동
//			findNS();
//		}
//
//		System.out.println(ans);
//	}
//
//	private static void findNS() {
//		if (dong[0] == 3) {
//			for (int i = 0; i < place; i++) {
//				if()
//			
//			}
//		}
//	}

}
