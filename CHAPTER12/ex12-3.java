/**
12-3. 문자열 압축
=== 입력 예시.1 ===
aabbaccc
=== 출력 예시.1 ===
2a2ba3c => 7
=== 입력 예시.2 ===
ababcdcdababcdcd
=== 출력 예시.2 ===
2ab2cd2ab2cd => 9
=== 입력 예시.3 ===
abcabcdede
=== 출력 예시.3 ===
2abcdede => 8 (같은 문자열의 갯수로 자른다)
*/

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    //Scanner sc = new Scanner(System.in);
    
    String s = "ababcdcdababcdcd";
    // String s = sc.nextLine(); // 입력되는 문자열
    // sc.close();
    String sTemp1 = "";
    String sTemp2 = "";

    for(int i=1; i<s.length(); i++) {
      if(s.charAt(i-1) != s.charAt(i)) {
        if(sTemp1.contains(sTemp2)) { // 
          sTemp1 = "ababcdcd";
          sTemp2 = "";
        }
      }
    }
  }
}
