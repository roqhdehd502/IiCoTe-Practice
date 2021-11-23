class Solution {
    public String solution(String[] seoul) {
        String str1 = "김서방은 ";
        String str2 = "에 있다";
        int itg = 0;
            
        for(int i=0; i<seoul.length; i++) {
            if(seoul[i].equals("Kim")) { 
                itg = i;
                break;
            }
        }
        
        return str1 + itg + str2;
    }
}
