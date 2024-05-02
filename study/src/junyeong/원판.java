import java.io.*;
import java.util.*;

public class 원판 {
	public static int n;
	public static int m;
	public static int t;
	public static boolean[][] chk;
	public static boolean c;
	public static wheel[] ws;
	
	public static class wheel {
		private int[] nums;
		
		
		public wheel() {}
		public wheel(int[] nums) {
			this.nums = nums;
		}
		
		public int[] getNums() {
			return nums;
		}
		public void setNums(int[] nums) {
			this.nums = nums;
		}
	}
	
	public static void dfs(int w, int g, int del) {
//		System.out.println(w+" "+g);
		int ag = g+1;
		if (ag == m) ag = 0;
		if (!chk[w][ag] && ws[w].getNums()[ag] == del) {
			c = true;
			chk[w][g] = true;
			chk[w][ag] = true;
			dfs(w, ag, del);
		}
		ag = g-1;
		if (ag == -1) ag = m-1;
		if (!chk[w][ag] && ws[w].getNums()[ag] == del) {
			c = true;
			chk[w][g] = true;
			chk[w][ag] = true;
			dfs(w, ag, del);
		}
		int aw = w+1;
		if (aw<n && !chk[aw][g] && ws[aw].getNums()[g] == del) {
			c = true;
			chk[w][g] = true;
			chk[aw][g] = true;
			dfs(aw, g, del);
		}		
		aw = w-1;
		if (aw>=0 && !chk[aw][g] && ws[aw].getNums()[g] == del) {
			c = true;
			chk[w][g] = true;
			chk[aw][g] = true;
			dfs(aw, g, del);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nmt = br.readLine().split(" ");
		n = Integer.parseInt(nmt[0]);
		m = Integer.parseInt(nmt[1]);
		t = Integer.parseInt(nmt[2]);
		ws = new wheel[n];
		for (int i = 0; i<n; i++) {
			String[] ns = br.readLine().split(" ");
			int[] ai = new int[m];
			for (int j = 0; j<m; j++) ai[j] = Integer.parseInt(ns[j]);
			ws[i] = new wheel(ai);
		}
		for (int i = 0; i<t; i++) {
			chk = new boolean[n][m];
			String[] xdk = br.readLine().split(" ");
			int x = Integer.parseInt(xdk[0]);
			int d = Integer.parseInt(xdk[1]);
			int k = Integer.parseInt(xdk[2]);
			if (d == 0) {				
				for (int j = x-1; j<n; j+=x) {
					int[] bf = ws[j].getNums();
					int[] af = new int[m];
					for (int r = 0; r<m; r++) {
						af[(r+k)%m] = bf[r];
					}
					ws[j].setNums(af);
				}
			}
			else {
				for (int j = x-1; j<n; j+=x) {
					int[] bf = ws[j].getNums();
					int[] af = new int[m];
					for (int r = 0; r<m; r++) {
						int ar = r-k;
						if (ar < 0) ar += m;
						af[ar] = bf[r];
					}
					ws[j].setNums(af);
				}
			}

			double sum = 0;
			double cnt = 0;
			c = false;
			for (int j = 0; j<n; j++) {
				for (int h = 0; h<m; h++) {
					if (ws[j].getNums()[h] > 0) {
//						System.out.println(Arrays.deepToString(chk));
						sum += ws[j].getNums()[h];
//						System.out.println(ws[j].getNums()[h]);
						cnt++;
						dfs(j, h, ws[j].getNums()[h]);
					}
				}
			}
			if (c) {
				for (int j = 0; j<n; j++) {
					for (int h = 0; h<m; h++) {
						if (chk[j][h]) {
							int[] tmp = new int[m];
							for (int idx = 0; idx<m; idx++) {
								tmp[idx] = ws[j].getNums()[idx];
							}
							tmp[h] = 0;
							ws[j].setNums(tmp);
						}
					}
//					System.out.println(Arrays.toString(ws[j].getNums()));
				}
			}
			else {
				double avg = sum/cnt;
				for (int j = 0; j<n; j++) {
					for (int h = 0; h<m; h++) {
						if (ws[j].getNums()[h] == 0) continue;
						if (ws[j].getNums()[h] > avg) ws[j].getNums()[h]--;
						else if (ws[j].getNums()[h] < avg) ws[j].getNums()[h]++;
					}
//					System.out.println(Arrays.toString(ws[j].getNums()));
				}
			}
//			System.out.println(Arrays.deepToString(chk));
		}
		int ans = 0;
		for (int j = 0; j<n; j++) {
			for (int h = 0; h<m; h++) {
//				System.out.println(ws[j].getNums()[h]);
				ans += ws[j].getNums()[h];
			}
		}
		System.out.println(ans);
//		System.out.println(Arrays.deepToString(chk));
	}
}
