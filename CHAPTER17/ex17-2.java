/**
17-02. 정확한 순위

=== 입력 예시 ===
6 6
1 5
3 4
4 2
4 6
5 2
5 4

=== 출력 예시 ===
1
*/

import java.util.*;

class Node {
  private int a;
  private int b;

  public Node(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public int getA() {
    return a;
  }

  public int getB() {
    return b;
  }
}

class Main {
  public static void main(String[] args) {
    int n = 6; // 학생들의 수
    int m = 6; // 두 학생의 성적을 비교한 횟수
    
    ArrayList<Node> node = new ArrayList<>(); // 두 학생의 성적을 비교한 결과를 나타내는 두 양의 정수
    node.add(new Node(1, 5));
    node.add(new Node(3, 4));
    node.add(new Node(4, 2));
    node.add(new Node(4, 6));
    node.add(new Node(5, 2));
    node.add(new Node(5, 4));

    HashMap<Integer, Integer> rank = new HashMap<>(); // 각 학생들의 순위
    for(int i=0; i<n; i++) { rank.put(i+1, 1); }

    for(Node nod: node) { rank.replace(nod.getA(), rank.get(nod.getA())+1); } // node를 토대로 각 학생들의 순위를 변경한다

    int result = 0; // 성적 순위를 정확히 알 수 있는 학생의 수
    /* 성적 순위를 정확하게 알 수 있는 알고리즘을 구현해보자... */ 

    System.out.println(result); // 결과 값 출력
  }
}






///////////////////////////////////////////////////////////////////////////////////////////






import java.util.*;

public class Main {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(N), 간선의 개수(M)
    public static int n, m;
    // 2차원 배열(그래프 표현)를 만들기
    public static int[][] graph = new int[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < 501; i++) {
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
            graph[a][b] = 1;
        }

        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int result = 0;
        // 각 학생을 번호에 따라 한 명씩 확인하며 도달 가능한지 체크
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != INF || graph[j][i] != INF) {
                    cnt += 1;
                }
            }
            if (cnt == n) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}
