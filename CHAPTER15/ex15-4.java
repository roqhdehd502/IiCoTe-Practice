/**
15-04. 가사 검색

=== 입력 예시 ===
"frodo", "front", "frost", "frozen", "frame", "kakao"
"fro??", "????o", "fr???", "fro???", "pro?"

=== 출력 예시 ===
3 2 4 1 0
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    // 입력값
    String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
    String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

    // 문자열 비교를 위한 queries 배열의 ? 키워드를 제외한 각 문자 개수
    int cmprcnt = 0;
    int[] cmprwrds = new int[queries.length];
    for(int i=0; i<queries.length; i++) {
      for(int j=0; j<queries[i].length(); j++) {
        if(queries[i].charAt(j) != '?') { cmprcnt++; }
      }
      cmprwrds[i] = cmprcnt;
      cmprcnt = 0;
    }

    // 함수를 호출하여 문자열이 포함된 갯수 산출
    int cnt = 0;
    int[] result = new int[queries.length];
    for(int i=0; i<queries.length; i++) {
      for(int j=0; j<words.length; j++) {
        if(words[j].length() == queries[i].length()) {
          cnt += containCnt(words[j], queries[i], cmprwrds[i]);
        }
      }
      result[i] = cnt;
      cnt = 0;
    }

    // 결과값 출력
    for(int i=0; i<result.length; i++) { System.out.print(result[i] + " "); }
  }

  // 문자열 비교 함수
  public static int containCnt(String word, String query, int cmprwrd) {
    int cnt = 0;
  
    for(int i=0; i<query.length(); i++) {
      if(query.charAt(i) == '?') { continue; }
      if(word.charAt(i) == query.charAt(i)) { cnt++; }
    }

    if(cnt == cmprwrd) {
      return 1;
    } else {
      return 0;
    }
  }
}
