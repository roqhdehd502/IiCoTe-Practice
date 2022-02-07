/**
12-3. 문자열 압축
=== 입력 예시.1 ===
aabbaccc
=== 출력 예시.1 ===
7
=== 입력 예시.2 ===
ababcdcdababcdcd
=== 출력 예시.2 ===
9
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    //Scanner sc = new Scanner(System.in);
    
    String s = "aabbaccc";
    // String s = sc.nextLine(); // 입력되는 문자열
    // sc.close();
    char[] cArr = s.toCharArray(); // 문자열을 문자 배열로 변환
    ArrayList<Object> cTemp = new ArrayList<>(); // 임시로 담을 문자

    for(int i=1; i<cArr.length; i++) {
      if(cArr[i-1] != cArr[i]) {
        cTemp.add(cArr[i]);
      }
    }
    
    System.out.println(cTemp);
    System.out.println(cTemp.size());
  }
}
