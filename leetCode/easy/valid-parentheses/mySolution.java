import java.util.LinkedList;
import java.util.List;

class Solution {
    public boolean isValid(String s) {
    	List<Character> charList = new LinkedList<Character>();
    	int sLen = s.length();
    	
    	for(int i = 0; i < sLen; i++)
    	{
    		if(!this.isValid(s.charAt(i), charList))
    			return false;
    	}
    	
    	if(charList.size() != 0)
    		return false;
    	else
    		return true;
    }
    private boolean isValid(char c, List<Character> list)
    {
    	int listSize = list.size();
    	if(listSize == 0)
    	{	
    		list.add(c);
    		return true;
    	}

    	switch(c)
    	{
    	case ']':
    		if(list.get(listSize - 1) == '[')
    		{
    			list.remove(listSize - 1);
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    	case '}':
    		if(list.get(listSize - 1) == '{')
    		{
    			list.remove(listSize - 1);
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    	case ')':
    		if(list.get(listSize - 1) == '(')
    		{
    			list.remove(listSize - 1);
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    	case '[':
    	case '{':
    	case '(':
    		list.add(c);
    		return true;
    	}
    	return false;
    }
}
