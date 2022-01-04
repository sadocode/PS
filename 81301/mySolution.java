class Solution {
    public int solution(String s) {
    	StringBuilder result = new StringBuilder();
    	char[] charArray = s.toCharArray();
    	int i = 0;
    	
    	while(i < s.length())
    	{
    		if(charArray[i] >= 48 && charArray[i] <= 57)
    		{	
    			result.append(charArray[i++]);
    		}
    		else if(charArray[i] == 'z')
    		{
    			result.append("0");
    			i += 4;
    		}
    		else if(charArray[i] == 'o')
    		{
    			result.append("1");
    			i += 3;
    		}
    		else if(charArray[i] == 't')
    		{
    			if(charArray[i + 1] == 'w')
    			{
    				result.append("2");
    				i += 3;
    			}
    			else
    			{
    				result.append("3");
    				i += 5;
    			}
    		}
    		else if(charArray[i] == 'f')
    		{
    			if(charArray[i + 1] == 'o')
    			{
    				result.append("4");
    			}
    			else
    			{
    				result.append("5");
    			}
    			i += 4;
    		}
    		else if(charArray[i] == 's')
    		{
    			if(charArray[i + 1] == 'i')
    			{
    				result.append("6");
    				i += 3;
    			}
    			else
    			{
    				result.append("7");
    				i += 5;
    			}
    		}
    		else if(charArray[i] == 'e')
    		{
    			result.append("8");
    			i += 5;
    		}
    		else if(charArray[i] == 'n')
    		{
    			result.append("9");
    			i += 4;
    		}
    	}
    	
    	return Integer.parseInt(result.toString());
    }
}
