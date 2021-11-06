/* 3-3 숫자 카드 게임 */

import java.util.Arrays;
import java.util.Comparator;

class Main {
  public static void main(String[] args) {
    // 카드 패 지정
    int[][] card = {{3, 1, 2}, {4, 1, 4}, {2, 2, 2}};
    
    // 2차원 배열을 오름차순 정렬한다
    Arrays.sort(card, new Comparator<int[]>() { 
      @Override public int compare(int[] o1, int[] o2) { 
        if(o1[0] == o2[0]) { 
          return o1[1] - o2[1]; 
        } else { 
          return o1[0] - o2[0]; 
        } 
      } 
    });

    // 2차원 배열의 맨 첫 번째 인덱스를 출력한다([0][0])
    System.out.println(card[0][0]);
  }  
}
