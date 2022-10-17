class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int sLen = s.length();
        boolean isFirst = true;
        
        char temp;
        for(int i = 0; i < sLen; i++)
        {
        	temp = s.charAt(i);
        	if(isFirst)
        		answer.append(Character.toString(temp).toUpperCase());
        	else
        		answer.append(Character.toString(temp).toLowerCase());
        	
        	if(temp != ' ')
        		isFirst = false;
        	else
        		isFirst = true;
        }
        	
        return answer.toString();
    }
}
