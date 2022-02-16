class Solution {
    public int[] solution(int[] prices) {
    	int pricesLength = prices.length;
    	int[] answer = new int[pricesLength];
    	int temp = 0;
    	boolean isEnd = false;
    	
    	// 마지막 값
    	answer[pricesLength - 1] = 0;
    	
    	for(int i = pricesLength - 2; i >= 0; i--)
    	{
    		isEnd = false;
    		temp = prices[i];
    		
    		for(int j = i + 1; j < pricesLength -1; j++)
    		{
    			if(temp > prices[j])
    			{
    				isEnd = true;
    				answer[i] = j - i;
    				break;
    			}
    		}
    		
    		if(!isEnd)
    			answer[i] = pricesLength - i - 1;
    	}
    	
    	return answer;
    }
}
