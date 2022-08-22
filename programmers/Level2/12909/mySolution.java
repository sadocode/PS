class Solution {
    boolean solution(String s) {
        int sLen = s.length();
        
        int count = 0;
        for(int i = 0; i < sLen; i++)
        {
        	if(s.charAt(i) == '(')
        		count++;
        	else
        		count--;
        	
        	if(count < 0)
        		return false;
        }
        if(count != 0)
        	return false;
        
        return true;
    }
}
