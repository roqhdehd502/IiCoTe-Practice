/**
18-02. 탑승구

=== 입력 예시 1 ===
4
3
4
1
1

=== 출력 예시 1 ===
2

=== 입력 예시 2 ===
4
6
2
2
3
3
4
4

=== 출력 예시 2 ===
3
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int g = sc.nextInt(); // 탑승구의 수
    int p = sc.nextInt(); // 비행기의 수

    int[] gi = new int[p]; // 각 비행기가 도킹할 수 있는 탑승구의 정보
    for(int i=0; i<gi.length; i++) { gi[i] = sc.nextInt()-1; }
    
    sc.close();

    int result = 0; // 결과값
    int[] gn = new int[g]; // 탑승구의 순번    
    int[] pn = new int[p]; // 비행기의 순번

    /* 탑승구 알고리즘 */
    for(int i=0; i<p; i++) {
      for(int j=0; j<g; j++) {
        if(gn[j] == 0 && pn[i] == 0) {
          if(gi[i] == j) {
            result++;
            gn[j] = 1;
            pn[i] = 1;
          }
        }
      }
    }

    System.out.println(result); // 결과값 출력
  }
}
