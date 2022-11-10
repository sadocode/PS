import java.util.Collections;
import java.util.TreeMap;

class Solution {
    public long solution(int n, int[] works) {
    	TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
    	for(int i = 0; i < works.length; i++)
    	{
    		if(map.containsKey(works[i]))
    			map.put(works[i], map.get(works[i]) + 1);
    		else
    			map.put(works[i], 1);
    	}
    	
    	int firstKey = 0;
    	while(n > 0)
    	{
    		if(map.isEmpty())
    			break;
    		
    		firstKey = map.firstKey();
    		
    		if(map.get(firstKey) > 1)
    			map.put(firstKey, map.get(firstKey) - 1);
    		else if(map.get(firstKey) == 1)
    			map.remove(firstKey);
    		
    		if(firstKey > 1)
			{
				if(map.containsKey(firstKey - 1))
					map.put(firstKey - 1, map.get(firstKey - 1) + 1);
				else
					map.put(firstKey - 1, 1);
			}
    		
    		n--;
    	}
    	
    	if(map.size() == 0)
    		return 0;
    	
    	long answer = 0;
    	for(Integer key : map.keySet())
    	{
    		answer += (long)key * (long)key * (long)map.get(key);
    	}
        
        return answer;
    }
}
