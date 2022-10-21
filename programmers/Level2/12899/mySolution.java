class Solution {
    public String solution(int n) {
    	int temp = 0;
    	int value = 1;
    	int arrLen = 0;
    	while(temp < n)
    	{
    		temp += value * 3;
    		arrLen++;
    		value *= 3;
    	}
    	
    	int[] arr = new int[arrLen];
    	
    	n -= (temp - get3Product(arrLen) + 1);
    	int tempQ = 0;
    	for(int i = 0; i < arrLen; i++)
    	{
    		tempQ = n / get3Product(arrLen - i - 1);
    		
    		if(tempQ == 0)
    			arr[i] = 1;
    		else if(tempQ == 1)
    			arr[i] = 2;
    		else
    			arr[i] = 4;
    			
    		n -= get3Product(arrLen - i - 1) * tempQ;
    	}
    	
    	StringBuilder answer = new StringBuilder();
    	for(int i = 0; i < arrLen; i++)
    		answer.append(arr[i]);
    	
        return answer.toString();
    }
    private static int get3Product(int value)
    {
    	int answer = 1;
    	for(int i = 0; i < value; i++)
    		answer *= 3;
    	
    	return answer;
    }
}

