import java.io.*;
import java.util.*;

class Namwu{
    int r;
    int c;

    Namwu(){}

    Namwu(int r, int c){
        this.r = r;
        this.c = c;
    }
    
}


public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] goast, my;
    static char[][] map;
    static int N, M;
    static Queue<Namwu> block = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        goast = new boolean[N][M];
        my = new boolean[N][M];
        map = new char[N][M];
        
        Namwu nam = new Namwu();

        for(int r = 0; r < N; r++){
            String str = br.readLine();
            for(int c = 0; c < M; c++){
                char tmp = str.charAt(c);
                map[r][c] = tmp;
                if(tmp =='G') {
                    goast[r][c] = true;
                    //System.out.printf("고스트의 위치: (%d,%d)\n", r, c);
                    block.offer(new Namwu(r, c));
                } else if(tmp == 'N') {
                    nam = new Namwu(r, c);
                    my[r][c] = true;
                }
            }
        }
        System.out.println(bfs(nam));
    }
    
    static String bfs(Namwu N){
        Queue<Namwu> q = new LinkedList<>();
        q.offer(N);

        while(!q.isEmpty()){
            // 귀신 먼저 사방탐색 후 위치를 잡는다. 
            int blockSize = block.size();
            for(int i = 0; i < blockSize; i++){
                Namwu nam = block.poll();
                int r = nam.r;
                int c = nam.c;

                for(int d = 0; d < 4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(check(nr, nc) && !goast[nr][nc]) {
                        goast[nr][nc] = true;
                        block.offer(new Namwu(nr, nc));
                    }
                }
            }
            // 남우가 움직이기 시작한다. 이때 귀신과 마주치면 q에 넣지 않고 사라진다.
            // 마주치지 않는다면 새 위치를 q에 넣는다.
            int qSize = q.size();
            for(int i = 0; i < qSize; i++){
                Namwu nam = q.poll();
                int r = nam.r;
                int c = nam.c;

                for(int d = 0; d < 4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(check(nr, nc) && !my[nr][nc] && map[nr][nc] != '#' && !goast[nr][nc]){
                        my[nr][nc] = true;
                        //System.out.printf("(%d,%d)\n", nr, nc);
                        if(map[nr][nc] == 'D') return "Yes";
                        q.offer(new Namwu(nr, nc));
                    }
                }    
            } 
        }
        return "No";
    }
    
    static boolean check(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < M ;
    }
}
