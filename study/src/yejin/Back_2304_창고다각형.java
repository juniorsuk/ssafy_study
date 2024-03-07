package yejin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2304_창고다각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] NArr = new int[1001];
		// 최대 기둥 값
		int maxPillar = 0;
		// 최대 기둥 인덱스
		int maxPillarIdx = -1;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			NArr[x] = Integer.parseInt(st.nextToken());
			if (NArr[x] > maxPillar) {
				maxPillarIdx = x;
				maxPillar = NArr[x];
			}
		}

		// 시작위치와 끝위치 찾기
		int start = 0;
		int finish = 1000;
		while (NArr[start] == 0) {
			start++;
		}
		while (NArr[finish] == 0) {
			finish--;
		}

		int maxN = 0;
		int area = 0;
		if (start != maxPillarIdx && finish != maxPillarIdx) {
			// 1) 산모양
			for (int x = start; x < maxPillarIdx; x++) {
				if (NArr[x] > maxN) {
					maxN = NArr[x];
				}
				area += maxN;
			}
			maxN = 0;
			for (int x = finish; x >= maxPillarIdx; x--) {
				if (NArr[x] > maxN) {
					maxN = NArr[x];
				}
				area += maxN;
			}
		} else if (start == maxPillarIdx) {
			// 내림차순 모양
			for (int x = finish; x >= start; x--) {
				if (NArr[x] > maxN) {
					maxN = NArr[x];
				}
				area += maxN;
			}
		} else if (finish == maxPillarIdx) {
			// 오름차순 모양
			for (int x = start; x <= finish; x++) {
				if (NArr[x] > maxN) {
					maxN = NArr[x];
				}
				area += maxN;
			}
		}

		System.out.println(area);
	}
}
