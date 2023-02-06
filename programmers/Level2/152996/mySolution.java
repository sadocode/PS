import java.util.HashMap;
import java.util.Map;

class Solution {
    public long solution(int[] weights) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int i = 0; i < weights.length; i++)
    	{
    		if(map.containsKey(weights[i]))
    			map.put(weights[i], map.get(weights[i]) + 1);
    		else
    			map.put(weights[i], 1);
    	}
    	
    	long answer = 0;
    	long temp = 0;
    	for(Integer key : map.keySet())
    	{
    		temp = map.get(key);
    		
    		// 같은 값
    		if(temp > 1)
    			answer += temp * (temp - 1) / 2;
    		
    		// 2-3
    		if(key % 2 == 0 && map.containsKey((int)(key * 1.5)))
    			answer += temp * map.get((int)(key * 1.5));
    		
    		// 3-4
    		if(key % 3 == 0 && map.containsKey((int)(key * 4 / 3)))
    			answer += temp * map.get((int)(key * 4 / 3));
    		
    		// 2-4
    		if(map.containsKey(key * 2))
    			answer += temp * map.get(key * 2);
    	}
    	
        return answer;
    }
}
