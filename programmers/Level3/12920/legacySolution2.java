class Solution {
    public int solution(int n, int[] cores) {
    	int len = cores.length;
    	if(n <= len)
    		return n;
    	
    	n -= len;
    	int tick = 0;
    	int finCount = 0;
    	while(n > finCount)
    	{
    		tick++;
    		for(int i = 0; i < len; i++)
    		{
    			if(tick  % cores[i] == 0)
    			{
    				finCount++;
    				if(n == finCount)
    					return i + 1;
    			}
    		}
    	}
    	
        return 0;
    }
}
