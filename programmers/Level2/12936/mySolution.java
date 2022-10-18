class Solution {
    public int[] solution(int n, long k) {
    	int[] answer = new int[n];
    	long[] arr = null;
    	if(n == 1)
    	{
    		answer[0] = 1;
    		return answer;
    	}
    	
    	// 팩토리얼 값 저장
    	arr = new long[n - 1];
    	for(int i = 0; i < n - 1; i++)
    	{
    		if(i == 0)
    		{
    			arr[i] = 1;
    		}
    		else
    		{
    			arr[i] = arr[i - 1] * (i + 1);
    		}
    	}    	
    	
    	int[] nums = new int[n];
    	for(int i = 0; i < n; i++)
    		nums[i] = i + 1;
    	
    	int tempQ = 0;
    	int tempAnswer = 0;
    	k -= 1;
    	for(int i = arr.length - 1; i >= 0; i--)
    	{
    		tempQ = (int)(k / arr[i]);
    		k %= arr[i];

   			tempAnswer = getNum(nums, tempQ + 1);
    		nums[tempAnswer - 1] = 0;
    		answer[arr.length - i - 1] = tempAnswer;
    	}
    	for(int i = 0; i < n; i++)
    	{
    		if(nums[i] != 0)
    			answer[n - 1] = nums[i];
    	}
        return answer;
    }
    private static int getNum(int[] nums, int value)
    {
    	int count = 0;
    	for(int i = 0; i < nums.length; i++)
    	{
    		if(nums[i] == 0)
    			continue;
    		else
    			count++;
    		
    		if(count == value || value == 0)
    			return nums[i];
    	}
    	
    	return -1;
    }
}
