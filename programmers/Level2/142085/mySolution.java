import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
    	if(k >= enemy.length)
    		return enemy.length;
    	
    	PriorityQueue<Integer> q = new PriorityQueue<>();
    	
    	for(int i = 0; i < enemy.length; i++)
    	{
    		if(q.size() < k)
    			q.add(enemy[i]);
    		else
    		{
    			if(q.peek() < enemy[i])
    			{
    				if(n < q.peek())
    					return i;
    				
    				n -= q.poll();
    				q.add(enemy[i]);
    			}
    			else
    			{
    				if(n < enemy[i])
    					return i;
    				
    				n -= enemy[i];
    			}
    		}
    	}
    	
        return enemy.length;
    }
}
