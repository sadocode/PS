import java.util.ArrayList;
import java.util.List;

class Solution
{
    public int solution(String s)
    {
    	List<String> list = new ArrayList<>();
    	int sLen = s.length();
    	
    	String temp = null;
    	for(int i = 0; i < sLen; i++)
    	{
   			temp = s.substring(i, i + 1);
   			
   			if(list.size() > 0)
   			{
   				if(temp.equals(list.get(list.size() - 1)))
   					list.remove(list.size() - 1);
   				else
   					list.add(temp);
   			}
   			else
   			{
   				list.add(temp);
   			}
    	}
    	
    	if(list.size() == 0)
    		return 1;
    	else
    		return 0;
    }
}
