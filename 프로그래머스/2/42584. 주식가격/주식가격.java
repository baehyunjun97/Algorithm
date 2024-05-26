import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
		
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(0); //기본값
		
		for(int i =1; i < prices.length; i++) {
			// 스택 내에 있는 값이 더 크다면 (값이 떨어졌다면)
			while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
				int j = stack.pop();
				answer[j] = i - j;
			}
			stack.push(i); // 떨어진 적 없는 값 push
		}
		
		//스택에 끝까지 남은 값 == 떨어진적이 없음.
		while(!stack.isEmpty()) {
			int j = stack.pop();
			answer[j] = prices.length-1-j;
		}
		
        return answer;
    }
}