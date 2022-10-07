class Solution {
    public int solution(String skill, String[] skill_trees) {
    	String tempSkill = null;
    	int tempNum = 0;
    	int order = 0;
    	int countErr = 0;
    	
    	for(int i = 0; i < skill_trees.length; i++)
    	{
    		order = -1;
    		tempSkill = skill_trees[i];
    		for(int j = 0; j < tempSkill.length(); j++)
    		{
    			tempNum = skill.indexOf(tempSkill.charAt(j));
    			
    			if(tempNum != -1)
    			{
    				if((order == -1 && tempNum > 0) || (order != -1 && tempNum - order != 1))
    				{
    					countErr++;
    					break;
    				}
    				else 
    				{
    					order = tempNum;
    				}
    			}
    		}
    	}
    	return skill_trees.length - countErr;
    }
}
