/*
7-1. 떡볶이 떡 만들기: 문제 설명
오늘 동빈이는 여행 가신 부모님을 대신해서 떡집 일을 하기로 했다. 오늘은 떡볶이 떡을 만드는 날이다.
동빈이네 떡볶이 떡은 재밌게도 떡볶이 떡의 길이가 일정하지 않다. 대신에 한봉지 안에 들어가는
떡의 총 길이는 절단기로 잘라서 맞춰준다.
절단기에 높이(H) 를 지정하면 줄지어진 떡을 한 번에 절단한다. 높이가 H보다 긴 떡은 H 위의 부분이
잘릴 것이고, 낮은 떡은 잘리지 않는다.
예를 들어 높이가 19, 14, 10, 17cm인 떡이 나란히 있고 절단기 높이를 15cm로 지정하면 자른 뒤
떡의 높이는 15, 14, 10, 15cm가 될 것이다. 잘린 떡의 길이는 차례대로 4, 0, 0, 2cm이다.
손님은 6cm만큼의 길이를 가져간다.
손님이 왔을 때 요청한 총 길이가 M일 때 적어도 M만큼의 떡을 얻기 위해 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하세요

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
    int temp = 0;

    int[] rc = new int[n]; // 떡
    for(int i=0; i<rc.length; i++) { rc[i] = sc.nextInt(); } // 각 떡의 길이 지정
    sc.close();

    // for(int i=0; i<rc.length; i++) {
    //   if(rc[i] > h) {
    //     rc[i] -= h;
    //     m += rc[i];
    //   } else {
    //     rc[i] = 0;
    //     m += rc[i];
    //   }
    // }

    // System.out.println(m); // 이게 6이 나와야 한다면...

    System.out.println(h); // 절단기에 설정할 수 있는 높이의 최댓값
  }
}
