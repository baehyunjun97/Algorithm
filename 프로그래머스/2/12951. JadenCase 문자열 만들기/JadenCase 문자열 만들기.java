class Solution {
    public String solution(String s) {
        String answer = "";
		String lower = s.toLowerCase();
		boolean flag = true;

		for (int i = 0; i < lower.length(); i++) {
			String letter = String.valueOf(lower.charAt(i));


			if (flag) {
				answer += letter.toUpperCase();
				flag = false;
			} else {
				answer += letter;
			}
			
			if (letter.isBlank()) {
				flag = true;
			}
		}

		return answer;
    }
}