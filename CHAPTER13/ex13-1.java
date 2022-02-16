/**
13-01. 특정 거리의 도시 찾기

=== 입력예시.1 ===
4 4 2 1
1 2
1 3
2 3
2 4

=== 출력예시.1 ===
4

=== 입력예시.2 ===
4 4 1 1
1 2
1 3
2 3
2 4

=== 출력예시.2 ===
2
3
*/

/**
BFS 알고리즘 문제이다.
선입선출의 형태를 가진 Queue를 이용해서 X번 노드부터 시작해 인접 노드가 존재할 때 Enqueue한 뒤 해당 인접노드로 이동한다.
더이상 인접노드가 존재하지 않을 경우 해당 Queue의 사이즈가 K를 만족하면 해당 노드 번호를 추가.
더이상 인접노드가 존재하지 않을 경우 해당 Queue의 사이즈가 K를 만족하지 않으면 다시 Dequeue하여 X번 노드로 돌아간다.

단, 모든 노드를 탐색하였음에도 K를 만족하는 노드 번호가 나오지 않으면 해당 결과값을 -1로 출력한다.
*/

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 도시의 개수
    int m = sc.nextInt(); // 도로의 개수
    int k = sc.nextInt(); // 거리 정보
    int x = sc.nextInt(); // 도시의 번호

    int[] a = new int[m]; // 자연수
    int[] b = new int[m]; 
    for(int i=0; i<m; i++) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }
    sc.close();

    int[] node = new int[n];
    for(int i=0; i<node.length; i++) { node[i] = -1; }

    Queue<Integer> queue = new LinkedList<>();
    for(int i=x; i<node.length; i++) {

      if(queue.size() == k) { 
        break; 
      }
    }

    if(queue.size() != k) { 
      System.out.println(-1);
    } else {
      System.out.println(queue.size());
    }
  }
}






////////////////////////////////////////////////////////////////////////////////






import java.util.*;

public class Main {

    // 도시의 개수, 도로의 개수, 거리 정보, 출발 도시 번호
    public static int n, m, k, x;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    // 모든 도시에 대한 최단 거리 초기화
    public static int[] d = new int[300001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();

        // 그래피 및 최단 거리 테이블 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
            d[i] = -1;
        }

        // 모든 도로 정보 입력 받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        // 출발 도시까지의 거리는 0으로 설정
        d[x] = 0;

        // 너비 우선 탐색(BFS) 수행
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(x);
        while (!q.isEmpty()) {
            int now = q.poll();
            // 현재 도시에서 이동할 수 있는 모든 도시를 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int nextNode = graph.get(now).get(i);
                // 아직 방문하지 않은 도시라면
                if (d[nextNode] == -1) {
                    // 최단 거리 갱신
                    d[nextNode] = d[now] + 1;
                    q.offer(nextNode);
                }
            }
        }

        // 최단 거리가 K인 모든 도시의 번호를 오름차순으로 출력
        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (d[i] == k) {
                System.out.println(i);
                check = true;
            }
        }

        // 만약 최단 거리가 K인 도시가 없다면, -1 출력
        if (!check) System.out.println(-1);
    }
}
