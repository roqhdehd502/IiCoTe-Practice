/**
11-3. 문자열 뒤집기

입력예시
=====
0001100

출력예시
=====
1
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("문자열의 길이 설정");
    int n = sc.nextInt();
    int[] a = new int[n];
    int oCnt = 0;
    int zCnt = 0;

    System.out.println("문자열의 내용 입력");
    for(int i=0; i<a.length; i++) { a[i] = sc.nextInt(); }
    sc.close();

    for(int i=0; i<a.length; i++) {
      if(a[i] == 1) {
        if(i>=1 && a[i-1] == a[i]) {
          continue;
        } else {
          oCnt++;
        }
      } else if(a[i] == 0) {
        if(i>=1 && a[i-1] == a[i]) {
          continue;
        } else {
          zCnt++;
        }
      }
    }

    if(oCnt < zCnt) {
      System.out.println(oCnt);
    } else {
      System.out.println(zCnt);
    }
  }
}
