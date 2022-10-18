import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] arr) {
    	
    	Map<Integer, Integer> map = new HashMap<>();
    	int answer = 1;
    	
    	for(int i = 0; i < arr.length; i++)
    	{
    		if(arr[i] == 0)
    			continue;
    		getDivisor(map, arr[i]);
    	}
    	
    	for(Integer key : map.keySet())
    		answer *= getNumber(key, map.get(key));
        
        return answer;
    }
    private static void getDivisor(Map<Integer, Integer> map, int num)
    {
    	int tempCount = 0;
    	for(int i = 2; i <= num; i++)
    	{
    		tempCount = 0;
    		
    		while(num % i == 0)
    		{
    			tempCount++;
    			num /= i;
    		}
    		
    		if(tempCount != 0)
    		{
    			if(!map.containsKey(i))
    				map.put(i, tempCount);
    			else
    				map.put(i, tempCount > map.get(i) ? tempCount : map.get(i));
    		}
    	}
    }
    private static int getNumber(int key, int value)
    {
    	int result = 1;
    	for(int i = 0; i < value; i++)
    		result *= key;
    	return result;
    }
}
