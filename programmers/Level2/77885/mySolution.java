class Solution {
    public long[] solution(long[] numbers) {
        int numLen = numbers.length;
    	long[] answer = new long[numLen];
    	int pos = 0;
    	for(int i = 0; i < numLen; i++)
    	{
    		if(numbers[i] % 2 == 0)
    		{
    			answer[i] = numbers[i] + 1;
    		}
    		else
    		{
    			pos = getZeroPos(numbers[i]);
    			if(pos == -1)
    			{
    				answer[i] = Long.highestOneBit(numbers[i]) + numbers[i];
    			}
    			else
    			{
    				answer[i] = convertZeroToOne(numbers[i], pos);
    				answer[i] = convertOneToZero(answer[i], pos - 1);
    			}
    		}
    	}
    	
    	return answer;
    }
    private static int getZeroPos(long x)
    {
    	int n = 0;
    	boolean isZero = false;
    	while(x > 1)
    	{
    		n++;
    		x = x >>> 1;
    		
    		if(x % 2 == 0)
    		{
    			isZero = true;
    			break;
    		}
    	}
    	
    	if(isZero)
    		return n;
    	else
    		return -1;
    }
    private static long convertZeroToOne(long num, int pos)
    {
    	long temp = 1;
    	for(int i = 1; i <= pos; i++)
    		temp *= 2;

    	return num + temp;
    }
    private static long convertOneToZero(long num, int pos)
    {
    	if(pos == 0)
    		return num - 1;
    	
    	long temp = 1;
    	for(int i = 1; i <= pos; i++)
    		temp *= 2;
    	
    	return num - temp;
    }
}
