/**
16-04. 병사 배치하기

=== 입력 예시 ===
7
15 11 4 8 5 2 4

=== 출력 예시 ===
2
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int[] sldr = new int[n];
    for(int i=0; i<sldr.length; i++) { sldr[i] = sc.nextInt(); }
    sc.close();

    int cnt = 0;
    for(int i=0; i<sldr.length; i++) {
      if(i == sldr.length-1) { continue; }
      if(sldr[i] < sldr[i+1]) { cnt++; }
    }

    System.out.println(cnt);
  }
}
