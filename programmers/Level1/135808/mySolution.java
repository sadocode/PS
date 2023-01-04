class Solution {
    public int solution(int k, int m, int[] score) {
    	int count = score.length;
    	int[] apple = new int[k];
    	int answer = 0;
    	
    	for(int i = 0; i < count; i++)
    		apple[score[i] - 1]++;
    	
    	int value = 0;
    	int idx = k - 1;
    	boolean isNext = false;
    	while(count >= m)
    	{
    		isNext = false;
    		for(int j = idx; j >= 0; j--)
    		{
    			if(isNext)
    			{
    				apple[j] += value;
   					isNext = false;
    			}
    			
    			if(apple[j] >= m)
    			{
    				count -= m;
    				apple[j] -= m;
    				answer += (j + 1) * m;
    				break;
    			}
    			else
    			{
    				idx--;
    				if(apple[j] == 0)
    					continue;
    				
    				value = apple[j];
    				isNext = true;
    			}
    		}
    	}
    	
        return answer;
    }
}
