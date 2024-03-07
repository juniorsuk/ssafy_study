
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프옮기기1 {
    static int[][] pipeMap;
    static int N,cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pipeMap = new int[N+1][N+1];
        cnt = 0;
        for(int i = 1; i <= N; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            for(int j = 1; j<= N; j++){
                pipeMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        searchPosition(1,2, 1);
        System.out.println(cnt);

    }
    public static void searchPosition(int r, int c, int dir){
        //기저조건
        if(r == N && c == N) {
            cnt++;
            return;
        }
        //재귀조건
        switch (dir) {

            case 1: //가로
                if (c + 1 <= N && pipeMap[r][c + 1] == 0) {
                    searchPosition(r, c + 1, 1);
                }
                break;
            case 2: //세로
                if (r + 1 <= N && pipeMap[r + 1][c] == 0) {
                    searchPosition(r + 1, c, 2);
                }
                break;
            case 3: //대각선일때
                if (c + 1 <= N && pipeMap[r][c + 1] == 0) { //가로
                    searchPosition(r, c + 1, 1);
                }
                if (r + 1 <= N && pipeMap[r + 1][c] == 0) { //세로
                    searchPosition(r + 1, c, 2);
                }
                break;
        }
        //대각선
        if(  c+1 <=N  && r+1<=N && pipeMap[r+1][c] ==0 && pipeMap[r+1][c+1] ==0 && pipeMap[r][c+1] ==0){
            searchPosition(r+1,c+1, 3);
        }

    }
}