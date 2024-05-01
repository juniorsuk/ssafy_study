import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] map = new int[n][m];
        int[] namu = new int[2];
        int[] goal = new int[2];
        int gd = Integer.MAX_VALUE;
        String[] smap = new String[n];
        fg : for (int i = 0; i<n; i++){
            String row = br.readLine();
            smap[i] = row;
            for (int j = 0; j<m; j++) {
                char now = row.charAt(j);
                if (now == 'D'){
                    goal[1] = i;
                    goal[0] = j;
                }
            }
        }            
        for (int i = 0; i<n; i++){
            String row = smap[i];
            for (int j = 0; j<m; j++) {
                char now = row.charAt(j);
                if (now == 'G'){
                    int gg = Math.abs(j-goal[0])+Math.abs(i-goal[1]);
                    gd = Math.min(gd, gg);
                    continue;
                }
                if (now == 'N'){
                    namu[1] = i;
                    namu[0] = j;
                    continue;
                }
                if (now == '#') map[i][j] |= (1 << 1);
            }
        }
        boolean esc = false;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Integer> qx = new ArrayDeque<>();
        Queue<Integer> qy = new ArrayDeque<>();
        Queue<Integer> qcnt = new ArrayDeque<>();
        qx.offer(namu[0]);
        qy.offer(namu[1]);
        qcnt.offer(0);
        
        int[][] visited = new int[n][m];
        
        int nd = Integer.MAX_VALUE;
        que : while (!qx.isEmpty()){
            int nx = qx.poll();
            int ny = qy.poll();
            int ncnt = qcnt.poll();

            if ((visited[ny][nx] | 0) != 0) continue;
            visited[ny][nx] |= (1 << ncnt); 
            
            for (int i = 0; i<4; i++){
                int ax = nx + dx[i];
                int ay = ny + dy[i];
                if (ax == goal[0] && ay == goal[1]){
                    nd = ncnt+1;
                    esc = true;
                    break que;
                }
                if (ay >= 0 && ay<n && ax>=0 && ax<m && (visited[ay][ax] | 0) == 0 && ((map[ay][ax] | 0) == 0)){
                    qx.offer(ax);
                    qy.offer(ay);
                    qcnt.offer(ncnt+1);
                }
            }
        }
        if (esc && nd<gd) System.out.println("Yes");
        else System.out.println("No");
    }
}
