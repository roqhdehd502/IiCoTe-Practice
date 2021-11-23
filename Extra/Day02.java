class Solution {
    public int solution(int num) {
        int answer = 0;
        
        for(int i=0; i<500; i++) {
            if(num == 1) {
                break;
            } else if(i == 499) {
                answer = -1;
                break;
            } else {
                if(num % 2 == 0) {
                    answer++;
                    num /= 2;
                } else if(num % 2 == 1) {
                    answer++;
                    num = (num * 3) + 1;   
                } else {
                    continue;
                }
            }
        }
        
        return answer;
    }
}
