package solving;

import java.util.*;
import java.io.*;

public class 공항 {
	public static int q;
	public static int p;
	public static int ans;
	public static boolean chk;
	public static boolean[] gates;
	public static int[] post;
	
	public static void dock (int n) {
		if (n == 0) {
			chk = false;
			return;
		}
		if (!gates[n]) {
			gates[n] = true;
			int next = n-1;
			while(next>0) {
				if (!gates[next]) {
					post[n] = next;
					break;
				}
				else {
					post[n] = post[next];
					next = post[next];
				}
			}
			ans++;
			return;
		}
		else {
			dock(post[n]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		q = Integer.parseInt(br.readLine());
		p = Integer.parseInt(br.readLine());
		gates = new boolean[q+1];
		post = new int[q+1];
		chk = true;
		for (int i = 0; i<p; i++) {
			int now = Integer.parseInt(br.readLine());
			if (!chk) continue;
			dock(now);
		}
		System.out.println(ans);
	}
}
