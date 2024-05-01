package j20240408;

import java.io.*;
import java.util.*;

public class N12100 {
	public static int n;
	public static int[][] brd;
	public static int ans;
	
	public static void left() {
		for (int i = 0; i<n; i++) {
			Queue<Integer> q = new ArrayDeque<>();
			for (int j = 0; j<n; j++) {
				if (brd[i][j]>0) q.offer(brd[i][j]);
			}
			int[] now = new int[n];
			int idx = 0;
			while (!q.isEmpty()) {
				int p = q.poll();
				if (!q.isEmpty() && q.peek() == p) {
					p *= 2;
					q.poll();
				}
				now[idx++] = p;
			}
			brd[i] = now;
		}
	}
	
	public static void right() {
		for (int i = 0; i<n; i++) {
			Queue<Integer> q = new ArrayDeque<>();
			for (int j = n-1; j>=0; j--) {
				if (brd[i][j]>0) q.offer(brd[i][j]);
			}
			int[] now = new int[n];
			int idx = n-1;
			while (!q.isEmpty()) {
				int p = q.poll();
				if (!q.isEmpty() && q.peek() == p) {
					p *= 2;
					q.poll();
				}
				now[idx--] = p;
			}
			brd[i] = now;
		}
	}
	
	public static void up() {
		for (int i = 0; i<n; i++) {
			Queue<Integer> q = new ArrayDeque<>();
			for (int j = 0; j<n; j++) {
				if (brd[j][i]>0) q.offer(brd[j][i]);
			}
			int[] now = new int[n];
			int idx = 0;
			while (!q.isEmpty()) {
				int p = q.poll();
				if (!q.isEmpty() && q.peek() == p) {
					p *= 2;
					q.poll();
				}
				now[idx++] = p;
			}
			for (int j = 0; j<n; j++) {
				brd[j][i] = now[j];
			}
		}
	}
	
	public static void down() {
		for (int i = 0; i<n; i++) {
			Queue<Integer> q = new ArrayDeque<>();
			for (int j = n-1; j>=0; j--) {
				if (brd[j][i]>0) q.offer(brd[j][i]);
			}
			int[] now = new int[n];
			int idx = n-1;
			while (!q.isEmpty()) {
				int p = q.poll();
				if (!q.isEmpty() && q.peek() == p) {
					p *= 2;
					q.poll();
				}
				now[idx--] = p;
			}
			for (int j = n-1; j>=0; j--) {
				brd[j][i] = now[j];
			}
		}
	}
	
	public static int findmax() {
		int ret = 0;
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++) ret = Math.max(ret, brd[i][j]);
		}
		return ret;
	}
	
	public static void combi(int now) {
		if (now == 5) {
			ans = Math.max(ans, findmax());
			return;
		}
		int[][] ori = new int[n][n];
		for (int i = 0; i<n; i++) ori[i] = Arrays.copyOf(brd[i], n);
		right();
		combi(now+1);
		for (int i = 0; i<n; i++) brd[i] = Arrays.copyOf(ori[i], n);
		left();
		combi(now+1);
		for (int i = 0; i<n; i++) brd[i] = Arrays.copyOf(ori[i], n);
		up();
		combi(now+1);
		for (int i = 0; i<n; i++) brd[i] = Arrays.copyOf(ori[i], n);
		down();
		combi(now+1);
		for (int i = 0; i<n; i++) brd[i] = Arrays.copyOf(ori[i], n);
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		brd = new int[n][n];
		for (int i = 0; i<n; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 0; j<n; j++) brd[i][j] = Integer.parseInt(row[j]);
		}
		ans = 0;
		combi(0);
		System.out.println(ans);
	}
}
