package j20240401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 톱니바퀴 {
	public static int[] r = {0, 0, 0, 0};	
	
	public static class Gear{
		public int[] nums;
		Gear(){}
		public int right(int ri) {
			return nums[(r[ri]+2)%8];
		}
		public int left(int ri) {
			return nums[(r[ri]+6)%8];
		}
		public boolean score(int ri) {
			if (nums[r[ri]] == 1) return true;
			else return false;
		}
	}
	
	public static Gear[] gears = new Gear[4];
	public static boolean[] chk;
	
	public static void Rotate(int n, int d) {
		chk[n] = true;
		if (n>0 && !chk[n-1] && gears[n].left(n) != gears[n-1].right(n-1)) Rotate(n-1, -d);
		if (n<3 && !chk[n+1] && gears[n].right(n) != gears[n+1].left(n+1)) Rotate(n+1, -d);
		r[n] += d;
		if (r[n] < 0) r[n] += 8;
		if (r[n] >= 8) r[n] -= 8;
		return;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gears = new Gear[4];
		for (int i = 0; i<4; i++) {
			gears[i] = new Gear();
			String now = br.readLine();
			int[] nownum = new int[8];
			for (int j = 0; j<8; j++) {
				if (now.charAt(j) == '1') nownum[j] |= 1<<0;
			}
			gears[i].nums = nownum;
		}
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i<k; i++) {
			chk = new boolean[4];
			String[] nd = br.readLine().split(" ");
			int n = Integer.parseInt(nd[0])-1;
			int d = Integer.parseInt(nd[1]);
			Rotate(n, -d);
		}
		int ans = 0;
		for (int i = 0; i<4; i++) {
			if (gears[i].score(i)) ans += 1<<i;
		}
		System.out.println(ans);
	}
}
