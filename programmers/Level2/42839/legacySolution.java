import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
	private static TreeMap<Integer, Boolean> decimalMap = new TreeMap<>();
    private static Map<Integer, Boolean> numMap = new HashMap<>();
    
	public int solution(String numbers) {
    	char[] nums = new char[numbers.length()];
    	boolean[] check = new boolean[nums.length];
    	
    	for(int i = 0; i < numbers.length(); i++)
    		nums[i] = numbers.charAt(i);
    	
    	for(int i = 1; i <= nums.length; i++)
    		addNum(nums.length, i, 0, nums, check, "");
    	
    	int answer = 0;
    	
    	decimalMap.put(2, true);

    	for(Integer num : numMap.keySet())
    	{
    		if(num > decimalMap.lastKey())
    			addDecimal(num);
    		
    		if(num < decimalMap.lastKey() && decimalMap.containsKey(num))
    		{
    			answer++;
    			continue;
    		}
    		
    		if(isDecimal(num))
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
    private boolean isDecimal(int num)
    {
    	if(num < 2)
    		return false;
    	if(decimalMap.containsKey(num))
    		return true;
    	
    	for(Integer key : decimalMap.keySet())
    	{
    		if(num % key == 0)
    			return false;
    	}
    	return true;
    }
    private void addDecimal(int num)
    {
    	for(int i = decimalMap.lastKey(); i <= num; i++)
    	{
    		if(isDecimal(i))
    			decimalMap.put(i, true);
    	}
    }
}
