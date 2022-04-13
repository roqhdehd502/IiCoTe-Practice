/**
18-01. 여행 계획

=== 입력 예시 ===
5 4
0 1 0 1 1
1 0 1 1 0
0 1 0 0 0
1 1 0 0 0
1 0 0 0 0
2 3 4 3

=== 출력 예시 ===
YES
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    int n = 5; // 여행지의 수
    int m = 4; // 여행 계획에 속한 도시의 수

    int[][] tour = {
        {0, 1, 0, 1, 1}
      , {1, 0, 1, 1, 0}
      , {0, 1, 0, 0, 0}
      , {1, 1, 0, 0, 0}
      , {1, 0, 0, 0, 0}
    }; // 임의의 두 여행지가 서로 연결되어 있지의 여부

    int[] plan = {1, 2, 3, 2}; // 여행 계획에 포함된 여행지의 번호들(계산 편의상 -1씩 차감됨)

    int idx = 0; // plan 행렬의 인덱스
    boolean isConn = false; // 길의 연결 여부
    String answer = "YES"; // 결과값 선언 및 초기화

    // 여행 계획 알고리즘
    while(idx <= plan.length) {
      // 길이 연결되어 있으면 연결
      if(tour[plan[idx]][plan[idx+1]] == 1) {
        isConn = true;
      // 길이 연결되어 있지 않다면 우회로를 찾아서 다른 길의 연결 여부를 탐색
      /* back을 안하고 다른 방법으로 우회로를 찾는 알고리즘을 구현해보자... */
      } else if(tour[plan[idx]][plan[idx+1]] == 0) {
        if(tour[plan[idx-1]][plan[idx+1]] == 1) {
          isConn = true;
        }
      }
      if(isConn == false) { // 길이 연결되어 있지 않으면 불가능으로 결론
        answer = "NO";
        break;
      }
      isConn = false; // 길이 연결되어 있으면 연결 여부 초기화 및 인덱스 증가
      idx++;
    }

    System.out.println(answer); // 결과값 출력
  }
}






////////////////////////////////////////////////////////////////////////////






import java.util.*;

public class Main {

    // 여행지의 개수와 여행 계획에 속한 여행지의 개수
    public static int n, m;
    public static int[] parent = new int[501]; // 부모 테이블 초기화

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Union 연산을 각각 수행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                if (x == 1) { // 연결된 경우 합집합(Union) 연산 수행
                    unionParent(i + 1, j + 1);
                }
            }
        }

        // 여행 계획 입력받기
        ArrayList<Integer> plan = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            plan.add(x);
        }

        boolean result = true;
        // 여행 계획에 속하는 모든 노드의 루트가 동일한지 확인
        for (int i = 0; i < m - 1; i++) {
            if (findParent(plan.get(i)) != findParent(plan.get(i + 1))) {
                result = false;
            }
        }

        // 여행 계획에 속하는 모든 노드가 서로 연결되어 있는지(루트가 동일한지) 확인
        if (result) System.out.println("YES");
        else System.out.println("NO");
    }
}
