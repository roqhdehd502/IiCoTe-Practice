/*
6-3. 성적이 낮은 순서로 학생 출력하기
*/

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Map<Integer, String> map  = new HashMap<Integer, String>();

    int n = Integer.parseInt(sc.nextLine());

    for(int i=0; i<n; i++) {
      String str = sc.next();
      int itg = sc.nextInt();
      map.put(itg, str);
    }

    Object[] mapKey = map.keySet().toArray();
    Arrays.sort(mapKey);

    for(Integer keyVal : map.keySet()) {
      System.out.print(map.get(keyVal) + " ");
    }

    sc.close();
  }
}
