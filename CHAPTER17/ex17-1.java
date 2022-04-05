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
