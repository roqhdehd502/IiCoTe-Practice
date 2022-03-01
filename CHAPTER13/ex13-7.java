/**
13-07. 인구 이동

=== 입력 예시 ===
2 20 50
50 30
20 40

=== 출력 예시 ===
1
*/

import java.util.*;

class Position {
  private int x;
  private int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }
}


public class Main {
  // 땅의 크기(n), l, r 값을 입력받기
  public static int n, l, r;
  // 결과값을 출력할 변수 선언 및 초기화하기
  public static int totalCount = 0;

  // 전체 나라의 정보(N * N)를 입력받기
  public static int[][] graph = new int[50][50];
  public static int[][] unions = new int[50][50];

  // x축과 y축의 이동을 하기 위한 배열 선언 및 원소값 초기화
  public static int[] dx = {-1, 0, 1, 0};
  public static int[] dy = {0, -1, 0, -1};

  // 인구 이동을 하기 위한 알고리즘
  public static void process(int x, int y, int index) {
    // (x, y)의 위치와 연결된 나라(연합) 정보를 담는 리스트
    ArrayList<Position> united = new ArrayList<>();
    united.add(new Position(x, y));
    // 너비 우선 탐색을 위한 큐 라이브러리 사용
    Queue<Position> q = new LinkedList<>();
    q.offer(new Position(x, y));
    unions[x][y] = index; // 현재 연합의 번호 할당
    int summary = graph[x][y]; // 현재 엽한의 전체 인구 수
    int count = 1; // 현재 연합의 국가 수
    // 큐가 빌 때까지 반복
    while(!q.empty) {
      Position pos = q.poll();
      x = pos.getX();
      y = pos.getY();
      // 현재 위치에서 4가지 방향을 확인하며
      for(int i=0; i<4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        // 바로 옆에 있는 나라를 확인하여
        if(0 <= nx && nx < n && 0 <= ny && ny < n && unions[nx][ny] == -1) {
          // 옆에 있는 나라와 인구 차이가 l명 이상, r명 이하라면
          int gap = Math.abs(graph[nx][ny] - graph[x][y]);
          if (l <= gap && gat <= r) {
            q.offer(new Position(nx, ny));
            // 연합에 추가하기
            unions[nx][ny] = index;
            summary += graph[nx][ny];
            count += 1;
            united.add(new Position(nx, ny));
          }
        }
      }
    }
    // 연합 국가끼리 인구를 분배
    for(int i=0; i<united.size(); i++) {
      x = united.get(i).getX();
      y = united.get(i).getY();
    }
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    l = sc.nextInt();
    r = sc.nextInt();

    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        graph[i][j] = sc.nextInt();
      }
    }
    sc.close();

    // 더 이상 인구 이동을 할 수 없을 때까지 반복
    while(true) {
      for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
          unions[i][j] = -1;
        }
      }
      int index = 0;
      for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
          if(unions[i][j] == -1) { // 해당 나라가 아직 처리되지 않았다면
            process(i, j, index);
            index += 1;
          }
        }
      }
      // 모든 인구 이동이 끝난 경우
      if(index == n*n) { break; n}
      totalCount += 1;
    }

    System.out.println(totalCount); // 결과값 출력
  }
}
