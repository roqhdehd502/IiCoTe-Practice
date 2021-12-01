/*
9-2. 미래도시
=== 입력예시1 ===
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
=== 출력예시1 ===
3
=== 입력예시2 ===
4 2
1 3
2 4
3 4
=== 출력예시2 ===
-1
*/


/*
0 1 1 1 2
1 0 2 1 2
1 2 0 1 1
1 1 1 0 1
2 2 1 1 0
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 무한을 의미하는 값으로 10억을 설정
    final int INF = 1000000000;

    // 노드의 개수 및 간선의 개수를 입력받기
    int n = sc.nextInt(); // 노드의 개수
    int m = sc.nextInt(); // 노드의 간선

    // n+1 크기의 2차원 리스트 생성
    int[][] graph = new int[n+1][n+1];

    // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화(그 외는 무한으로 초기화)
    for(int a=1; a<n+1; a++) { 
      for(int b=1; b<n+1; b++) {
        if(a == b) {
          graph[a][b] = 0;
        } else {
          graph[a][b] = INF;
        }
      }
    }

    // 각 간선의 대한 정보를 입력받아, 그 값으로 초기화
    for(int i=1; i<=m; i++) {
      // A와 B가 서로에게 가는 비용은 1이라고 설정
      int a = sc.nextInt();
      int b = sc.nextInt();
      graph[a][b] = 1;
      graph[b][a] = 1;
    }

    // 거쳐 갈 노드 X와 최종 목적지 노드 K를 입력받기
    int x = sc.nextInt();
    int k = sc.nextInt();
    sc.close();

    // 점화식에 따라 플로이드 워셜 알고리즘 수행
    for(int h=1; h<n+1; h++) {
      for(int i=1; i<n+1; i++) {
        for(int j=1; j<n+1; j++) {
          graph[i][j] = Math.min(graph[i][j], graph[i][h] + graph[h][j]);
        }
      }
    } 

    // 수행된 결과값을 초기화
    int distance = graph[1][k] + graph[k][x];

    // 도달할 수 없는 경우, -1을 출력
    if(distance >= INF) {
      System.out.println("-1");
    } else {
      System.out.println(distance);
    }
  }
}
