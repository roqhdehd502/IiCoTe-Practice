/**
12-04. 자물쇠와 열쇠

=== 입력예시 ===
key : [[0, 0, 0], [1, 0, 0], [0, 1, 1]]
lock : [[1, 1, 1], [1, 1, 0], [1, 0, 1]]

=== 출력예시 ===
result : true

※ key를 시계 방향으로 90도 회전하고, 오른쪽으로 한 칸, 아래로 한칸 이동하면 lock의 홈 부분을 정확히 모두 채울 수 있습니다.
*/

import java.util.Scanner;
import java.util.Random;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    
    int m = sc.nextInt(); // key의 한 변 크기 (m은 항상 n이하)
    int n = sc.nextInt(); // lock의 한 변 크기
    
    int[][] key = new int[m][m];
    int[][] lock = new int[n][n];

    for(int i=0; i<m; i++) { // 0은 홈이 들어간 부분, 1은 돌기가 튀어나온 부분
      for(int j=0; j<m; j++) {
        key[i][j] = rand.nextInt(1);
      }
    }
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        lock[i][j] = rand.nextInt(1);
      }
    }

    sc.close();
  }
}
