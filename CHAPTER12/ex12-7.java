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
        } else if(arr[i][j] == 2) { // 치킨 집
          r2.add(j+1);
          c2.add(i+1);
        }
      }
    }
    sc.close();

    /* ToDo: 각 행과 열의 값 간의 거리를 계산 후 최솟값 산출하기*/
    int temp1 = 0;
    int temp2 = 0;
    ArrayList<Integer> cd = new ArrayList<>(); // 치킨 거리 
    for(int i; i<c2.size(); i++) {
      for(int j; j<c1.size(); j++) {
        distance(r1.get(j), r2.get(i), c1.get(j), c2.get(i));
      }
      cd.add(Math.min(temp1, temp2)); // 해당 최솟값을 산출(치킨 거리)
    }

    int sum = 0;
    for(int i : cd) { sum += cd; } // 도시의 치킨 거리
    System.out.println(sum); // 결과값 출력
  }
  
  private static int distance(int r1, int r2, int c1, int c2) {
    return Math.abs(r1-r2) + Math.abs(c1-c2);
  }
}
