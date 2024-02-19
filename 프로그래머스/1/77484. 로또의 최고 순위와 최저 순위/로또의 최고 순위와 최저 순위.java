class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 순위에 따른 당첨 개수
        int[] rank = {6, 6, 5, 4, 3, 2, 1};

        // answer[0]: 최고 순위, answer[1]: 최저 순위
        int[] answer = new int[2];
        
        //찢어진 숫자(0) 조회 시 최고 순위 ++ (모든 숫자가 될수 있으므로)
        for (int i = 0; i < lottos.length; i ++) {
            if (lottos[i] == 0) {
                answer[0]++;
                continue;
            }
            
            //당첨번호를 조회하며, 맞았을 경우 최저,최고 각각++ (최저도 올릴 것)
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    answer[0]++;
                    answer[1]++;
                }
            }
        }
        
        answer[0] = rank[answer[0]];
        answer[1] = rank[answer[1]];
        
        return answer;
    }
}