/**
17-03. 화성 탐사

=== 입력 예시 ===
3
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4

=== 출력 예시 ===
20
19
36
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    int t = 3; // 테스트 케이스의 수

    int[] n = {3, 5, 7}; // 각 테스트 케이스의 공간 크기
    int[][][] arr = {
        {
          {5, 5, 4}
        , {3, 9, 1}
        , {3, 2, 7}
        }
      , {
          {3, 7, 2, 0, 1}
        , {2, 8, 0, 9, 1}
        , {1, 2, 1, 8, 1}
        , {9, 8, 9, 2, 0}
        , {3, 6, 5, 1, 5}
        }
      , {
          {9, 0, 5, 1, 1, 5, 3}
        , {4, 1, 2, 1, 6, 5, 3}
        , {0, 7, 6, 1, 6, 8, 5}
        , {1, 1, 7, 8, 3, 2, 3}
        , {9, 4, 0, 7, 6, 4, 1}
        , {5, 8, 3, 2, 4, 8, 3}
        , {7, 4, 8, 4, 8, 3, 4}
        }      
    }; // 각 테스트 케이스의 노드  
    
    int[] result = new int[t]; // 결과값

    int i, j, k;
    i = j = k = 0;
    while(i > t-1) { // 탐사 알고리즘
      while(j > n[i]-1 && k > n[i]-1) {
        result[i] += arr[i][j][k];
        if(j+1 > n[i]) {
          k++;
        } else if(k+1 > n[i]) {
          j++;
        } else {
          if(arr[i][j+1][k] < arr[i][j][k+1]) {
            j++;
          } else if(arr[i][j+1][k] > arr[i][j][k+1]) {
            k++;
          }
        }
      }
      i++;
      j=0;
      k=0;
    }

    for(int a=0; a<result.length; a++) { System.out.println(result[a]); } // 결과값 출력
  }
}






//////////////////////////////////////////////////////////////////////////






import java.util.*;

class Node implements Comparable<Node> {

    private int x;
    private int y;
    private int distance;

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getDistance() {
        return this.distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class Main {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    public static int[][] graph = new int [125][125];
    public static int[][] d = new int[125][125];
    public static int testCase, n;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        testCase = sc.nextInt();

        // 전체 테스트 케이스(Test Case)만큼 반복
        for (int tc = 0; tc < testCase; tc++) {
            // 노드의 개수를 입력받기
            n = sc.nextInt();

            // 전체 맵 정보를 입력받기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }

            // 최단 거리 테이블을 모두 무한으로 초기화
            for (int i = 0; i < n; i++) {
                Arrays.fill(d[i], INF);
            }

            int x = 0, y = 0; // 시작 위치는 (0, 0)
            // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, graph[x][y]));
            d[x][y] = graph[x][y];

            while(!pq.isEmpty()) { // 다익스트라 알고리즘을 수행
                // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
                Node node = pq.poll();
                int dist = node.getDistance();
                x = node.getX();
                y = node.getY();
                // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
                if (d[x][y] < dist) continue;
                // 현재 노드와 연결된 다른 인접한 노드들을 확인
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    // 맵의 범위를 벗어나는 경우 무시
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    int cost = dist + graph[nx][ny];
                    // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                    if (cost < d[nx][ny]) {
                        d[nx][ny] = cost;
                        pq.offer(new Node(nx, ny, cost));
                    }
                }
            }
            System.out.println(d[n - 1][n - 1]);
        }
    }
}
