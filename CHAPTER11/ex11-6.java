/**
11-6. 무지의 먹방 라이브

=== 입력 예시 ===
3
3 1 2
5

=== 출력 예시 ===
0 ~ 1초 동안 1번 음식을 섭취한다. 해당 음식 번호의 남은 시간은 2입니다.
1 ~ 2초 동안 2번 음식을 섭취한다. 해당 음식 번호의 남은 시간은 0입니다.
2 ~ 3초 동안 3번 음식을 섭취한다. 해당 음식 번호의 남은 시간은 1입니다.
3 ~ 4초 동안 1번 음식을 섭취한다. 해당 음식 번호의 남은 시간은 1입니다.
4 ~ 5초 동안 3번 음식을 섭취한다. 해당 음식 번호의 남은 시간은 0입니다.
5초에서 네트워크 장애가 발생했습니다. 1번 음식을 섭취해야 할 때 중단되었으므로, 장애 복구 후에 1번 음식부터 다시 먹기 시작하면 됩니다.
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 음식의 번호 지정
    int[] food_times = new int[n]; // 각 음식을 모두 먹는 데 필요한 시간이 담겨 있는 배열

    // 각 음식을 모두 먹는데 걸리는 시간 설정
    for(int i=0; i<food_times.length; i++) { food_times[i] = sc.nextInt(); }

    int k = sc.nextInt(); // 네트워크 장애가 발생한 시간
    sc.close();

    for(int i=0; i<k; i++) {
      if(i == k-1) {
        System.out.println(k + "초에서 네트워크 장애가 발생했습니다. "
          + (food_times[i%food_times.length]+1) + "번 음식을 섭취해야 할 때 중단되었으므로, 장애 복구 후에 "
          + (food_times[i%food_times.length]+1) + "번 음식부터 다시 먹기 시작하면 됩니다.");
      }

      if(food_times[i%food_times.length] > 0) {
        food_times[i%food_times.length]--;
        System.out.println(i + " ~ " + (i+1) + "초 동안 "
          + (food_times[i%food_times.length]+1) + "번 음식을 섭취한다. 해당 음식 번호의 남은 시간은 "
          + food_times[i%food_times.length] + "입니다.");
      }
    }
  }
}
