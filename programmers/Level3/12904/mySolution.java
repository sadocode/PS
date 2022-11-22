iclass Solution
{
    public int solution(String s)
    {
    	int len = 0;
    	while(len <= s.length() - 2)
    	{
    		for(int i = 0; i <= len; i++)
    		{
    			if(isPelan(s, i, s.length() - len + i - 1))
    				return s.length() - len;
    		}
    		len++;
    	}
        return 1;
    }
    private static boolean isPelan(String s, int firstIdx, int lastIdx)
    {
    	int count = 0;
    	
    	for(int i = firstIdx; i <= (firstIdx + lastIdx) / 2; i++)
    	{
    		if(s.charAt(i) != s.charAt(lastIdx - count))
    			return false;
    		count++;
    	}
    	return true;
    }
}
