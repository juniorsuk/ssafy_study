import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int N = sc.nextInt(); //수학여행 참가하는 학생 수
        int K = sc.nextInt(); // 한 방에 배정할 수 있는 최대 인원수
        int[][] RoomChoice = new int [2][6 + 1]; // [성별][학년]
        for(int i=0; i<N; i++){
            RoomChoice[sc.nextInt()][sc.nextInt()]++;
        }
        int ans = 0;
        for(int i=1; i<=6; i++){
            for(int j=0; j<2; j++){
                int StuNum = RoomChoice[j][i];
                int quo = StuNum / K ;
                int remain = StuNum % K;

                if( remain >0 ){
                    ans += quo + 1;
                } else if (remain == 0) ans += quo;
            }
        }
        System.out.println(ans);
    }
}