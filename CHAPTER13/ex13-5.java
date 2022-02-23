/**
14-05. 연산자 끼워 넣기

=== 입력 예시 ===
2
5 6
0 0 1 0

=== 출력 예시 ===
30
30
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

    int max = 0; // 최대값
    int min = 0; // 최소값
    int xtemp = 0;
    int ntemp = 0;
    /* ToDo: 최대값을 내기 위해선 적어도 큰 수끼리 곱하기를 시켜야한다 */
    
    
    max = Math.max(max, xtemp); 

    /* ToDo: 최소값을 내기 위해선 적어도 큰 수끼리 나눗셈을 시켜야한다 */
    min = Math.min(min, ntemp); 

    /**
     최대값과 최소값이 항상 -10억보다 크거나 같고, 10억보다 작거나 같은 결과가 나오는 입력만 주어진다. 또한 앞에서부터 계산했을 떄, 중간에 계산되는 식의 결과도 항상 -10억보다 크거나 같고, 10억보다 작거나 같다.
    */
    System.out.println(); // 만들 수 있는 결과 식의 최대값
    System.out.println(); // 만들 수 있는 결과 식의 최소값
  }
}
