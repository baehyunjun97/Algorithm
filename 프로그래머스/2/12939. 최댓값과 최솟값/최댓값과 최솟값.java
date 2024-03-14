class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] ss = s.split(" ");

		int min = Integer.parseInt(ss[0]);
		int max = Integer.parseInt(ss[0]);

		for (String num : ss) {
			int a = Integer.parseInt(num);
			
			if(a < min) {
				min = a;
			} else if (a > max) {
				max = a;
			}
		}
        answer = min + " " + max;
        return answer;
    }
}