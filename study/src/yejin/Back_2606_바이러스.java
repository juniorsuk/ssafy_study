package back_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class Back_2606_바이러스 {
	static int comNum, edge, res;
	static List<Integer>[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		comNum = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());

		tree = new List[comNum + 1];

		for (int e = 0; e < edge; e++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			if (tree[node1] == null) {
				tree[node1] = new ArrayList<>();
				tree[node1].add(node2);
			}else {
				tree[node1].add(node2);				
			}
			if (tree[node2] == null) {
				tree[node2] = new ArrayList<>();
				tree[node2].add(node1);
			} else {
				tree[node2].add(node1);
			}
		}

		res = 0;
		bfs();
		System.out.println(res);

	}

	public static void bfs() {
		Queue<Integer> que = new LinkedBlockingDeque<>();
		if (tree[1] == null)
			return;
		boolean[] visited = new boolean[comNum + 1];
		visited[1] = true;
		que.offer(1);
		while (!que.isEmpty()) {
			int node = que.poll();
			if (tree[node] == null)
				continue;
			for (int i = 0; i < tree[node].size(); i++) {
				int node2 = tree[node].get(i);
				if (visited[node2])
					continue;
				visited[node2] = true;
				que.offer(node2);
				res++;
			}
		}

	}
}
