import java.util.Scanner;

public class 지환이의공놀이 {
    static int N,M,L,curP,countReceiveMax,countBall;
    static int[] countReceive;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        N = sc.nextInt(); // 1부터 N까지 적힌 자리 앉음
        M = sc.nextInt(); // M번 받으면 겜 끝
        L = sc.nextInt(); // L번째 사람에게 공 던짐
        countReceiveMax = 1;
        countBall =0;
        curP =1;
        countReceive =new int[N +1];
        countReceive[1]++;
        while( countReceiveMax != M){
            throwBall();
        }
        System.out.println(countBall);

    }
    public static void throwBall(){
        if(L % 2 == 1) {// L이 홀수일때
            if (curP + L <= N) {
                countReceive[curP + L]++;
                curP += L;
            } else {
                countReceive[curP - (N - L)]++;
                curP -= N - L;
            }
        }
        else if( L % 2 == 0){ //L이 짝수일 때
            if(curP - L >= 1) {
                countReceive[curP - L]++;
                curP -= L;
            }
            else {
                countReceive[curP + (N - L)]++;
                curP += N-L;
            }
        }
        countBall++;
        for(int i=0; i<N+1; i++) {
            if (countReceiveMax < countReceive[i])
                countReceiveMax = countReceive[i];
        }

    }
}