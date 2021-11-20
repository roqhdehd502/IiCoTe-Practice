/*
7-3. 떡볶이 떡 만들기
=== 입력예시 ===
4 6
19 15 10 17
=== 출력예시 ===
15
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt(); // 떡의 개수
    int m = sc.nextInt(); // 손님이 가져가는 떡의 길이
    int h = 0; // 절단기에 지정된 높이
    int temp = 0; // 비교값
    int[] rc = new int[n]; // 떡

    for(int i=0; i<rc.length; i++) { rc[i] = sc.nextInt(); } // 각 떡의 길이 지정
    sc.close();

    // for(int i=0; i<rc.length; i++) { m += rc[i]-h; }
    while(true) {
      for(int i=0; i<rc.length; i++) { temp += rc[i]-h; }
      if(temp == m) {
        break;
      } else {
        h++;
      }
    }

    System.out.println(temp);
    System.out.println(h); // 절단기에 설정할 수 있는 높이의 최댓값
  }
}
