class Solution {
    public int solution(String s) {
    	int result = 0;
    	int count = 0;
    	char temp = 'a';
    	for(int i = 0; i < s.length(); i++)
    	{
    		if(count == 0)
    		{
    			temp = s.charAt(i);
    			count++;
    		}
    		else
    		{
    			if(temp == s.charAt(i))
    			{
    				count++;
    			}
    			else
    			{
    				count--;
    				
    				if(count == 0)
    					result++;
    			}
    		}
    		
    		if(i + 1 == s.length() && count > 0)
    			result++;
    	}
    	return result;
    }
}
