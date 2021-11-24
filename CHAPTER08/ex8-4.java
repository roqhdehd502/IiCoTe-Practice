/*
8-4. 바닥 공사

입력예시
=====
3

출력예시
=====
5
*/

/*
총 경우의 수 = (서로 대칭성을 가지는 경우의 수 * 2) + (대칭성이 없는 경우의 수)
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.close();
    
    int[] d = new int[1001];

    d[1] = 3;
    d[2] = 3;
    for(int i=3; i<n+1; i++) { d[i] = (d[i-1]+2 * d[i-2]) % 796796; }

    System.out.println(d[n]); // 방법의 수를 796796으로 나눈 나머지
  }
}
