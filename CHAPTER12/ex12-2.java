/**
11-8. 문자열 재정렬
=== 입력 예시.1 ===
K1KA5CB7
=== 출력 예시.1 ===
ABCKK13
=== 입력 예시.2 ===
AJKDLSI412K4JSJ9D
=== 출력 예시.2 ===
ADDIJJJKKLSS20
*/

import java.util.*;

public class Main {

    public static String str;
    public static ArrayList<Character> result = new ArrayList<Character>();
    public static int value = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        // 문자를 하나씩 확인하며
        for (int i = 0; i < str.length(); i++) {
            // 알파벳인 경우 결과 리스트에 삽입
            if (Character.isLetter(str.charAt(i))) {
                result.add(str.charAt(i));
            }
            // 숫자는 따로 더하기
            else {
                value += str.charAt(i) - '0';
            }
        }

        // 알파벳을 오름차순으로 정렬
        Collections.sort(result);

        // 알파벳을 차례대로 출력
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
        }

        // 숫자가 하나라도 존재하는 경우 가장 뒤에 출력
        if (value != 0) System.out.print(value);
        System.out.println();
    }
}
