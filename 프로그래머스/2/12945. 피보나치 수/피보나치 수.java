class Solution {
    public int solution(int n) {
        int first=0;
        int second=1;
        int answer=0;
    
        //2부터 시작
        for(int i=2; i <= n; i++){
            answer = (first + second)% 1234567;
            first = second;
            second = answer; 
        }
        
        return answer;
    }
}