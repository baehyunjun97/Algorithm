import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] answers) {
        int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;

		// 수포자1 : 1~5를 반복
		int[] pattern1 = { 1, 2, 3, 4, 5 };
		int[] std1 = markPaper(pattern1, answers.length);
		// 답안을 검사 (answers 와 인덱스 별로 비교하여 맞을때마다 cnt증가)
		cnt1 = checkPaper(answers, std1);

		// -------------------------
		// 수포자2 : 패턴 : ( 2, 1, 2, 3, 2, 4, 2, 5 )
		int[] pattern2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] std2 = markPaper(pattern2, answers.length);
		// 답안을 검사
		cnt2 = checkPaper(answers, std2);

		// -------------------------

		// 수포자3 : 3,3,1,1,2,2,4,4,5,5
		int[] pattern3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int[] std3 = markPaper(pattern3, answers.length);
		// 답안을 검사
		cnt3 = checkPaper(answers, std3);

		// 높은 점수 체크 (인덱스+1 == 학생번호)
		int[] score = { cnt1, cnt2, cnt3 };
		
		int maxScore = Arrays.stream(score).max().getAsInt();
		
		List<Integer> answer = new ArrayList<>();
		for(int i =0; i< score.length; i++) {
			if(maxScore == score[i]) {
				answer.add(i+1);
			}
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	//답안생성
	public int[] markPaper(int[] pattern, int answerLength) {
		// 문제 길이만큼 답안배열 생성
		int[] result = new int[answerLength];

		// 패턴에 따른 답안을 작성
		int pntCnt = 0; // 0번부터 넣으며, pattern의 길이를 초과할 시 0번으로 돌아가야함.
		for (int i = 0; i < answerLength; i++) {
			if (pattern.length <= pntCnt) {
				pntCnt = 0;
			}
			result[i] = pattern[pntCnt];
			pntCnt++;
		}
		return result;
	}

	//점수체크
	public int checkPaper(int[] answer, int[] paper) {
		int score = 0;
		for (int i = 0; i < answer.length; i++) {
			if (answer[i] == paper[i]) {
				score++;
			}
		}
		return score;
	}
    
}