import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

class Solution {
    public int solution(String s) {
        int answer = 0;

		// Hashmap 으로 각 괄호를 쌍으로 지음
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('}', '{');
		map.put(')', '(');
		map.put(']', '[');

		// 원본 s의 길이
		int sLength = s.length();
		// s를 2배로 늘임. 모두 사용하지 않음. (0~s번, 1~s+1번 체크로 진행)
		s += s;

		A: for (int i = 0; i < sLength; i++) {
			// index 증가시킬 때마다 새로운 deq 생성
			Deque<Character> stack = new ArrayDeque<Character>();
			// 0~s번, 1~s+1번 체크 진행
			for (int j = i; j < sLength + i; j++) {

				// j부터 시작
				char c = s.charAt(j);

				// 값이 없다면 열림괄호. 저장
				if (!map.containsKey(c)) {
					stack.push(c);
				} else {
					// 닫힘 괄호가 보일 때 비어있거나, 알맞은 짝이 없다면 A로 귀환
					if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
						continue A;
					}
				}
			} // end 내부

			// 내부를 통과했다면, 올바른 괄호들.
			if (stack.isEmpty()) {
				answer++;
			}

		} // end A

		return answer;
    }
}