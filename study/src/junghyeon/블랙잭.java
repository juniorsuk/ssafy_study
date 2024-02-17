package junghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블랙잭 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int targetNum = Integer.parseInt(st.nextToken());
        int maxNum = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        int sum;
        
        // 카드뭉치 배열 제작
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        // 최대 3개 수를 합하기 때문에 for문 3번 돈다.
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    sum = cards[i] + cards[j] + cards[k];
                    if(targetNum - sum >= 0 && sum > maxNum) maxNum = sum;
                    // 목표하는 숫자에서 숫자 3개 합을 뺐을때 0보다 크거나 같고, 최댓값일때 갱신
                }
            }
        }
        System.out.println(maxNum);
    }
}
