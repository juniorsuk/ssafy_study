import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2_서울_06_석준영 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 정답 작성용 StringBuilder 생성
		StringBuilder sb = new StringBuilder();
		// test case 갯수 저장용 변수 tc
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t<=tc; t++) {
			// 정답 출력 포맷 형성
			sb.append("#").append(t).append(" ");
			// n, m, k 입력
			String[] nmk = br.readLine().split(" ");
			int n = Integer.parseInt(nmk[0]);
			int m = Integer.parseInt(nmk[1]);
			int k = Integer.parseInt(nmk[2]);
			// n, m, k의 최소공배수 구하기
			int lcm = n;
			while (true) {
				if (lcm%n == 0 && lcm%m == 0 && lcm%k == 0) break;
				lcm += n;
			}
			// 각 슬롯을 배열로 표현
			String[] first = br.readLine().split(" ");
			String[] second = br.readLine().split(" ");
			String[] third = br.readLine().split(" ");
			// 각 슬롯의 초기 index 0으로 설정
			int in = 0;
			int im = 0;
			int ik = 0;
			// 정답을 담을 변수 선언 (디폴트 값은 -1)
			int ans = -1;
			// n, m, k의 최소공배수만큼 돌려보기
			for (int i = 0; i<=lcm; i++) {
				if (first[in].equals(second[im]) && second[im].equals(third[ik])) {
					// 셋 다 같은숫자이면 ans에 답 입력 후 break
					ans = i;
					break;
				}
				// 숫자 세개 다르면 다시 회전
				in = (++in)%n;
				im = (++im)%m;
				ik = (++ik)%k;
			}
			// 정답 출력 업데이트
			sb.append(ans).append("\n");
		}
		// 정답 출력
		System.out.println(sb);
	}
}
