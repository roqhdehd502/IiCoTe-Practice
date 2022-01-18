/**
11-7. 럭키 스트레이트
=== 입력 예시.1 ===
123402
=== 출력 예시.1 ===
LUCKY
=== 입력 예시.2 ===
7755
=== 출력 예시.2 ===
READY
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String n = sc.nextLine(); // 점수
    sc.close();

    char[] arr = new char[n.length()];
    for(int i=0; i<arr.length; i++) { arr[i] = n.charAt(i); }

    int left = 0;
    int right = 0;
    if(n.length()%2 == 0) {
      for(int i=0; i<arr.length/2; i++) { left += Character.getNumericValue(arr[i]); }
      for(int i=arr.length/2; i<arr.length; i++) { right += Character.getNumericValue(arr[i]); }

      if(left == right) {
        System.out.println("LUCKY");
      } else {
        System.out.println("READY");
      }
    }
  }
}
