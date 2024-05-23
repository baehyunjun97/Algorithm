//stack 활용
import java.util.ArrayDeque;
import java.util.Deque;

class Solution{

    public int solution(String s) {
		Deque<Character> stack = new ArrayDeque<Character>();
		
		for(int i=0; i < s.length(); i++) {
			
			char c = s.charAt(i);
			
			//스택이 비지 않고 , 현재 문자와 스택의 맨위 문자가 같으면.
			if(!stack.isEmpty() && stack.peek() == c) {
				stack.pop(); // 맨 위 문자 제거
			}
			
			//스택이 비어있거나(첫번째 문자) , 스택의 맨위 문자와 다르면. 
			else {
				stack.push(c); // 스택 맨 위에 추가
			}
			
			
		}

		return stack.isEmpty()? 1:0;
    }
}