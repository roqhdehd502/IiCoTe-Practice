/*
8-5. 효율적인 화폐 구성

N가지 종류의 화폐가 있다. 이 화폐들의 개수를 최소한으로 이용해서 그 가치의 합이 M원이 되도록 하려고 한다.
이때 각 종류의 화폐는 몇 개라도 사용할 수 있다.
예를 들어 2원, 3원 단위의 화폐가 있을 때는 15원을 만들기 위해 3원을 5개 사용하는 것이 가장 최소한의 화폐 개수이다.
M원을 만들기 위한 최소한의 화폐 개수를 출력하는 프로그램을 작성하라

- 첫째 줄에 N, M이 주어진다. (1<=N<=100, 1<=M<=10000)
- 이후의 N개의 줄에는 각 화폐의 가치가 주어진다. 화폐의 가치는 10000보다 작거나 같은 자연수이다.
- 첫째 줄에 최소 화폐 개수를 출력한다.
- 불가능할 때는 -1을 출력한다.

입력예시-1
=====
2 15
2
3

출력예시-1
=====
5

입력예시-2
=====
3 4
3
5
7

출력예시-2
=====
-1
*/

import java.util.Scanner;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] arr = new int[n];
    int temp = 0;

    // int d[i] = new int[10001];

    for(int i=0; i<arr.length; i++) { arr[i] = sc.nextInt(); }
    sc.close();

    Arrays.sort(arr);
    for(int i=arr.length-1; i>=0; i--) {
      if(m % arr[arr.length-1] == 0) {
        temp = m / arr[arr.length-1];
        break;
      } else if(arr[arr.length-1] > m) {
        temp = -1;
        break;
      } else {
        temp += m / arr[i];
        m -= m / arr[i];
      }
      
    }

    System.out.println(temp);
  }
}
