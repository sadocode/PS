class Solution {
	public int solution(int N, int[][] road, int K) {
		if(N == 1)
			return 1;
		
		int[][] timeArr = new int[N][N];
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(i == j)
					continue;
				
				timeArr[i][j] = K + 1;
			}
		}
		
		for(int i = 0; i < road.length; i++)
		{
			if(road[i][2] > K)
				continue;
			if(road[i][2] < timeArr[road[i][0] - 1][road[i][1] - 1])
			{			
				timeArr[road[i][0] - 1][road[i][1] - 1] = road[i][2];
				timeArr[road[i][1] - 1][road[i][0] - 1] = road[i][2];
			}
		}
		
		boolean[] visit = new boolean[N];
		int count = 0;
		int idx = 0;
		while(count < N)
		{
			idx = getMinIdx(visit, timeArr[0], K);
			if(idx == -1)
				break;

			visit[idx] = true;
			
			for(int i = 1; i < N; i++)
			{
				if(idx == i)
					continue;
				if(timeArr[idx][i] + timeArr[0][idx] < timeArr[0][i])
					timeArr[0][i] = timeArr[idx][i] + timeArr[0][idx];
			}
			
			count++;
		}

		int answer = 0;
		for(int i = 0; i < N; i++)
		{
			if(timeArr[0][i] <= K)
				answer++;
		}
		return answer;
	}
	private static int getMinIdx(boolean[] visit, int[] timeArr, int K)
	{
		int min = K + 1;
		int idx = -1;
		for(int i = 1; i < visit.length; i++)
		{
			if(!visit[i] && timeArr[i] < min)
			{
				min = timeArr[i];
				idx = i;
			}
		}
		
		return idx;
	}
}
