/**
14-04. 카드 정렬하기

=== 입력 예시 ===
3
10
20
40

=== 출력 예시 ===
100
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 카드 묶음의 수
    HashMap<Integer, Boolean> cards = new HashMap<Integer, Boolean>();
    int card = 0;
    for(int i=0; i<n; i++) {
      card = sc.nextInt();
      cards.put(card, false); 
    }
    sc.close();

    /*
    ex) A B C, 경우의 수=2+1=3, 각각 합치는 횟수=2
    (A + B) + ((A+B) + C)
    (A + C) + ((A+C) + B)
    (B + C) + ((B+C) + A)

    ex) A B C D, 경우의 수=3+2+1=6, 각각 합치는 횟수=3
    (A + B) + ((A+B) + C) + ((A+B+C) + D)
    (A + C) + ((A+C) + B) + ((A+C+B) + D)
    (A + D) + ((A+D) + B) + ((A+D+B) + C)
    (B + C) + ((B+C) + A) + ((B+C+A) + D)
    (B + D) + ((B+D) + A) + ((B+D+A) + C)
    (C + D) + ((C+D) + A) + ((C+D+A) + D)
    */
    int min = 0; // 최소 비교 횟수
    int temp = 0;
    for(int i=0; i<noc(n-1); i++) {
      for(int j=0; j<n-1; j++) {
        //temp += cirLinkedList(cards); // 원형 연결 리스트를 이용하여 카드 조합
      }
      min = (i==0) ? temp : Math.min(min, temp); // 최소 비교 횟수 갱신
      temp = 0;
    }

    System.out.println(min); // 결과값 출력
  }
  
  private static int noc(int n) { // 경우의 수
    if(n <= 1) {
      return n;
    } else {
      return n + noc(n-1);
    }
  }

  // private static int cirLinkedList(HashMap<Integer, Boolean> cards) { // 원형 연결 리스트
  //   return 0;
  // }
}






//////////////////////////////////////////////////////////////////////






import java.util.*;

public class Main {

    public static int n, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 힙(Heap)에 초기 카드 묶음을 모두 삽입
        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextInt());
        }

        // 힙(Heap)에 원소가 1개 남을 때까지
        while (pq.size() != 1) {
            // 가장 작은 2개의 카드 묶음 꺼내기
            int one = pq.poll();
            int two = pq.poll();
            // 카드 묶음을 합쳐서 다시 삽입
            int summary = one + two;
            result += summary;
            pq.offer(summary);
        }

        System.out.println(result);
    }
}
