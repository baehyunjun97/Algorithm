import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<Integer>();

		stack.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]!=stack.peek()) {
				stack.push(arr[i]);
			}
		}

        Integer[] stackArr = stack.toArray(new Integer[stack.size()]);
        int[] answer = new int[stackArr.length];
        
        int cnt = 0;
        for (Integer integer : stackArr) {
			answer[cnt] = integer;
			cnt++;
		}
        return answer;
    }
}