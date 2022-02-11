/**
12-07. 치킨 배달

=== 입력 예시 ===
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2

=== 출력 예시 ===
5
*/

import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 크기 입력
    int m = sc.nextInt(); // 폐업시키지 않을 치킨집의 최대 개수

    ArrayList<Integer> r1 = new ArrayList<>(); // 행
    ArrayList<Integer> c1 = new ArrayList<>(); // 열
    ArrayList<Integer> r2 = new ArrayList<>();
    ArrayList<Integer> c2 = new ArrayList<>();

    int[][] arr = new int[n][n]; // 도시 
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        arr[i][j] = sc.nextInt(); // 도시의 정보(0: 빈칸, 1: 집, 2: 치킨집)

        if(arr[i][j] == 1) { // 집
          r1.add(j+1);
          c1.add(i+1);
          //distance(r1, r2, c1, c2);
        } else if(arr[i][j] == 2) { // 치킨 집
          r2.add(j+1);
          c2.add(i+1);
        }
      }
    }
    sc.close();

    /* ToDo: 각 행과 열의 값 간의 거리를 계산 후 최솟값 산출하기*/
    

  }

  
  private static int distance(int r1, int r2, int c1, int c2) {
    return Math.abs(r1-r2) + Math.abs(c1-c2);
  }
}
