/*
Day 01. 슬기로운 일상생활
본격적인 with covid19의 시작, 집콕하던 일상에서 다시 슬기롭고 안전하게 세상으로 나아가기 위해 우리는 어떤 준비를 해야 할까요? 더 슬기로운 위드 코로나 생활을 위한 나의 일상 모습을 코드로 표현해 주세요.
*/

class Main {
  private static int vaccine;
  // private int janssen;
  // private String pfizer, moderna;
  private static int maskStat;

  public static void main(String[] args) {
    vaccine = 3; // 화이자
    maskStat = 3; // 입과 코를 덮는 마스크 착용

    vacc(vaccine);
    mask(maskStat);
  }

  public static String vacc(int vaccine) {
    if(vaccine == 1) {
      
    }
    return "백신 접종완료!";
  }

  public static String mask(int maskStat) {
    if(maskStat == 1) { return "턱스크 ㄴㄴ"; }
    else if(maskStat == 2) { return "입스크 ㄴㄴ"; }
    else if(maskStat == 3) { return "좋은 마스크 착용!"; }
    else { return "마스크 쓰세용"; }
  }
}
