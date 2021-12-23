/**
11-2. 곱하기 혹은 더하기

입력예시1
=====
02984

출력예시1
=====
576

입력예시2
=====
567

출력예시2
=====
210

입력예시3
=====
33012

출력예시3
=====
27
*/

import java.util.Scanner;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("배열의 크기 지정");
    int n = sc.nextInt();
    int[] s = new int[n];
    int temp = 0;

    System.out.println("배열의 인덱스 속성값 입력");
    for(int i=0; i<s.length; i++) { s[i] = sc.nextInt(); }
    sc.close();

    Arrays.sort(s); // 최댓값을 만들려면 가능한 0과 1같은 작은 수끼리 더하게 유도한다
    for(int i=0; i<s.length; i++) {
      if(i == 0) {
        temp = s[i];
      } else if(i>=1 && (s[i-1] == 0 || s[i-1] == 1)) {
        temp += s[i];      
      } else {
        temp *= s[i];
      }
    }

    System.out.println(temp);
  }
}
