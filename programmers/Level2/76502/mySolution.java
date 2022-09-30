import java.util.LinkedList;
import java.util.List;

class Solution {
    public int solution(String s) {
    	int sLen = s.length();
    	List<Character> list = new LinkedList<>();
    	int answer = 0;
    	boolean isOk = true;
    	
    	for(int i = 0; i < sLen; i++)
    	{
    		if(i != 0)
    			s = s.substring(1) + s.substring(0, 1);
    		
    		for(int j = 0; j < sLen; j++)
    		{
    			if(!isOk)
    				break;
    			
    			switch(s.charAt(j))
    			{
    			case '{':
    			case '[':
    			case '(':
    				list.add(s.charAt(j));
    				break;
    			case '}':
    				if(list.isEmpty() || list.get(list.size() - 1) != '{')
    					isOk = false;
    				else
    					list.remove(list.size() - 1);
    				break;
    			case ']':
    				if(list.isEmpty() || list.get(list.size() - 1) != '[')
    					isOk = false;
    				else
    					list.remove(list.size() - 1);
    				break;
    			case ')':
    				if(list.isEmpty() || list.get(list.size() - 1) != '(')
    					isOk = false;
    				else
    					list.remove(list.size() - 1);
    				break;
    			}
    		}
    		
    		if(isOk && list.isEmpty())
    			answer++;
    		
    		// 다음 연산을 위해 초기화
    		list = new LinkedList<>();
    		isOk = true;
    	}
    	
    	return answer;
    }
}
