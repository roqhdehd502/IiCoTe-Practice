/*
6-4. 두 배열의 원소 교체
*/

import java.util.Arrays;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    
    int[] a = new int[n];
    int[] b = new int[n];
    
    int temp  = 0;
    int sum = 0;

    for(int i = 0; i<n; i++) { a[i] = sc.nextInt(); }
    for(int i = 0; i<n; i++) { b[i] = sc.nextInt(); } 
    sc.close();

    Arrays.sort(a);
    Arrays.sort(b);

    for(int i=0; i<k; i++) {
      if(a[i] < b[b.length-i-1]) {
        temp = a[i];
        a[i] = b[b.length-i-1];
        b[b.length-i-1] = temp;
      } else {
        break;
      }
    }

    for(int i=0; i<n; i++) { sum += a[i]; }

    System.out.println(sum);
  }
}
