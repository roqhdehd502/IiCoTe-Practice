/**
12-05. 뱀

=== 입력예시 ===
6
3
3 4
2 5
5 3
3
3 D
15 L
17 D

=== 출력예시 ===
9
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 보드의 크기(2 <= n <= 100)
    int[][] b = new int[n][n]; // 보드(2D)
    b[0][0] = 1; // 뱀의 초기값 입력

    int k = sc.nextInt(); // 사과의 개수(0 <= k <= 100)
    int[] row = new int[k]; // 사과의 위치(행)
    int[] col = new int[k]; // 사과의 위치(열)
    for(int i=0; i<k; i++) {
      row[i] = sc.nextInt();
      col[i] = sc.nextInt();
      b[col[i]-1][row[i]-1] = -1; // 보드에 사과(-1) 위치 입력
    }

    int r = sc.nextInt(); // 뱀의 방향 변환 횟수(1 <= r <= 100)
    int[] x = new int[r];  // 지렁이가 회전하는 시간(0 <= x <= 10000)
    char[] c = new char[r];  // 왼쪽(L) 또는 오른쪽(D)으로 회전하는 정보
    for(int i=0; i<r; i++) {
      x[i] = sc.nextInt();
      c[i] = sc.next().charAt(0);
    }
    sc.close();

    int time = 0; // 지렁이가 살아있는 시간
    char dir = 'E'; // 지렁이가 움직이는 방향 초기값
    int idx = 0; // 임시 인덱스
    int rTemp = 0; // 임시 행 인덱스
    int cTemp = 0; // 임시 열 인덱스
    for(int i=0; i<10000; i++) { // 지렁이는 11시방향 끝 지점에서 오른쪽 방향으로 처음 이동한다
      if(time >= 1) { // 1초부터 지렁이의 위치가 변화하므로...
        if(time != x[idx]) { // 게임오버 조건
          if(rTemp+1 >= n) { // 벽에 충돌
            time++;
            break;
          } else if(rTemp-1 <= 0) {
            time++;
            break;
          } else if(cTemp >= n) {
            time++;
            break;
          } else if(cTemp <= 0) {
            time++;
            break;
          }
          if(b[cTemp+1][rTemp] == 1) { // 자기 꼬리와 충돌
            time++;
            break;
          } else if(b[cTemp-1][rTemp] == 1) {
            time++;
            break;
          } else if(b[cTemp][rTemp+1] == 1) {
            time++;
            break;
          } else if(b[cTemp][rTemp-1] == 1) {
            time++;
            break;
          }
        }

        if(b[cTemp+1][rTemp] == -1) { // 지렁이가 사과를 먹는 조건
          b[cTemp][rTemp] = 1;
          if(dir == 'E') { // 동쪽으로 이동
            rTemp++;
          } else if(dir == 'W') { // 서쪽으로 이동
            rTemp--;
          } else if(dir == 'S') { // 남쪽으로 이동
            cTemp++;
          } else if(dir == 'N') { // 북쪽으로 이동
            cTemp--;
          }
          b[cTemp][rTemp] = 1;
        } else if(b[cTemp-1][rTemp] == -1) {
          b[cTemp][rTemp] = 1;
          if(dir == 'E') { // 동쪽으로 이동
            rTemp++;
          } else if(dir == 'W') { // 서쪽으로 이동
            rTemp--;
          } else if(dir == 'S') { // 남쪽으로 이동
            cTemp++;
          } else if(dir == 'N') { // 북쪽으로 이동
            cTemp--;
          }
          b[cTemp][rTemp] = 1;
        } else if(b[cTemp][rTemp+1] == -1) {
          b[cTemp][rTemp] = 1;
          if(dir == 'E') { // 동쪽으로 이동
            rTemp++;
          } else if(dir == 'W') { // 서쪽으로 이동
            rTemp--;
          } else if(dir == 'S') { // 남쪽으로 이동
            cTemp++;
          } else if(dir == 'N') { // 북쪽으로 이동
            cTemp--;
          }
          b[cTemp][rTemp] = 1;    
        } else if(b[cTemp-1][rTemp-1] == -1) {
          b[cTemp][rTemp] = 1;
          if(dir == 'E') { // 동쪽으로 이동
            rTemp++;
          } else if(dir == 'W') { // 서쪽으로 이동
            rTemp--;
          } else if(dir == 'S') { // 남쪽으로 이동
            cTemp++;
          } else if(dir == 'N') { // 북쪽으로 이동
            cTemp--;
          }
          b[cTemp][rTemp] = 1;       
        } else { // 사과를 먹지 않으면 평소처럼 이동한다
          b[cTemp][rTemp] = 0;
          if(dir == 'E') { // 동쪽으로 이동
            rTemp++;
          } else if(dir == 'W') { // 서쪽으로 이동
            rTemp--;
          } else if(dir == 'S') { // 남쪽으로 이동
            cTemp++;
          } else if(dir == 'N') { // 북쪽으로 이동
            cTemp--;
          }
          b[cTemp][rTemp] = 1;
        }
      }    

      if(time == x[idx]) { // 특정 시간이 될 때 방향이 변하는 조건
        if(c[idx] == 'L') { // 왼쪽으로 방향전환
          if(dir == 'E') {
            dir = 'N';
          } else if(dir == 'W') {
            dir = 'S';
          } else if(dir == 'S') {
            dir = 'E';
          } else if(dir == 'N') {
            dir = 'W';
          }
        } else if(c[idx] == 'D') { // 오른쪽으로 방향전환
          if(dir == 'E') {
            dir = 'S';
          } else if(dir == 'W') {
            dir = 'N';
          } else if(dir == 'S') {
            dir = 'W';
          } else if(dir == 'N') {
            dir = 'E';
          }
        }
        idx++;
      }
      time++;
    }

    System.out.println(time); // 게임이 끝나는 시간(초)
  }
}






///////////////////////////////////////////////////////////////






import java.util.*;

class Node {

    private int time;
    private char direction;

    public Node(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }

    public int getTime() {
        return this.time;
    }

    public char getDirection() {
        return this.direction;
    }
}

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

    public static int n, k, l;
    public static int[][] arr = new int[101][101]; // 맵 정보
    public static ArrayList<Node> info = new ArrayList<>(); // 방향 회전 정보

    // 처음에는 오른쪽을 보고 있으므로(동, 남, 서, 북)
    public static int dx[] = {0, 1, 0, -1};
    public static int dy[] = {1, 0, -1, 0};

    public static int turn(int direction, char c) {
        if (c == 'L') direction = (direction == 0)? 3 : direction - 1;
        else direction = (direction + 1) % 4;
        return direction;
    }

    public static int simulate() {
        int x = 1, y = 1; // 뱀의 머리 위치
        arr[x][y] = 2; // 뱀이 존재하는 위치는 2로 표시
        int direction = 0; // 처음에는 동쪽을 보고 있음
        int time = 0; // 시작한 뒤에 지난 '초' 시간
        int index = 0; // 다음에 회전할 정보
        // 뱀이 차지하고 있는 위치 정보(꼬리가 앞쪽)
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y));
        
        while (true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            // 맵 범위 안에 있고, 뱀의 몸통이 없는 위치라면
            if (1 <= nx && nx <= n && 1 <= ny && ny <= n && arr[nx][ny] != 2) {
                // 사과가 없다면 이동 후에 꼬리 제거
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = 2;
                    q.offer(new Position(nx, ny));
                    Position prev = q.poll();
                    arr[prev.getX()][prev.getY()] = 0;
                }
                // 사과가 있다면 이동 후에 꼬리 그대로 두기
                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = 2;
                    q.offer(new Position(nx, ny));
                }
            }
            // 벽이나 뱀의 몸통과 부딪혔다면
            else {
                time += 1;
                break;
            }
            // 다음 위치로 머리를 이동
            x = nx;
            y = ny;
            time += 1;
            if (index < l && time == info.get(index).getTime()) { // 회전할 시간인 경우 회전
                direction = turn(direction, info.get(index).getDirection());
                index += 1;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        k = sc.nextInt();

        // 맵 정보(사과 있는 곳은 1로 표시)
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
        }

        // 방향 회전 정보 입력
        l = sc.nextInt();
        for (int i = 0; i < l; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            info.add(new Node(x, c));
        }
  
        System.out.println(simulate());
    }

}
