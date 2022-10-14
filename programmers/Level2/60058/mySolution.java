import java.util.LinkedList;
import java.util.List;

class Solution {
    public String solution(String p) {
    	return process(p);
    }
    
    private static String process(String s)
    {
    	if(s.length() == 0)
    		return s;
    	
    	// u가 정상인지 체크하는 list
    	List<Character> uList = new LinkedList<>();
    	
    	int countL = 0;
    	int countR = 0;
    	boolean isURight = true;
    	int i = 0;
    	for(i = 0; i < s.length(); i++)
    	{
    		if(s.charAt(i) == '(')
    			countL++;
    		else
    			countR++;
    		
    		// uList에 담음으로써 정상여부 체크
    		if(isURight)
    			isURight = addC(uList, s.charAt(i));
    		
    		if(countL == countR)
    			break;
    	}
    	
    	String u = s.substring(0, i + 1);
    	String v = s.substring(i + 1);
    	
    	if(isURight)
    	{
    		return u + process(v);
    	}
    	else
    	{
    		String result = "(" + process(v) + ")";
    		u = u.substring(1, u.length() - 1);
    		u = u.replace('(', '!').replace(')', '(').replace('!', ')');
    		result += u;
    		return result;
    	}
    }
    private static boolean addC(List<Character> list, char c)
    {
    	if(c == '(')
    	{
    		list.add(c);
    	}
    	else   // c == ')'
    	{
    		if(list.size() != 0)
    		{
    			if(list.get(list.size() - 1) != '(')
					return false;
    			else
    				list.remove(list.size() - 1);
    		}
    		else
    			return false;
    	}
    	return true;
    }
}
