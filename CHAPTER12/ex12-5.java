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
      if(rTemp+1 >= n) { // 게임오버 조건(벽에 충돌)
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

      // if(b[cTemp][rTemp]) { // 게임오버 조건(자기 꼬리와 충돌)
      //  break;
      // }

      if(time >= 1) { // 1초부터 지렁이의 위치가 변화하므로...
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
      

      // if(b[cTemp][rTemp] == -1) { // 지렁이가 사과를 먹는 조건

      // }

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
