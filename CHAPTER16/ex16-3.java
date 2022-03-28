/**
16-03. 퇴사

=== 입력 예시 ===
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200

=== 출력 예시 ===
45
*/

import java.util.*;

class Benefit {
  private int time;
  private int price;

  public Benefit(int time, int price) {
    this.time = time;
    this.price = price;
  }

  public int getTime() {
    return time;
  }

  public int getPrice() {
    return price;
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int tTemp = 0;
    int pTemp = 0;
    HashMap<Integer, Benefit> quit = new HashMap<Integer, Benefit>();
    for(int i=1; i<=n; i++) {
      tTemp = sc.nextInt();
      pTemp = sc.nextInt();
      quit.put(i, new Benefit(tTemp , pTemp));
    }
    sc.close();

    /*
    선택 기준 = Math.min((Ti / Pi), (Ti+1 / Pi+1))
    */
  }
}




///////////////////////////////////////////////////////////////////





mport java.util.*;

public class Main {
	
    static int n; // 전체 상담 개수
    static int[] t = new int[15]; // 각 상담을 완료하는데 걸리는 기간
    static int[] p = new int[15]; // 각 상담을 완료했을 때 받을 수 있는 금액
    static int[] dp = new int[16]; // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
    static int maxValue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        // 배열을 뒤에서부터 거꾸로 확인
        for (int i = n - 1; i >= 0; i--) {
            int time = t[i] + i;
            // 상담이 기간 안에 끝나는 경우
            if (time <= n) {
                // 점화식에 맞게, 현재까지의 최고 이익 계산
                dp[i] = Math.max(p[i] + dp[time], maxValue);
                maxValue = dp[i];
            }
            // 상담이 기간을 벗어나는 경우
            else dp[i] = maxValue;
        }

        System.out.println(maxValue);
    }
}
