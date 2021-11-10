/* 
4-3. 왕실의 나이트: 문제 설명
행복 왕국의 왕실 정원은 체스판과 같은 8 × 8 좌표 평면이다. 왕실 정원의 특정한 한 칸에 나이트가 서있다.
나이트는 말을 타고 있기 때문에 이동을 할 때는 L자 형태로만 이동할 수 있으며 정원 밖으로는 나갈 수 없다.
나이트는 특정 위치에서 다음과 같은 2가지 경우로 이동할 수 있다.
- 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
- 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기
이처럼 좌표 평면상에서 나이트의 위치가 주어졌을 때 나이트가 이동할 수 있는 경우의 수를 출력하는 프로그램을 작성하라.
ex-1) c2에 있을 때 이동할 수 있는 경우의 수는 6가지이다.
ex-2) a1에 있을 때 이동할 수 있는 경우의 수는 2가지이다.
*/

/*
나이트가 체스판을 벗어나지 않는 경우의 수
: 2칸, 4칸, 6칸, 8칸
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      // 체스판의 좌표
      //String chess[][] = {{"a1","b1","c1","d1","e1","f1","g1","h1"},
      //                   {"a2","b2","c2","d2","e2","f2","g2","h2"},
      //                   {"a3","b3","c3","d3","e3","f3","g3","h3"},
      //                   {"a4","b4","c4","d4","e4","f4","g4","h4"},
      //                   {"a5","b5","c5","d5","e5","f5","g5","h5"},
      //                   {"a6","b6","c6","d6","e6","f6","g6","h6"},
      //                   {"a7","b7","c7","d7","e7","f7","g7","h7"},
      //                   {"a8","b8","c8","d8","e8","f8","g8","h8"}};
      
      // 나이트의 좌표 지정 
      System.out.print("나이트의 좌표 입력(ex. a1): ");
      String knight = sc.nextLine();

      if(knight.equals("a1") || knight.equals("a8") || knight.equals("h8") || knight.equals("h1")) {
        System.out.println("2");

      } else if(knight.equals("c1") || knight.equals("d1") || knight.equals("e1") || knight.equals("f1")
        || knight.equals("a3") || knight.equals("a4") || knight.equals("a5") || knight.equals("a6")
        || knight.equals("c8") || knight.equals("d8") || knight.equals("e8") || knight.equals("f8")
        || knight.equals("h3") || knight.equals("h4") || knight.equals("h5") || knight.equals("h6")) {
        System.out.println("4");

      } else if(knight.equals("c2") || knight.equals("c3") || knight.equals("c4") || knight.equals("c5") || knight.equals("c6") || knight.equals("c7")
        || knight.equals("b6") || knight.equals("d6") || knight.equals("e6") || knight.equals("f6") || knight.equals("g6")
        || knight.equals("f2") || knight.equals("f3") || knight.equals("f4") || knight.equals("f5") || knight.equals("f7")
        || knight.equals("b3") || knight.equals("d3") || knight.equals("e3") || knight.equals("g3")) {
        System.out.println("6");

      } else {
        System.out.println("8");
      }

      sc.close();
    }
}
