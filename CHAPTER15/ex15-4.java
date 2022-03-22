/**
15-04. 가사 검색

=== 입력예시 ===
6 5
frodo
front
frost
frozen
frame
kakao
fro??
?????o
fr???
fro???
pro?

=== 출력 예시 ===
3 2 4 1 0
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int words_cnt = sc.nextInt();
    int queries_cnt = sc.nextInt();
    
    String[] words = new String[words_cnt];
    for(int i=0; i<words_cnt; i++) { words[i] = sc.nextLine(); }

    String[] queries = new String[queries_cnt];
    for(int i=0; i<queries_cnt; i++) { queries[i] = sc.nextLine(); }
    sc.close();

    int cmprcnt = 0;
    int[] cmprwrds = new int[queries_cnt];
    for(int i=0; i<queries.length; i++) {
      for(int j=0; j<queries[i].length(); j++) {
        if(queries[i].charAt(j) != '?') { cmprcnt++; }
      }
      cmprwrds[i] = cmprcnt;
      cmprcnt = 0;
    }

    int cnt = 0;
    int[] result = new int[queries_cnt];
    for(int i=0; i<queries.length; i++) {
      for(int j=0; j<words.length; j++) {
        if(words[j].length() == queries[i].length()) {
          cnt += containCnt(words[j], queries[i], cmprwrds[i]);
        }
      }
      result[i] = cnt;
      cnt = 0;
    }

    for(int i=0; i<result.length; i++) { System.out.print(result[i] + " "); }
  }

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
