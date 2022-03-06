/**
14-02. 안테나

=== 입력 예시 ===
4
5 1 7 9

=== 출력 예시 ===
5
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 집의 갯수 입력
    int n = sc.nextInt();

    // 집의 위치 입력
    int temp = 0;
    HashMap<Integer, Integer> house = new HashMap<>();
    for(int i=0; i<n; i++) { 
      temp = sc.nextInt();
      house.put(temp, temp);
    }
    sc.close();

    // 각 value에 거리 합산 값 넣기
    int sum = 0;
    for(Integer key1 : house.keySet()) {
      for(Integer key2 : house.keySet()) { 
        sum += Math.abs(key1 - key2);
      }
      house.replace(key1, sum);
      sum = 0;
    }    

    // Value 정렬
    List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(house.entrySet());
    entryList.sort(Map.Entry.comparingByValue());

    // 결과값 출력
    System.out.println(entryList.get(0));
  }
}
