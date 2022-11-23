import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int[] cores) {
    	int len = cores.length;
    	if(n <= len)
    		return n;
    	
    	n -= len;
    	int[] work = Arrays.copyOf(cores, len);
    	PriorityQueue<Integer> notWork = new PriorityQueue<>();
    	
    	int temp = 0;
    	while(n > 0)
    	{
    		// 시간 1틱
    		for(int i = 0; i < len; i++)
    		{
    			if(--work[i] == 0)
    				notWork.add(i);
    		}
    		
    		// 일 안 하는 애들에 job 넣어주기.
    		while(!notWork.isEmpty())
    		{
    			temp = notWork.poll();
    			work[temp] = cores[temp];
    			n--;
    			if(n == 0)
    				return temp + 1;
    		}
    	}
        return 0;
    }
}
