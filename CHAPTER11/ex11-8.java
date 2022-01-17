/**
11-8. 문자열 재정렬

=== 입력 예시.1 ===
K1KA5CB7

=== 출력 예시.1 ===
ABCKK13

=== 입력 예시.2 ===
AJKDLSI412K4JSJ9D

=== 출력 예시.2 ===
ADDIJJJKKLSS20
*/

import java.util.Scanner;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.nextLine();
    sc.close();

    char[] arr = new char[s.length()];
    String str = new String[s.length()];
    int[] num = new int[s.length()];

    String num_ptrn = "^[0-9]*$"; // 숫자 패턴
    

    for(int i=0; i<arr.length; i++) { 
      arr[i] = s.charAt(i);

      if() {
        str[i] = Character.toString(arr[i]);
      } else if() {
        
        num[i] = Character.getNumericValue(arr[i]);
      }
    }
    
    Arrays.sort(str);
    Arrays.sort(num); 

    for(int i=0; i<str.length; i++) { System.out.print(str[i]); }
    for(int i=0; i<num.length; i++) { System.out.print(num[i]); }
  }
}
