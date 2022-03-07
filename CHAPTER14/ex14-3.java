/**
14-03. 실패율

=== 입력예시.1 ===
5
8
2 1 2 6 2 4 3 3

=== 출력예시.1 ===
3 4 2 1 5

=== 입력예시.2 ===
4
5
4 4 4 4 4

=== 출력예시.2 ===
4 1 2 3
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 스테이지의 개수
    int user = sc.nextInt(); // 유저의 수
    int[] stages = new int[user]; // 각 유저별 도달한 스테이지
    for(int i=0; i<stages.length; i++) { stages[i] = sc.nextInt(); } // 1 <= stages[i] <= n+1
    sc.close();

    HashMap<Integer, Double> failRate = new HashMap<Integer, Double>(); // 실패율
    for(int i=1; i<=n; i++) { failRate.put(i, 0.0); } // 각 스테이지 별 실패율 초기화

    int visitStage = 0; // 방문한 스테이지
    int sccUsers = user; // 스테이지에 도달한 플레이어 수 갱신
    int failCnt = 0; // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
    for(int i=1; i<=n; i++) {
      for(int j=0; j<stages.length; j++) {
        if((visitStage < stages[j]) && (i >= stages[j])) { // visitStage < stages[j] <= i
          failCnt++; // 스테이지에 도달했으나 아직 클리어 실패
        }
      }
      /* 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어의 수 */
      /* 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0으로 정의한다 */
      failRate.replace(i, ((double)failCnt / (double)sccUsers));
      sccUsers -= failCnt; // 스테이지에 도달한 플레이어 수 갱신
      failCnt = 0; // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 갱신
      visitStage = i; // 방문한 스테이지 갱신
    }

    /* 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 한다 */
    // Value 내림차순 정렬
    List<Integer> keySetList = new ArrayList<>(failRate.keySet());
    Collections.sort(keySetList, (o1, o2) -> (failRate.get(o2).compareTo(failRate.get(o1))));

    // 결과값 출력 
    for(Integer key : keySetList) { System.out.print(key + " "); }
  }
}
