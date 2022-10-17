class Solution {
    public int solution(int n) {
    	
    	int answer = 0;
    	int value = 0;
    	int count = 1;
    	while(value < n)
    	{
    		if((n - value) % count == 0)
    			answer++;
    		
    		value += count;
    		count++;
    	}
    	
        return answer;
    }
}
