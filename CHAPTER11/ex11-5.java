/**
11-5. 볼링공 고르기

입력예시
=====
5 3
1 3 2 3 2

출력예시
=====
8
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 볼링공의 개수(1 <= n <= 1000)
    int m = sc.nextInt(); // 공의 최대 무게(1 <= m <= 10)

    int[] k = new int[n]; // 각 볼링공의 무게(1 <= k <= m)
    for(int i=0; i<k.length; i++) { k[i] = sc.nextInt(); }
    sc.close();

    int answer = n*(n-1)/2; // 중복되지 않는 볼링공을 고를때의 모든 경우의 수
    int temp = 0;

    for(int i=0; i<k.length; i++) {
      for(int j=temp; j<k.length; j++) {
        if((k[i] == k[j])) {
          answer--; // 무게가 서로 다른 볼링공을 골라야한다
          temp++;
        }
      }
    }

    System.out.println(answer);
  }
}
