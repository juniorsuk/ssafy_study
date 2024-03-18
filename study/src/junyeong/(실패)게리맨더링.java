package solving;

import java.util.*;

public class N17471_n {
	static int[] parent;
	static int[] people;
	static int ans = Integer.MAX_VALUE;
	static int n;
	static int psum;
	static boolean[][] graph;
	static boolean[] gary;
	static boolean[] chk;
	
	static void Union(int a, int b) {
		if (parent[a] > parent[b]) parent[a] = parent[b];
		else parent[b] = parent[a];
	}
	
	static void Gary (int now) {
		if (now == n) {
			List<Integer> baek = new LinkedList<>();
			List<Integer> other = new LinkedList<>();
			for (int i = 0; i<n; i++) {
				if (gary[i]) baek.add(i);
				else other.add(i);
			}
			if (baek.size() == 0 || other.size() == 0) return;
			if (ConChk(baek) && ConChk(other)) {
				int isum = 0;
				for (int i = 0; i<baek.size(); i++) isum += people[baek.get(i)];
				ans = Math.min(ans, Math.abs(psum-2*isum));
			}
			return;
		}
		gary[now] = true;
		Gary(now+1);
		gary[now] = false;
		Gary(now+1);
	}
	
	static boolean ConChk (List<Integer> l) {
		Queue<Integer> q = new LinkedList<>();
		chk = new boolean[n];
		chk[l.get(0)] = true;
		q.offer(l.get(0));
		
		int chkcnt = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i<n; i++) {
				if (graph[now][i] && !chk[i]) {
					q.offer(i);
					chk[i] = true;
					chkcnt++;
				}
			}
		}
		if (chkcnt == l.size()) return true;
		else return false;		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		people = new int[n];
		parent = new int[n];
		psum = 0;
		for (int i = 0; i<n; i++) {
			people[i] = sc.nextInt();
			parent[i] = i;
			psum += people[i];
		}
		graph = new boolean[n][n];
		for (int i = 0; i<n; i++) {
			int ni = sc.nextInt();
			for (int j = 0; j<ni; j++) graph[i][sc.nextInt()-1] = true;
		}
		for (int i = 0; i<n; i++) {
			for (int j = 1; j<n; j++) {
				if (graph[i][j]) Union(i,j);
			}
		}
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i<n; i++) {
			set.add(parent[i]);
		}
		if (set.size() > 2) {
			System.out.println(-1);
			System.exit(0);
		}
		else if (set.size() == 2) {
			int p1 = 0;
			for (int i = 0; i<n; i++) {
				if (parent[i] == 0) p1 += people[i];
			}
			System.out.println(Math.abs(psum-p1*2));
			System.exit(0);
		}
		gary = new boolean[n];
		Gary(0);
		System.out.println(ans);
		sc.close();
	}
}
