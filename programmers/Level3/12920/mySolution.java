class Solution {
    public int solution(int n, int[] cores) {
    	int len = cores.length;
    	if(n <= len)
    		return n;
    	
    	n -= len;
    	
    	int high = 100000000;
    	int mid = 0;
    	int low = 0;
    	int addCount = 0;
    	int previousCount = 0;
    	int previousMid = 0;
    	
    	while(low + 1 < high)
    	{
    		if(addCount < n)
    		{
    			previousMid = mid;
    			previousCount = addCount;
    		}
    		mid = (high + low) / 2;
    		addCount = 0;
    		for(int i = 0; i < len; i++)
    			addCount += mid / cores[i];
    		if(addCount >= n)
    			high = mid;
    		else
    			low = mid;
    	}
    	
    	if(addCount >= n)
    	{
    		mid = previousMid;
    		addCount = previousCount;
    	}
    	
    	while(n > addCount)
    	{
    		mid++;
    		for(int i = 0; i < len; i++)
    		{
    			if(mid % cores[i] == 0)
    			{
    				addCount++;
    				if(addCount == n)
    					return i + 1;
    			}
    		}
    	}
        return 0;
    }
}
