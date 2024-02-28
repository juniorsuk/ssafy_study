package yejin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2477_참외밭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int melon = Integer.parseInt(br.readLine());
		int[] search = new int[6];
		int[] length = new int[6];
		int[] count = new int[5];

		int area = 1;
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			search[i] = Integer.parseInt(st.nextToken());
			length[i] = Integer.parseInt(st.nextToken());
			count[search[i]]++;
		}
		
		//area 구하기
		for(int i=1; i<=4; i++) {
			if(count[i]==1) {
				for(int j=0; j<6; j++) {
					if(search[j]==i) area*=length[j];
				}
			}
		}
		
		int[] d = { 4, 3, 1, 2 };
		int k = -1;
		int l1 = 0;
		int l2 = 0;

		for (int i = 0; i < 5; i++) {
			int next = d[search[i] - 1];
			if (next != search[i + 1]) {
				k = i + 1;
			}
		}
		int area2 = 1;
		if (k == -1) {
			// 시작이 들어간 네모의 꼭짓점!
			l1 = length[0];
			l2 = length[5];
			area2 = l1 * l2;
		} else {
			l1 = length[k];
			l2 = length[k - 1];
			area2 = l1 * l2;
		}

		System.out.println((area - area2) * melon);

	}
}
