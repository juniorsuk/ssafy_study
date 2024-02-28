import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] bx = new int[n];
		int[] by = new int[n];
		for (int i = 0; i<n; i++) {
			bx[i] = sc.nextInt();
			by[i] = sc.nextInt();
		}
		int maxx = 0;
		int maxy = 0;
		for (int i : bx) maxx = Math.max(maxx, i);
		for (int i : by) maxy = Math.max(maxy, i);
		int[] bldg = new int[maxx+1];
		for (int i = 0; i<n; i++) bldg[bx[i]] = by[i];
		int front = 0;
		int rear = 0;
		int area = 0;
		int fi = 0;
		int ri = maxx;
		while (true) {
			if (front < bldg[fi]) front = bldg[fi];
			if (rear < bldg[ri]) rear = bldg[ri];
			if (maxy != bldg[fi]) area += front;
			if (maxy != bldg[ri]) area += rear;
			if (ri-fi>1 && front == maxy && rear == maxy) {
				area += front*(ri-fi+1);
				break;
			}
			if (ri==fi) {
				area += rear;
				break;
			}
			else if (ri-fi == 1) {
				if (front == maxy && rear == maxy) area += 2*maxy;
				else area += maxy;
				break;
			}
			if (maxy != bldg[fi]) fi++;
			if (maxy != bldg[ri]) ri--;
		}
		System.out.println(area);
		sc.close();
	}
}
