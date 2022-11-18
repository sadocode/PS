import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
    	PriorityQueue<Integer> q = new PriorityQueue<>();

    	for(int i = 0; i < scoville.length; i++)
    		q.add(scoville[i]);
    	
    	int answer = 0;
        int tempA = 0;
        int tempB = 0;
        while(q.size() > 1)
        {
       		tempA = q.poll();
       		if(tempA >= K)
       		{
       			q.add(tempA);
       			break;
       		}
       		
       		tempB = q.poll();
       		q.add(tempA + tempB * 2);
       		answer++;
        }
        
        if(q.size() == 1)
        {
        	if(q.poll() >= K)
        		return answer;
        	else
        		return -1;
        }
        else
        {
        	return answer;
        }
    }
}
