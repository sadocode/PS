import java.util.LinkedList;
import java.util.List;

class Solution {
	private static final String DEQUEUE_MIN = "D -1";
	private static final String DEQUEUE_MAX = "D 1";
	
    public int[] solution(String[] operations) {
    	List<Integer> list = new LinkedList<>();
    	int temp = 0;
    	for(int i = 0; i < operations.length; i++)
    	{
    		if(operations[i].equals(DEQUEUE_MIN))
    		{
    			if(list.size() == 0)
    				continue;
    			list.remove(list.size() -1);
    		}
    		else if(operations[i].equals(DEQUEUE_MAX))
    		{
    			if(list.size() == 0)
    				continue;
    			list.remove(0);
    		}
    		else
    		{
    			temp = Integer.parseInt(operations[i].substring(2));
    			if(list.isEmpty())
    			{
    				list.add(temp);
    				continue;
    			}
    			
    			for(int j = 0; j < list.size(); j++)
    			{
    				if(temp > list.get(j))
    				{
    					list.add(j, temp);
    					break;
    				}
    				if(j == list.size() - 1)
    				{
    					list.add(temp);
    					break;
    				}
    			}
    		}
    	}
    	
    	int[] answer = new int[2];
    	if(list.size() == 0)
    	{
    		answer[0] = 0;
    		answer[1] = 0;
    	}
    	else
    	{
    		answer[0] = list.get(0);
    		answer[1] = list.get(list.size() - 1);
    	}
    	return answer;
    }
}
