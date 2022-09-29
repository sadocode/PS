import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
    	
    	s = s.substring(1, s.length() - 1);
    	
    	String[] str1 = s.split("},");
    	int[] pos = new int[str1.length];
    	
    	for(int i = 0; i < str1.length; i++)
    	{
    		str1[i] = str1[i].substring(1);
    	
    		if(i + 1 == str1.length)
    			str1[i] = str1[i].substring(0, str1[i].length() - 1);
    		
    		pos[str1[i].split(",").length - 1] = i;
    	}

    	Map<Integer, Boolean> countedNum = new HashMap<>();
    	int[] answer = new int[str1.length];
    	String[] str2 = null;
    	int temp = 0;
    	for(int i = 0; i < pos.length; i++)
    	{
    		str2 = str1[pos[i]].split(",");
    		for(int j = 0; j < str2.length; j++)
    		{
    			temp = Integer.parseInt(str2[j]);
    			if(!countedNum.containsKey(temp))
    			{
    				countedNum.put(temp, true);
    				answer[i] = temp;
    				break;
    			}
    		}
    	}
    	
    	return answer;
    }
}
