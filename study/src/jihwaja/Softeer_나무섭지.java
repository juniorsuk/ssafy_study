import java.util.*;

public class Softeer_나무섭지 {
    /* 가장 많이 나오는 미로찾기 패턴 문제, 문제의 매몰되지 않고
    분석하여 사고하는 것이 문제를 푸는 핵심 아이디어.
    필자는 유령과 남우 사이의 관계에 주목하여 접근하였음.
    따라잡힐 수 있다의 의미, 벽이 있을 때의 의미
    이 두 가지 관점을 어떻게 해석해서 코드로 구현할 것인가가
    문제해결의 핵심 키워드.
    */
    static int Dr, Dc, Nr, Nc, Wr, Wc, ghost_num, n, m, Min_distanceDoortoGhost,Min_distanceDoortoNam, distanceDoortoNam;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};

    static int[][] visited ;
    static char[][] maze;
    static List<int[]> ghostPos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); //행
        m = sc.nextInt(); //열

        maze = new char[n][m];
        visited = new int[n][m];
        ghost_num = 0;
        Dr = 0;
        Dc = 0;
        Nr = 0;
        Nc = 0;
        Wr = 0;
        Wc = 0;
        Min_distanceDoortoGhost = Integer.MAX_VALUE;
        Min_distanceDoortoNam = Integer.MAX_VALUE ;
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j);
                if (maze[i][j] == 'G') {
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    ghostPos.add(arr);
                    ghost_num++;
                } else if (maze[i][j] == 'D') {
                    Dr = i;
                    Dc = j;
                } else if (maze[i][j] == 'N') {
                    Nr = i;
                    Nc = j;
                } else if (maze[i][j] == '#') {
                    Wr = i;
                    Wc = j;
                }
            }
        }// idx 미리 찾기

        //유령과 문사이 최소거리 구하기
        for (int ghost = 0; ghost < ghost_num; ghost++) {
            int[] arr = ghostPos.get(ghost);
            int sum = Math.abs(Dr - arr[0]) + Math.abs(Dc - arr[1]);

            if (sum < Min_distanceDoortoGhost)
                Min_distanceDoortoGhost = sum;
        }

        if (cal_distanceDoortoNam(Nr, Nc) > 0 && cal_distanceDoortoNam(Nr, Nc) < Min_distanceDoortoGhost)
            System.out.println("Yes");
        else System.out.println("No");
    }
    public static int cal_distanceDoortoNam( int Nr, int Nc) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{Nr,Nc});
        visited[Nr][Nc] = 0;

        while (!q.isEmpty()){
            int[] currentNam = q.poll();
            int curR = currentNam[0];
            int curC = currentNam[1];
            for(int i =0; i<4 ; i++){
                int nR = curR + dr[i];
                int nC = curC + dc[i];

                if(nR >= n || nR < 0 || nC >= m || nC < 0 || maze[nR][nC] == '#') continue;

                if(visited[nR][nC] == 0 ){
                    visited[nR][nC] = visited[curR][curC] + 1 ;
                    q.add(new int[]{nR,nC});
                }
            }
        }
        return visited[Dr][Dc];
    }
}