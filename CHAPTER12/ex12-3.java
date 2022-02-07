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

public class Main {
  public static void main(String[] args) {
    int cnt = 0;
    String temp = "";
    String s = "aaaabbb"; // => 4a3b(4)

    for(int i=0; i<s.length(); i++) {
      if(i >= s.length()-1) {
        if(s.indexOf(i) == s.indexOf(i-1)) {
          cnt++;
          temp += Integer.toString(cnt);
          temp += String.valueOf(s.charAt(i));
        } else {
          temp += Integer.toString(cnt);
          temp += String.valueOf(s.charAt(i));
        }
      } else {
        if(s.indexOf(i) == s.indexOf(i+1)) {
          cnt++;
        } else {
          temp += Integer.toString(cnt);
          temp += String.valueOf(s.charAt(i));
          cnt = 0;
        }
      }
    }

    System.out.println(temp);
    System.out.println(temp.length());
  }
}
