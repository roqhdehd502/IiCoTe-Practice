/**
16-04. 병사 배치하기

=== 입력 예시 ===
7
15 11 4 8 5 2 4

=== 출력 예시 ===
2
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int temp = 0;
    ArrayList<Integer> sldr = new ArrayList<>();
    for(int i=1; i<=n; i++) {
      temp = sc.nextInt();
      sldr.add(temp);
    }
    sc.close();

    int cnt = 0;
    for(int i=0; i<sldr.size(); i++) {
      if(i == sldr.size()-1) { continue; }
      if(sldr.get(i) < sldr.get(i+1)) { cnt++; }
    }

    System.out.println(cnt);
  }
}
