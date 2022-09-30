import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int solution(int[] citations) {

    	Map<Integer, Integer> data = new TreeMap<>(Collections.reverseOrder());
    	int cLen = citations.length;
    	
    	for(int i = 0; i < cLen; i++)
    	{
    		if(data.containsKey(citations[i]))
    			data.put(citations[i], data.get(citations[i]) + 1);
    		else
    			data.put(citations[i], 1);
    	}
    	
    	int answer = 0;
    	int count = 0;
    	
    	for(int i = cLen; i > 0; i--)
    	{
    		for(int key : data.keySet())
        	{
    			if(key < i)
    				break;
    			
        		count += data.get(key);
        		
        		if(count >= i)
        		{
        			answer = i;
        			break;
        		}
        	}
    		if(answer != 0)
    			break;
    		count = 0;
    	}
    	
    	
    	return answer;
    }
}
