import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
    	PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> {
    		int x1 = x[1];
    		int y1 = y[1];
    		
    		if(x1 < y1)
    		{
    			return -1;
    		}
    		else
    		{
    			return 1;
    		}
    		
    	});
    	Arrays.sort(jobs, new Comparator<int[]>() {
    		public int compare(int[] x, int[] y) {
    			if(x[0] > y[0])
    				return 1;
    			else
    				return -1;
    		}
    	});
    	int[] times = new int[jobs.length];
    	int time = 0;				// 지나간 시간
    	int count = 0;				// 처리한 job 수
    	int jobsIdx = 0;			// jobs 배열 idx
    	boolean isProcess = false; 	// job 처리 중 여부
    	int[] target = new int[3];
    	while(count < jobs.length)
    	{
    		// 들어가는 시간이 된 job을 queue에 넣음.
    		for(int i = jobsIdx; i < jobs.length; i++)
    		{
    			if(jobs[i][0] <= time)
    			{
    				jobsIdx++;
    				int[] temp = new int[3];
    				temp[0] = jobs[i][0];
    				temp[1] = jobs[i][1];
    				temp[2] = i;
    				queue.add(temp);
    			}
    			else
    			{
    				break;
    			}
    		}
    		
    		if(!isProcess && !queue.isEmpty())
    		{
    			target = queue.poll();
    			
    			target[1]--;
    			isProcess = true;
    			if(target[1] == 0)
    			{
    				times[target[2]] = time - target[0] + 1;
    				isProcess = false;
    				count++;
    			}
    		}
    		else if(isProcess)
    		{
    			target[1]--;
    			if(target[1] == 0)
    			{
    				times[target[2]] = time - target[0] + 1;
    				isProcess = false;
    				count++;
    			}
    		}
    		
    		time++;
    	}

    	int answer = 0;
    	for(int i = 0; i < times.length; i++)
    		answer += times[i];

    	return answer / jobs.length;
    }
}
