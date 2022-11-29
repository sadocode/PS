import java.util.TreeMap;

class Solution {
    public int[] solution(int k, int[] score) {
    	TreeMap<Integer, Integer> map = new TreeMap<>();
    	int[] answer = new int[score.length];
    	map.put(score[0], 1);
    	answer[0] = score[0];
    	
    	for(int i = 1; i < score.length; i++)
    	{
    		if(i < k)
    		{
    			if(map.containsKey(score[i]))
    				map.put(score[i], map.get(score[i]) + 1);
    			else
    				map.put(score[i], 1);
    			answer[i] = map.firstKey();
    		}
    		else
    		{
    			if(score[i] > map.firstKey())
    			{
    				if(map.firstEntry().getValue() == 1)
    					map.remove(map.firstKey());
    				else
    					map.put(map.firstKey(), map.get(map.firstKey()) - 1);
    				
    				if(map.containsKey(score[i]))
    					map.put(score[i], map.get(score[i]) + 1);
    				else
    					map.put(score[i], 1);
    			}
    			
    			answer[i] = map.firstKey();
    		}
    	}
    	
    	return answer;
    }
}
