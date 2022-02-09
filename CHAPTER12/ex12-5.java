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
    int[][] b = new int[n][n];

    int k = sc.nextInt(); // 사과의 개수(0 <= k <= 100)

    int[] row = new int[k]; // 지렁이의 위치(행)
    int[] col = new int[k]; // 지렁이의 위치(열)
    for(int i=0; i<k; i++) {
      row[i] = sc.nextInt();
      col[i] = sc.nextInt();
    }

    int r = sc.nextInt(); // 뱀의 방향 변환 횟수(1 <= r <= 100)
    int[] x = new int[r];  // 게임 시작 부터 지렁이가 주기적으로 회전하는 시간(0 <= x <= 10000)
    char[] c = new char[r];  // 왼쪽(l) 또는 오른쪽(r)으로 회전하는 정보
    for(int i=0; i<r; i++) {
      x[i] = sc.nextInt();
      c[i] = sc.next().charAt(0);
    }
    sc.close();

    for(int i=0; i<n*n; i++) {

    }
  }
}
