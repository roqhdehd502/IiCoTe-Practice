/*
7-2. 부품 찾기
=== 입력예시 ===
5
8 3 7 9 2
3 
5 7 9
=== 출력예시 ===
no yes yes
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    int arr1[] = new int[n];
    for(int i=0; i<arr1.length; i++) { arr1[i] = sc.nextInt(); }

    int m = sc.nextInt();
    int arr2[] = new int[m];
    for(int i=0; i<arr2.length; i++) { arr2[i] = sc.nextInt(); }
    sc.close();

    int cnt = 0;

    for(int i=0; i<arr2.length; i++) {
      for(int j=0; j<arr1.length; j++) {
        if(arr2[i] == arr1[j]) { cnt++; }
      }

      if(cnt >= 1) { 
        System.out.print("yes "); 
      } else {
        System.out.print("no "); 
      }

      cnt = 0;
    }
  }
}
