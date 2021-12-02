/*
9-3. 전보

=== 입력예시 ===
3 2 1
1 2 4
1 3 2

=== 출력예시 ===
2 4
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 무한을 의미하는 값으로 10억을 설정
    final int INF = 1000000000;

    // 노드의 개수, 간선의 개수, 시작 노드를 입력받기
    int n = sc.nextInt();
    int m = sc.nextInt();
    int start = sc.nextInt();

    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
    int[][] graph = new int[n+1][n+1];

    // 최단 거리 테이블을 모두 무한으로 초기화
    int[] distance = new int[n+1];
    for(int i=0; i<distance.length; i++) { distance[i] = INF; }

    // 모든 간선 정보를 입력받기
    for(int i=0; i<m; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int z = sc.nextInt();
    }
    sc.close();

    // 다익스트라 알고리즘 수행
    dijkstra(start);

    // 도달할 수 있는 노드의 개수
    int count = 0;

    // 도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 최단 거리
    int max_distance = 0;
    for(int d=0; d<distance; d++) {
      // 도달할 수 있는 노드인 경우
      if(d != INF) {
        count++;
        max_distance = Math.max(max_distance, d);
      }
    }

    // 시작 노드는 제외해야 하므로 count-1을 출력
    System.out.print(count-1);
    System.out.println(" " + max_distance);
  }

  public static void dijkstra(int start) {
    int[] q = new int[];
    
    // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
    heapq.heappush(q, (0, start));
    distance[start] = 0

    // 큐가 비어있지 않다면
    while(q != 0) {
      // 가장 최단 거리가 짧은 노드에 대한 정보를 꺼내기
      int dist = heapq.heappop(q);
      int now = heapq.heappop(q);

      if(distance[now] < dist) {
        continue;
      }

      // 현재 노드와 연결된 다른 인접한 노드들을 확인
      for(int i=0; i<graph[now]; i++) {
        int cost = dist + i[1];
        // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
        if(cost < distance[i[0]]) {
          distance[i[0]] = cost;
          heapq.heappush(q, (cost, i[0]));
        }
      }
    }
  }
}
