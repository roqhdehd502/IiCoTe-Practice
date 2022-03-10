/**
15-01. 정렬된 배열에서 특정 수의 개수 구하기

=== 입력 예시.1 ===
7 2
1 1 2 2 2 2 3

=== 출력 예시.1 ===
4

=== 입력 예시.2 ===
7 4
1 1 2 2 2 2 3

=== 출력 예시.2 ===
-1
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 수열의 개수
    int x = sc.nextInt(); // 탐색할 수열내 원소

    int[] arr = new int[n]; // 수열
    for(int i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }
    sc.close();

    long beforeTime = System.nanoTime();
    
    int cnt = 0; // 탐색할 수열내 원소의 개수
    for(int i=0; i<arr.length; i++) {
      if(arr[i] > x) { break; } // 탐색하고자 하는 원소의 범위를 벗어났다면 반복문 탈출
      if(arr[i] == x) { cnt++; } // 해당되는 원소일 때 개수 추가
    }
    
    System.out.println(cnt <= 0 ? -1 : cnt); // 값이 x인 원소가 하나도 없으면 -1 출력
    
    long afterTime = System.nanoTime(); 
    long secDiffTime = afterTime - beforeTime;
    System.out.println("시간차이 : " + secDiffTime);
  }
}
