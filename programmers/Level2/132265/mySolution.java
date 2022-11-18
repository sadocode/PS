import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] topping) {
    	Map<Integer, Integer> tMap = new HashMap<>();
    	
    	for(int i = 0; i < topping.length; i++)
    	{
    		if(tMap.containsKey(topping[i]))
    			tMap.put(topping[i], tMap.get(topping[i]) + 1);
    		else
    			tMap.put(topping[i], 1);
    	}
    	
        int answer = 0;
        Map<Integer, Boolean> cMap = new HashMap<>();
        for(int i = 0; i < topping.length; i++)
        {
        	if(tMap.get(topping[i]) == 1)
        		tMap.remove(topping[i]);
        	else
        		tMap.put(topping[i], tMap.get(topping[i]) - 1);
        	
        	cMap.put(topping[i], true);
        	if(tMap.size() == cMap.size())
        		answer++;
        }
        
        return answer;
    }
}
