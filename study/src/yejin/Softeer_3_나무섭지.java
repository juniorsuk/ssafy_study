package softeer;

import java.io.*;
import java.util.*;

class node{
    int x;
    int y;
    int depth;

    node(){
        
    }

    node(int x, int y, int depth){
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
    node(int x, int y){
        this.x = x;
        this.y = y;
    }
    
}

    // 동시에 출발해서 봐야한다..
    // 가능한 경로를 그려놓고 하려했더니 그러기엔 가능한 경로가 많을지도

    // 1. BFS로 EXIT를 향해서 간다.
    // 2. 가면서 유령을 만나는 case는 return한다
    // 3. EXIT까지 무사히 도착한 친구들이 있음 끝
    //    무사히 도착하는 친구들을 어떻게 찾을 것인가??
    //    - 한 칸 이동할 때 마다 유령을 그만큼 이동시킨다?
    //    - 오래 걸리지 않을까?
    //    - 유령은 남우를 향해서 간다....... 벽을 뚫고 갈 수 있음! -> |(남우x-유령x) + (남우y-유령y)| <= 남우 이동 횟수 로 판단하면 되겠다!

    //----------------------시간초과
    //남우의 최단 경로를 구하고 귀신이 갈 수 있는 최단 경로를 구해서 비교한다

//     public class Main {
//     static int n,m,gNum;
//     static List<node> G;
//     static node nam, D;
//     static int[] dr = {-1,1,0,0};
//     static int[] dc = {0,0,-1,1};
//     static boolean[][] visited;
    
//     public static void main(String[] args) throws IOException{

//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         n = Integer.parseInt(st.nextToken());
//         m = Integer.parseInt(st.nextToken());
//         G = new LinkedList<>(); //유령 넣어주기
//         gNum = 0; //유령 수
//         visited = new boolean[n][m];
        
//         for(int r=0; r<n; r++){
//             String str = br.readLine();
//             for(int c=0; c<m; c++){
//                 char tmp = str.charAt(c);
//                 if(tmp=='G'){
//                     G.add(new node(r,c));
//                     gNum ++;
//                      visited[r][c]=true; //유령 방문 안됨
//                 }else if(tmp=='N'){
//                     nam = new node(r,c,0);
//                      visited[r][c]=true; //방문 체크
//                 }else if(tmp=='D'){
//                     D = new node(r,c);
//                 }else if(tmp=='#'){
//                     visited[r][c]=true; //벽은 방문할 수 없는 곳
//                 }
//             }
//         }
        
//         if(bfs()){
//             System.out.println("Yes");
//         }else{
//             System.out.println("No");
//         }
//     }
    

//     static boolean bfs(){
        
//         Queue<node> que = new LinkedList<>();
//         que.offer(nam);
        
//         while(!que.isEmpty()){
//             node cNam = que.poll();
//             for(int d=0; d<4; d++){
//                 int nr = cNam.x + dr[d];
//                 int nc = cNam.y + dc[d];
//                 if(nr>=0 && nc>=0 && nr<n && nc<m && (!visited[nr][nc]) && isPossible(nr, nc, cNam.depth+1)){
//                     if(nr==D.x && nc==D.y){
//                         return true;
//                     }
//                     visited[nr][nc] = true;
//                     que.offer(new node(nr, nc, cNam.depth+1));
//                 }
//             }
//         }
//         return false;
//     }

//     static boolean isPossible(int nr, int nc, int depth){
//         if(gNum==0) return true;
//         for(int g=0; g<gNum; g++){
//             if((Math.abs(G.get(g).x-nr)+Math.abs(G.get(g).y-nc))<=depth) return false;
//         }
//         return true;
//     }

// }


public class Softeer_3_나무섭지 {
    static int n,m,gNum;
    static List<node> G;
    static node nam, D;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        G = new LinkedList<>(); //유령 넣어주기
        gNum = 0; //유령 수
        visited = new boolean[n][m];
        
        for(int r=0; r<n; r++){
            String str = br.readLine();
            for(int c=0; c<m; c++){
                char tmp = str.charAt(c);
                if(tmp=='G'){
                    G.add(new node(r,c));
                    gNum ++;
                     visited[r][c]=true; //유령 방문 안됨
                }else if(tmp=='N'){
                    nam = new node(r,c,0);
                     visited[r][c]=true; //방문 체크
                }else if(tmp=='D'){
                    D = new node(r,c);
                }else if(tmp=='#'){
                    visited[r][c]=true; //벽은 방문할 수 없는 곳
                }
            }
        }
        
        if(bfs()){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
    

    static boolean bfs(){
        
        Queue<node> que = new LinkedList<>();
        que.offer(nam);
        
        while(!que.isEmpty()){
            node cNam = que.poll();
            for(int d=0; d<4; d++){
                int nr = cNam.x + dr[d];
                int nc = cNam.y + dc[d];
                if(nr>=0 && nc>=0 && nr<n && nc<m && (!visited[nr][nc])){
                    if(nr==D.x && nc==D.y){
                        return isPossible(cNam.depth+1);
                    }
                    visited[nr][nc] = true;
                    que.offer(new node(nr, nc, cNam.depth+1));
                }
            }
        }
        return false; //남우 탈출 못했을 경우
    }

    static boolean isPossible(int depth){
        if(gNum==0) return true;
        for(int g=0; g<gNum; g++){
            if((Math.abs(G.get(g).x-D.x)+Math.abs(G.get(g).y-D.y))<=depth) return false;
        }
        return true;
    }

}

