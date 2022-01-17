/**
11-6. 무지의 먹방 라이브

=== 입력 예시 ===
3
3 1 2
5

=== 출력 예시 ===
1
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 음식의 번호 지정
    int[] food_times = new int[n]; // 각 음식을 모두 먹는 데 필요한 시간이 담겨 있는 배열

    // 각 음식을 모두 먹는데 걸리는 시간 설정
    for(int i=0; i<food_times.length; i++) { food_times[i] = sc.nextInt(); }

    int k = sc.nextInt(); // 네트워크 장애가 발생하는 시간 지점
    sc.close();

    int temp = 0;
    for(int i=0; i<k; i++) { // 나머지를 이용해 food_times 배열의 인덱스 값을 변화시킨다
      if(food_times[i%food_times.length] > 0) {
        temp = i%food_times.length;
        food_times[temp]--;
      }
    }

    System.out.println(temp+1); // 장애 복구 후 먹을 음식 번호
  }
}
