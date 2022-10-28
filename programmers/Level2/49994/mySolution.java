import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String dirs) {
    	Map<String, Boolean> map = new HashMap<>();
    	int[] pos = {0, 0};
    	int sLen = dirs.length();
    	
    	StringBuilder tempS = null;
    	char tempC;
    	for(int i = 0; i < sLen; i++)
    	{
    		tempC = dirs.charAt(i);

    		switch(tempC)
    		{
    		case 'L':
    			if(pos[0] == -5)
    				break;
    			tempS = new StringBuilder();
    			tempS.append(pos[0] - 1).append(pos[1]).append('_').append(pos[0]).append(pos[1]);
    			map.put(tempS.toString(), true);
    			pos[0]--;
    			break;
    		case 'R':
    			if(pos[0] == 5)
    				break;
    			tempS = new StringBuilder();
    			tempS.append(pos[0]).append(pos[1]).append('_').append(pos[0] + 1).append(pos[1]);
    			map.put(tempS.toString(), true);
    			pos[0]++;
    			break;
    		case 'U':
    			if(pos[1] == 5)
    				break;
    			tempS = new StringBuilder();
    			tempS.append(pos[0]).append(pos[1]).append('_').append(pos[0]).append(pos[1] + 1);
    			map.put(tempS.toString(), true);
    			pos[1]++;
    			break;
    		case 'D':
    			if(pos[1] == -5)
    				break;
    			tempS = new StringBuilder();
    			tempS.append(pos[0]).append(pos[1] - 1).append('_').append(pos[0]).append(pos[1]);
    			map.put(tempS.toString(), true);
    			pos[1]--;
    			break;
    		}
    	}
    	return map.size();
    }
}
