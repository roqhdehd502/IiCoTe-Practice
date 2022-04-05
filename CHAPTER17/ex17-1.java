/**
17-01. 플로이드

=== 입력 예시 ===
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4

=== 출력 예시 ===
0 2 3 1 4
12 0 15 2 5
8 5 0 1 1
10 7 13 0 3
7 4 10 6 0
*/

import java.util.ArrayList;

class Info { // 버스의 정보
  private int a; // 버스의 시작 도시
  private int b; // 도착 도시
  private int c; // 한 번 타는데 드는 비용

  public Info(int a, int b, int c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }
}

class Main {
  public static void main(String[] args) {
    /* 입력 예시 */
    int n = 5; // 도시의 개수
    int m = 14; // 버스의 개수
    
    ArrayList<Info> bus = new ArrayList<>(); // 버스의 정보를 담는 배열
    bus.add(new Info(1, 2, 2));
    bus.add(new Info(1, 3, 3));
    bus.add(new Info(1, 4, 1));
    bus.add(new Info(1, 5, 10));
    bus.add(new Info(2, 4, 2));
    bus.add(new Info(3, 4, 1));
    bus.add(new Info(3, 5, 1));
    bus.add(new Info(4, 5, 3));
    bus.add(new Info(3, 5, 10));
    bus.add(new Info(3, 1, 8));
    bus.add(new Info(1, 4, 2));
    bus.add(new Info(5, 1, 7));
    bus.add(new Info(3, 4, 2));
    bus.add(new Info(5, 2, 4));

    /* 도시 A에서 B로 가는 데 필요한 비용의 최소값을 구하기 */
    int[][] cost = new int[n][n]; // 비용 배열 선언
    
    for(int i=0; i<n; i++) { // 비용 배열 초기값 정하기(1 <= cost[i][j] <= 100000)
      for(int j=0; j<n; j++) {
        cost[i][j] = 100001; 
      }
    }
    
    for(int i=0; i<n; i++) { // 비용 최소값 로직
      for(int j=0; j<n; j++) {
        if(i == j) { // 주 대각선 위치 경우 i에서 j로 갈 수 없으므로 비용은 0이 된다.
          cost[i][j] = 0;
          continue;          
        }
        for(Info info: bus) { // bus 배열 탐색
          if(info.a == i+1 && info.b == j+1) { // 해당 위치에 해당될 때
            cost[i][j] = Math.min(cost[i][j], info.c); // 비용의 최소값을 갱신한다.
          }
        }
      }
    }

    /* 결과값 출력 */
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        System.out.print(cost[i][j] + " ");
      }
      System.out.println();
    }
  }
}






///////////////////////////////////////////////////////////////////////////////////////






import java.util.*;

public class Main {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(N), 간선의 개수(M)
    public static int n, m;
    // 2차원 배열(그래프 표현)를 만들기
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }

        // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for (int i = 0; i < m; i++) {
            // A에서 B로 가는 비용은 C라고 설정
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // 가장 짧은 간선 정보만 저장
            if (c < graph[a][b]) graph[a][b] = c;
        }

        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 수행된 결과를 출력
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
                if (graph[a][b] == INF) {
                    System.out.print(0 + " ");
                }
                // 도달할 수 있는 경우 거리를 출력
                else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }
    }
}
