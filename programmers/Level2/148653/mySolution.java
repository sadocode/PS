import java.util.Arrays;

class Solution {
    public static int answer = 0;
    
	public int solution(int storey) {
    	int len = getLength(storey);
    	int[] arr = new int[len + 1];

    	for(int i = 0; i < arr.length; i++)
    	{
    		arr[i] = storey % 10;
    		storey /= 10;
    	}
    	dfs(arr, 0, 0, true);
    	dfs(arr, 0, 0, false);
    	
        return answer;
    }
    public static int getLength(int num)
    {
    	int result = 0;
    	while(num > 0)
    	{
    		num /= 10;
    		result++;
    	}
    	return result;
    }
    public static void dfs(int[] arr, int idx, int sum, boolean isAdd)
    {
    	if(answer > 0 && sum > answer)
    		return;
    	
    	if(idx == arr.length - 1)
    	{
    		if(arr[idx] != 0)
    			sum += arr[idx];
    			
    		if(answer == 0 || (answer > 0 && sum < answer))
    			answer = sum;
    		
    		return;
    	}
    	
    	int val = arr[idx];
    	if(isAdd)
    	{
    		if(val == 0)
    		{
    			dfs(arr, idx + 1, sum, true);
    			dfs(arr, idx + 1, val == 0 ? sum : sum + 10 - val, false);
    		}
    		else
    		{
    			int[] tempArr = addNumber(arr, idx);
    			dfs(tempArr, idx + 1, sum + 10 - val, true);
    			dfs(tempArr, idx + 1, sum + 10 - val, false);
    		}
    	}
    	else
    	{
    		dfs(arr, idx + 1, sum + val, true);
    		dfs(arr, idx + 1, sum + val, false);
    	}
    }
    
    public static int[] addNumber(int[] arr, int idx)
    {
    	int[] result = new int[arr.length];
    	result = Arrays.copyOf(arr, arr.length);
    	result[idx] = 0;
    	for(int i = idx + 1; i < arr.length; i++)
    	{
    		if(result[i] == 9)
    			result[i] = 0;
    		else
    		{
    			result[i]++;
    			break;
    		}
    	}
    	return result;
    }
}
