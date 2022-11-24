import java.util.TreeMap;

class Solution {
    private static TreeMap<Integer, Boolean> numMap = new TreeMap<>();
    
	public int solution(String numbers) {
    	char[] nums = new char[numbers.length()];
    	boolean[] check = new boolean[nums.length];
    	
    	for(int i = 0; i < numbers.length(); i++)
    		nums[i] = numbers.charAt(i);
    	
    	for(int i = 1; i <= nums.length; i++)
    		addNum(nums.length, i, 0, nums, check, "");
    	
    	boolean[] decimal = new boolean[numMap.lastKey() + 1];

    	int j = 0;
    	for(int i = 2; i < decimal.length; i++)
    	{
    		if(decimal[i])
    			continue;
    		
    		j = 2;
    		while(i * j < decimal.length)
    		{
    			decimal[i * j++] = true;
    		}
    	}
    	
    	int answer = 0;
    	for(Integer num : numMap.keySet())
    	{
    		if(isDecimal(decimal, num))
    			answer++;
    	}

    	return answer;
    }
    private static void addNum(int n, int r, int count, char[] nums, boolean[] check, String result)
    {
    	if(r == count)
    	{
    		if(result.startsWith("0"))
    			return;
    		
    		numMap.put(Integer.parseInt(result), true);
    		return;
    	}
    	for(int i = 0; i < n; i++)
    	{
    		if(check[i])
    			continue;
    		check[i] = true;
    		addNum(n, r, count + 1, nums, check, result + nums[i]);
    		check[i] = false;
    	}
    }
    private static boolean isDecimal(boolean[] decimal, int num)
    {
    	if(num < 2)
    		return false;
    	
    	return !decimal[num];
    }
}
