import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 딱지놀이 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //경기 횟수 입력
        for (int num = 1; num <= N; num++) {
            PriorityQueue<Integer> queueA = new PriorityQueue<>(Collections.reverseOrder()); //A의 우선순위큐
            PriorityQueue<Integer> queueB = new PriorityQueue<>(Collections.reverseOrder()); //B의 우선순위큐
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cardnum = Integer.parseInt(st.nextToken());
            for (int i = 0; i < cardnum; i++)
                queueA.add(Integer.parseInt(st.nextToken()));

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            cardnum = Integer.parseInt(st1.nextToken());
            for (int i = 0; i < cardnum; i++)
                queueB.add(Integer.parseInt(st1.nextToken()));
            //A랑 B에 정수 값으로 입력 받기
            while (queueB.size() != queueA.size()) {
                if (queueA.size() > queueB.size())
                    queueB.add(0);

                if (queueA.size() < queueB.size())
                    queueA.add(0);
            }

            String winner = "";
            int cnt = queueA.size(); //우선순위 큐의 숫자 카운트

            while (!queueA.isEmpty()) {
                int A = queueA.poll(); //A에서 가장 높은 우선순위 값 저장
                int B = queueB.poll(); //B에서 가장 높은 우선순위 값 저장
                if (A > B) {
                    winner = "A";
                        break;
                } else if (A < B) {
                        winner = "B";
                        break;
                    } else if (A == B) cnt--;
                    if (cnt == 0) {
                        winner = "D";
                        break;
                    }

            }
                System.out.println(winner);
        }
    }
}

