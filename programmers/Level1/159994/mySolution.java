class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
    	boolean target = true;
    	int idx1 = 0;
    	int idx2 = 0;
    	int idxGoal = 0;
    	int count = 0;
		if(goal[0].equals(cards1[0]))
			target = true;
		else if(goal[0].equals(cards2[0]))
			target = false;
		else
			return "No";
		
    	while(idxGoal < goal.length)
    	{
    		count = 0;
    		if(target)
    		{
    			while(idx1 < cards1.length && idxGoal < goal.length)
    			{
    				if(cards1[idx1].equals(goal[idxGoal]))
        			{
        				idx1++;
        				idxGoal++;
        				count++;
        			}
    				else
    				{
    					if(count == 0)
    						return "No";
    					else
    					{
    						target = false;
    						break;
    					}
    				}
    			}
    			
    			if(idx1 == cards1.length)
    				target = false;
    		}
    		else
    		{
    			while(idx2 < cards2.length && idxGoal < goal.length)
    			{
    				if(cards2[idx2].equals(goal[idxGoal]))
        			{
        				idx2++;
        				idxGoal++;
        				count++;
        			}
    				else
    				{
    					if(count == 0)
    						return "No";
    					else
    					{
    						target = true;
    						break;
    					}
    				}
    			}
    			
    			if(idx2 == cards2.length)
    				target = true;
    		}
    	}
    	
    	if(idxGoal == goal.length)
    		return "Yes";
    	else
    		return "No";
    }
}
