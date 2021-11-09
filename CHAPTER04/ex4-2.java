/* 
4-2. 시각: 문제 조건

정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성하라.

예를 들어 1을 입력했을 때 다음은 3이 하나라도 포함되어 있으므로 세어야 하는 시각이다
- 00시 00분 03초
- 00시 13분 30초

반면에 다음은 3이 하나도 포함되어 있지 않으므로 세면 안 되는 시각이다
- 00시 02분 55초
- 01시 27분 45초 

3이 들어가는 시 분 초의 경우
- 3, 13, 23                                                 => 3이 들어가는 가짓수(시)
- 3, 13, 23, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 43, 53 => 3이 들어가는 가짓수(초)
- 3, 13, 23, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 43, 53 => 3이 들어가는 가짓수(초)
*/

class Main {
    public static void main(String[] args) {
		int N = 5; // 시간 입력(단, 1 <= N <= 23)
		int cnt = 0; // 3이 들어가는 숫자 카운트

		for(int i=0; i<=N; i++) { // 시
			for(int j=0; j<=59; j++) { // 분
				for(int k=0; k<=59; k++) { // 초
					if(k == 3 || k == 3 || k == 13 
						|| k == 23 || (k >= 30 && k <= 39)
						|| k == 43 || k == 53) {
						cnt++;
					}
				}

				if(j == 3 || j == 3 || j == 13 
					|| j == 23 || (j >= 30 && j <= 39)
					|| j == 43 || j == 53) {
					cnt++;
				}
			}
			
			if(i == 3 || i == 3 || i == 13 || i == 23) {
				cnt++;
			}
		}
		
        System.out.println(cnt);
    }
}
