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
	int temp = 0;
	
	for(int i=0; i<=N; i++) {
	    if(i == 3 || i == 13 || i == 23 ) { temp += 3600; }
	    temp += 1575;
	}
	
	System.out.println(temp);
    }
}
