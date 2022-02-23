/**
14-05. 연산자 끼워 넣기

=== 입력 예시 ===
6
1 2 3 4 5 6
2 1 1 1

=== 출력 예시 ===
54 (1 - 2 / 3 + 4 + 5 * 6)
-24 (1 + 2 + 3 - 4 * 5 / 6)
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 수의 개수(2 <= n <= 11)
    int[] seq = new int[n]; // 수열(1 <= Ai <= 100)
    for(int i=0; i<seq.length; i++) { seq[i] = sc.nextInt(); }
    int plus = sc.nextInt(); // 덧셈의 개수
    int minus = sc.nextInt(); // 뺄셈의 개수
    int times = sc.nextInt(); // 곱셈의 개수
    int div = sc.nextInt(); // 나눗셈의 개수
    sc.close();

    int temp = 0;
    int ptemp = plus;
    int mtemp = minus;
    int ttemp = times;
    int dtemp = div;
    int max = 0; // 최대값
    int min = 0; // 최소값
    int i=0;
    
    while(i != n-1) {
      while(mtemp != 0) { // 뺄셈
        if(i == n-1) {
          max -= seq[n-1];
          mtemp--;
          System.out.println("minus:" + max);
        } else if(i >= 0) {
          temp = seq[i] - seq[i+1];
          max += temp;
          mtemp--;
          if(i+1 != n-1) { 
            i = i+2; 
          } else if(i+1 == n-1) {
            i++;
          }
          System.out.println("minus:" + max);
        }
      }
      while(dtemp != 0) { // 나눗셈
        if(i == n-1) {
          max /= seq[n-1];
          dtemp--;
          System.out.println("div:" + max);
        } else if(i >= 0) {
          temp = seq[i] / seq[i+1];
          max += temp;
          dtemp--;
          if(i+1 != n-1) { 
            i = i+2; 
          } else if(i+1 == n-1) {
            i++;
          }
          System.out.println("div:" + max);
        }
      }  
      while(ptemp != 0) { // 덧셈
        if(i == n-1) {
          max += seq[n-1];
          ptemp--;
          System.out.println("plus:" + max);
        } else if(i >= 0) {
          temp = seq[i] + seq[i+1];
          max += temp;
          ptemp--;
          if(i+1 != n-1) { 
            i = i+2; 
          } else if(i+1 == n-1) {
            i++;
          }
          System.out.println("plus:" + max);
        }
      }
      while(ttemp != 0) { // 곱셈
        if(i == n-1) {
          max *= seq[n-1];
          ttemp--;
          System.out.println("times:" + max);
        } else if(i >= 0) {
          temp = seq[i] * seq[i+1];
          max += temp;
          ttemp--;
          if(i+1 != n-1) { 
            i = i+2; 
          } else if(i+1 == n-1) {
            i++;
          }
          System.out.println("times:" + max);
        }
      }
    }    
    
    i=0;
    System.out.println("==========================================");

    while(i != n-1) {
      while(times != 0) { // 곱하기
        if(i == n-1) {
          min *= seq[n-1];
          times--;
          System.out.println("times:" + min);
        } else if(i >= 0) {
          temp = seq[i] * seq[i+1];
          min += temp;
          times--;
          if(i+1 != n-1) { 
            i = i+2; 
          } else if(i+1 == n-1) {
            i++;
          }
          System.out.println("times:" + min);
        }
      }
      while(plus != 0) { // 덧셈
        if(i == n-1) {
          min += seq[n-1];
          plus--;
          System.out.println("plus:" + min);
        } else if(i >= 0) {
          temp = seq[i] + seq[i+1];
          min += temp;
          plus--;
          if(i+1 != n-1) { 
            i = i+2; 
          } else if(i+1 == n-1) {
            i++;
          }
          System.out.println("plus:" + min);
        }
      }
      while(minus != 0) { // 뺄셈
        if(i == n-1) {
          min -= seq[n-1];
          minus--;
          System.out.println("minus:" + min);
        } else if(i >= 0) {
          temp = seq[i] - seq[i+1];
          min += temp;
          minus--;
          if(i+1 != n-1) { 
            i = i+2; 
          } else if(i+1 == n-1) {
            i++;
          }
          System.out.println("minus:" + min);
        }
      }
      while(div != 0) { // 나눗셈
        if(i == n-1) {
          min /= seq[n-1];
          div--;
          System.out.println("div:" + min);
        } else if(i >= 0) {
          temp = seq[i] / seq[i+1];
          min += temp;
          div--;
          if(i+1 != n-1) { 
            i = i+2; 
          } else if(i+1 == n-1) {
            i++;
          }
          System.out.println("div:" + min);
        }
      }
    }
    
    System.out.println(max); // 만들 수 있는 결과 식의 최대값
    System.out.println(min); // 만들 수 있는 결과 식의 최소값
  }
}
