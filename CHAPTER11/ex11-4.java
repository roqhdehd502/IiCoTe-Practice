/**
11-4. 만들 수 없는 금액

입력예시
=====
5
3 2 1 1 9

출력예시
=====
8

추상화
=====
그리디 알고리즘을 이용하여 현재 상태를 1부터 target-1까지의 모든 금액을 만들 수 있는 상태를 체크한다.
예를 들어 단위가 1, 1, 2, 3, 9인 5개의 동전이 있을때... 1부터 16(1 + 1 + 2 + 3 + 9)까지의 경우의 수를 감안할 수 있으므로
- 1원 : 1
- 2원 : 1 + 1 (개인의견: 조합 가짓 수가 아닌 조합이 되는지 안되는지에만 집중해보자...)
- 3원 : 1 + 2
- 4원 : 1 + 1 + 2
- 5원 : 2 + 3
- 6원 : 1 + 2 + 3
- 7원 : 1 + 1 + 2 + 3
- 8원? : 1 + 1 + 2 + 3 + ...?
즉, 8원을 조합할 수 없으므로 최솟값인 답을 8로 도출한다.

구현
=====
step 0-1. 입력된 인덱스 값을 정렬한다(3, 2, 1, 1, 9 -> 1, 1, 2, 3, 9)
step 0-2. 금액 1을 만들 수 있는 지 확인, 초기값 target = 1로 설정 (이후 1, 1, 2, 3, 9에 주목하자)
step 1. target = 1을 만족하는 지 확인, 화폐단위인 1이 있으므로 target = target + 1 = 2로 설정 
step 2. target = 2를 만족하는 지 확인, 화폐단위인 1이 있으므로 target = target + 1 = 3로 설정
step 3. target = 3을 만족하는 지 확인, 화폐단위인 2가 있으므로 target = target + 2 = 5로 설정
step 4. target = 5를 만족하는 지 확인, 화폐단위인 3이 있으므로 target = target + 3 = 8로 설정
step 5. target = 8을 만족하는 지 확인, 화폐단위인 9가 있는데 여기서 8 < 9가 되므로 8을 만들 수 있는 금액이 없다. 즉 target = 8
*/

import java.util.Scanner;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 동전의 갯수
    int[] coin = new int[n]; // 동전의 단위
    int target = 1; // 만들수 없는 금액을 찾기 위한 타겟 값(초기값을 1로 지정)
    
    for(int i=0; i<coin.length; i++) { coin[i] = sc.nextInt(); }
    sc.close();
    Arrays.sort(coin); // 타겟 값을 찾기위해 오름차순으로 정렬한다
    
    for(int x=0; x<coin.length; x++) { // 그리디 알고리즘을 이용해 타겟 값(target)을 찾는다
      if(target < coin[x]) { // 해당 인덱스 값(동전의 단위)이 타겟 값보다 작으면 이 값은 만들 수 없는 값이 된다
        break;
      } else { // 그렇지 않으면 이 값은 만들 수 있는 값이 된다
        target += coin[x];
      }
    }

    System.out.println(target);
  }
}
