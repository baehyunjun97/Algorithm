class Solution {
    public int[] solution(String s) {
       // [0] = 횟수 , [1] = 사라진 0의 개수
		int[] answer = new int[2];
		String temp = "";

		// 1이 될 때까지
		while (!s.equals("1")) {
			// 이진변환
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0') {
					answer[1]++;
				} else {
					temp += "1";
				}
			}
			
			s = Integer.toBinaryString(temp.length());
			
			// 임시문자열 비우기
			temp = "";
			// 횟수 증가
			answer[0]++;
		}
        return answer;
    }
}