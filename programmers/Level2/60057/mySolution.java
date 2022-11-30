class Solution {
    public int solution(String s) {
    	int len = s.length();
    	if(len <= 2)
    		return len;
    	
    	StringBuilder t1 = null;
    	StringBuilder t2 = null;
    	StringBuilder result = null;
    	
    	int idx = 0;
    	int count = 0;
    	int min = len;
    	// i 단위로 잘랐을 때
    	for(int i = 1; i <= len / 2; i++)
    	{
    		count = 1;
    		t1 = new StringBuilder();
    		t2 = new StringBuilder();
    		result = new StringBuilder();

    		// 최초
    		for(int j = 0; j < i; j++)
    			t1.append(s.charAt(j));
    		
    		idx = i;
    		while(idx + i <= s.length())
    		{
    			t2 = new StringBuilder();
   				for(int j = idx; j < idx + i; j++)
   					t2.append(s.charAt(j));

   				if(t1.toString().equals(t2.toString()))
    			{
    				count++;
    			}
    			else
    			{
    				if(count == 1)
    					result.append(t1);
    				else
    					result.append(count).append(t1);
    				
    				t1 = t2;
    				count = 1;
    			}
   				
   				if(idx + 2 * i > s.length())
   				{
   					if(idx + i == s.length())
   					{
   						if(count == 1)
							result.append(t2);
   						else
   							result.append(count).append(t1);
   					}
   					else if(idx + i < s.length())
   					{
   						if(count != 1)
   							result.append(count).append(t1);
   						else
   							result.append(t1);
   						
   						t2 = new StringBuilder();
						for(int j = idx + i; j < s.length(); j++)
			   				t2.append(s.charAt(j));
						result.append(t2);
   					}
   					
   				}
   				idx += i;
    		}

    		if(min > result.length())
    			min = result.length();
    	}
    	
        return min;
    }
}
