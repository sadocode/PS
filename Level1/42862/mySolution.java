class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int result = 0;
    	int[] student = new int[n + 1];
    	int lSize = lost.length;
    	int rSize = reserve.length;
    	
    	// student 배열 채우기. student 배열을 idx 1부터 사용함.
    	// student[i] == 0 : 체육복 1개 보유
    	// student[i] == 1 : 여분까지 총 2개 보유
    	// student[i] == -1 : 없음.
    	for(int i = 0; i < lSize; i++)
    		student[lost[i]]--;
    	for(int i = 0; i < rSize; i++)
    		student[reserve[i]]++;
    	
    	
    	// student 배열로 계산하기.
    	for(int i = 1; i < n + 1; i++)
    	{
    		if(student[i] < 0)
    		{
    			if(i > 1)
    			{
    				if(student[i - 1] == 1)
    				{
    					result++;
    					continue;
    				}
    			}
    			
    			if(i < n)
    			{
    				if(student[i + 1] == 1)
    				{
    					result++;
    					student[i + 1] = 0;
    				}
    			}
    		}
    		else
    		{
    			result++;
    		}
    	}
    	
    	
    	return result;
    }
}
