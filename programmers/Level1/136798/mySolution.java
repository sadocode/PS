class Solution {
    public int solution(int number, int limit, int power) {
    	if(number == 1)
    		return 1;
    	
    	int[] knights = new int[number + 1];
    	
    	knights[1] = 1;
    	for(int i = 2; i < number + 1; i++)
    	{
    		if(knights[i] != 0)
    			continue;
    		else
    			knights[i] = 2;
    		for(int j = 2; i * j < number + 1; j++)
    			knights[i * j] = getDivisor(i * j, limit, power);
    	}
    	
        int answer = 0;
    	for(int i = 1; i < number + 1; i++)
    		answer += knights[i];

        return answer;
    }
    private static int getDivisor(int value, int limit, int power)
    {
    	int result = 0;
    	for(int i = (int)Math.sqrt(value); i >= 1; i--)
    	{
    		if(value % i == 0)
    		{
    			if(i != value / i)
    				result++;
    			result++;
    			if(result > limit)
    				return power;
    		}
    	}
    	return result;
    }
}
