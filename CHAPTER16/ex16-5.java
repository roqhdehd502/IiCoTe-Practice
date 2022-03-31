/**
16-05. 못생긴 수

=== 입력 예시 1 ===
10

=== 출력 예시 1 ===
12

=== 입력 예시 2 ===
4

=== 출력 예시 2 ===
4
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt(); // n번째 수 입력
    sc.close();

    int seq = 1; // 시퀀스
    int cnt = 1; // 조건이 만족될 때 카운팅 되는 수
    ArrayList<Integer> uglyNum = new ArrayList<>(); // 못생긴 수
    while(cnt <= n) {
      /* 못생긴 수를 추가하는 조건문 */
      if(seq == 1 || seq % 2 == 0 || seq % 3 == 0 || seq % 5 == 0) {
        uglyNum.add(seq);
        cnt++;
      }
      seq++;
    }

    System.out.println(uglyNum.get(n-1)); // 결과값 출력
  }
}
