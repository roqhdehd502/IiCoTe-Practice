/**
13-03. 경쟁적 전염

=== 입력예시 ===
3 3
1 0 2
0 0 0
3 0 0
2 3 2

=== 출력예시 ===
3
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 시험관의 크기
    int k = sc.nextInt(); // 바이러스의 종류
    int[][] arr = new int[n][n]; // 시험관의 필드
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    int s = sc.nextInt(); // 특정 시간
    int x = sc.nextInt()-1; // s초가 지난 후 해당 위치(x)
    int y = sc.nextInt()-1; // s초가 지난 후 해당 위치(y)
    sc.close();

    for(int i=0; i<s; i++) { // s초 시점까지 감염
      for(int j=0; j<k; j++) { // k종의 바이러스 탐색
        infest(arr, n, j);
      }
    }

    System.out.println();
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
    System.out.println(arr[y][x]); // 결과값 출력
  }

  private static int[][] infest(int[][] arr, int n, int k) { // 감염 알고리즘
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) { /* TODO: break가 걸리는 지점을 강구해서 코드를 개량할 것... */
        if(arr[i][j] == k) {
          if(i-1 >= 0) {
            if(arr[i-1][j] == 0) {
              arr[i-1][j] = arr[i][j];
            }
          }
          if(i+1 < n) {
            if(arr[i+1][j] == 0) {
              arr[i+1][j] = arr[i][j];
            }
          }
          if(j-1 >= 0) {
            if(arr[i][j-1] == 0) {
              arr[i][j-1] = arr[i][j];
            }
          } 
          if(j+1 < n) {
            if(arr[i][j+1] == 0) {
              arr[i][j+1] = arr[i][j];
            }
          }
          break;
        }
      }
    }

    return arr;
  }
}
