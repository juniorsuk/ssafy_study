package yejin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_17471_게리맨더링 {
	static int N;
	static int[][] edge;
	static int[] personNum;
	static List<Integer> group1;
	static List<Integer> group2;
	static int[] numCheck;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 최소값 담기
		min = Integer.MAX_VALUE;
		// 구역의 수
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		// 인구정보 입력
		personNum = new int[N+1];
		numCheck = new int[N+1];
		for (int n = 1; n <= N; n++) {
			personNum[n] = Integer.parseInt(st.nextToken());
		}

		// 간선정보입력
		edge = new int[N+1][N+1];
		int zero = 0;
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st.nextToken()) == 0)
				zero++;
			if (zero >= 2) {
				if(N==2) continue;
				min = -1;
				break;
			}
			while (st.hasMoreTokens()) {
				int idx = Integer.parseInt(st.nextToken());
				edge[n][idx]=1;
			}
		}
		if (min != -1) {
			find(1);
			System.out.println(min);
		} else {
			//가능한 경우 없을 때
			System.out.println(min);
		}

	}

	public static void find(int idx) {
		ispossible();

		for (int i = idx; i <= N; i++) {
			numCheck[i]++;
			find(i+1);
			numCheck[i]--;
		}

	}

	public static boolean ispossible() {
		group1 = new LinkedList<>();
		group2 = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(numCheck[i]==0) group2.add(i);
			else group1.add(i);
		}
		
		if(group1.size()==N||group1.size()==0) return false;
		
		if(bfs(group1)&&bfs(group2)) {
			int sum1=0;
			int sum2=0;
			for(int i=0; i<group1.size(); i++) {
				sum1+=personNum[group1.get(i)];
			}
			for(int i=0; i<group2.size(); i++) {
				sum2+=personNum[group2.get(i)];
			}
			min = Math.min(Math.abs(sum1 - sum2), min);
			return true;
		}
			
		return false;
	}
	
	
	public static boolean bfs(List<Integer> group) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] check = new boolean[N+1]; 
		q.offer(group.get(0));
		
		while(!q.isEmpty()) {
			int qnum = q.poll();
			check[qnum] = true;
			for(int i=1; i<group.size(); i++) {
				int num = group.get(i);
				if(check[num]) continue;//이미 체크한거면 패스
				if(edge[qnum][num]==1) {
					q.offer(num);
				}
			}
		}
		for(int i=0; i<group.size(); i++) {
			if(!check[group.get(i)]) return false;
		}
		return true;
	}
}