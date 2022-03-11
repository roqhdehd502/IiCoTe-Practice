/**
15-02. 고정점 찾기

=== 입력 예시.1 ===
5
-15 -6 1 3 7

=== 출력 예시.1 ===
3

=== 입력 예시.2 ===
7
-15 -4 2 8 9 13 15

=== 출력 예시.2 ===
2

=== 입력 예시.3 ===
7
-15 -4 3 8 9 13 15

=== 출력 예시.3 ===
-1
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 수열의 크기 지정

    int temp = (int)10E+9;
    int[] arr = new int[n]; // 수열
    for(int i=0; i<n; i++) { 
      arr[i] = sc.nextInt();
      if(arr[i] >= 0) { temp = Math.min(temp, arr[i]); } // 탐색 시작점 위치 지정
    }
    sc.close();

    int result = -1;
    for(int i=temp; i<arr.length; i++) {
      if(i == arr[i]) { 
        result = arr[i];
        break; // 고정점 탐색이 되면 루프문 종료
      }
    }

    System.out.println(result);
  }
}
