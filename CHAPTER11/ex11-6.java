/**
11-6. 무지의 먹방 라이브
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 음식의 번호 지정
    int k = sc.nextInt(); // 네트워크 장애가 발생한 시간
    int cost = 0; // 무지가 모든 음식을 먹는 시간
    int[] food_times = new int[n]; // 각 음식을 모두 먹는 데 필요한 시간이 담겨 있는 배열

    boolean isReset = false; // 무지가 음식을 다 먹지 못했을 경우를 체크하는 변수

    for(int i=0; i<food_times.length; i++) {
      if(food_times[i] <= 0) {
        food_times[i] = -1; // 더 섭취해야 할 음식이 없다면 -1을 반환
      } else {
        food_times[i]--; // 무지가 음식 하나를 섭취하는 시간
        cost++;
      }

      for(int j=0; j<food_times.length; j++) {
        if(food_times))
        food_times[]
      }
    }

    sc.close();
  }

  //private static int solution() {
  //  
  //}
}
