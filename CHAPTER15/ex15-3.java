/**
15-03. 공유기 설치

=== 입력 예시 ===
5 3
1
2
8
4
9

=== 출력 예시 ===
3
*/                       

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    int c = sc.nextInt();

    int[] home = new int[n];
    for(int i=0; i<home.length; i++) { home[i] = sc.nextInt(); }
    sc.close();

    Arrays.sort(home);

    int leng = (leng % 2 == 1) ? leng+1 / c : leng / c; // length가 String 타입으로 리턴되는거 해결하기 ㅠㅠ
    int dist = 0;
    for(int i=0; i<home.length; i=i+leng) {
      if(i+leng > home.length-1) {
        dist = Math.min(dist, (home[i]-home[i-leng]));
        System.out.println(dist); // 임시
        break;
      } else {
        dist = Math.min(dist, (home[i]-home[i+leng]));
        System.out.println(dist); // 임시
      }
    }

    System.out.println(dist);
  }
}
