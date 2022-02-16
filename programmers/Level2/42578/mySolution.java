import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
    	Map<String, Integer> cMap = new HashMap<String, Integer>();
    	int tempNum = 0;
    	
    	for(int i = 0; i < clothes.length; i++)
    	{
    		if(cMap.containsKey(clothes[i][1]))
    		{
    			tempNum = cMap.get(clothes[i][1]);
				cMap.put(clothes[i][1], ++tempNum);
    		}
    		else
			{
				cMap.put(clothes[i][1], 1);
			}
    	}

    	int result = 1;
    	for(String cType : cMap.keySet())
    	{
    		result *= (cMap.get(cType) + 1);
    	}
    	
    	return result - 1;
    }
}
