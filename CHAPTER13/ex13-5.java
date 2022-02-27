/**
13-05. 연산자 끼워 넣기

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






////////////////////////////////////////////////////////////////////////////////////






import java.util.*;

public class Main {

    public static int n;
    // 연산을 수행하고자 하는 수 리스트
    public static ArrayList<Integer> arr = new ArrayList<>();
    // 더하기, 빼기, 곱하기, 나누기 연산자 개수
    public static int add, sub, mul, divi;
    
    // 최솟값과 최댓값 초기화
    public static int minValue = (int) 1e9;
    public static int maxValue = (int) -1e9;

    // 깊이 우선 탐색 (DFS) 메서드
    public static void dfs(int i, int now) {
        // 모든 연산자를 다 사용한 경우, 최솟값과 최댓값 업데이트
        if (i == n) {
            minValue = Math.min(minValue, now);
            maxValue = Math.max(maxValue, now);
        }
        else {
            // 각 연산자에 대하여 재귀적으로 수행
            if (add > 0) {
                add -= 1;
                dfs(i + 1, now + arr.get(i));
                add += 1;
            }
            if (sub > 0) {
                sub -= 1;
                dfs(i + 1, now - arr.get(i));
                sub += 1;
            }
            if (mul > 0) {
                mul -= 1;
                dfs(i + 1, now * arr.get(i));
                mul += 1;
            }
            if (divi > 0) {
                divi -= 1;
                dfs(i + 1, now / arr.get(i));
                divi += 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr.add(x);
        }

        add = sc.nextInt();
        sub = sc.nextInt();
        mul = sc.nextInt();
        divi = sc.nextInt();

        // DFS 메서드 호출
        dfs(1, arr.get(0));

        // 최댓값과 최솟값 차례대로 출력
        System.out.println(maxValue);
        System.out.println(minValue);
    }
}
