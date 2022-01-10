import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		int workSize = progresses.length;
		
		// 완료된 작업을 기록하는 배열
		boolean[] check = new boolean[workSize];
		
		// 큐의 맨 앞의 프로그램의 위치
		int nowJob = 0;
		
		// 작업완료된 프로그램 위치
		int finishedJob = -1;
		
		// 정답 배열
		List<Integer> answerList = new ArrayList<Integer>();
		
		// 매일 완료된 프로그램이 있는지 표시
		boolean isFinished = false;
		
		while(nowJob < workSize)
		{
			isFinished = false;
			
			// 남은 프로그램 1일씩 진행
			for(int i = nowJob; i < workSize; i++)
			{
				if((progresses[i] += speeds[i]) >= 100)
					check[i] = true;
			}
			
			// 프로그램 작업 완료 여부 체크
			for(int i = nowJob; i < workSize; i++)
			{
				if(check[i])
				{
					isFinished = true;
					finishedJob = i;
				}
				else
				{
					break;
				}
			}
			
			// 완료된 작업들을 list에 담음
			if(isFinished)
			{
				answerList.add(finishedJob - nowJob + 1);
				nowJob = finishedJob + 1;
			}
		}
		
		// list를 array로 변환
		int[] answer = new int[answerList.size()];
		for(int i = 0; i < answer.length; i++)
		{
			answer[i] = answerList.get(i);
		}
		
        return answer;
    }
}
