class Solution {
    public int[] solution(String[] wallpaper) {
    	int[] answer = new int[4];
    	boolean xcheck = false;
    	boolean ycheck = false;
    	
    	for(int i = 0; i < wallpaper.length; i++)
    	{
    		for(int j = 0; j < wallpaper[i].length(); j++)
    		{
    			if(wallpaper[i].charAt(j) == '#')
    			{
    				if(!ycheck)
    				{
    					ycheck = true;
    					answer[0] = i;
    				}
    				answer[2] = i + 1;
    			}
    		}
    	}
    	
    	for(int i = 0; i < wallpaper[0].length(); i++)
    	{
    		for(int j = 0; j < wallpaper.length; j++)
    		{
    			if(wallpaper[j].charAt(i) == '#')
    			{
    				if(!xcheck)
    				{
    					xcheck = true;
    					answer[1] = i;
    				}
    				answer[3] = i + 1;
    			}
    		}
    	}
        
        return answer;
    }
}
