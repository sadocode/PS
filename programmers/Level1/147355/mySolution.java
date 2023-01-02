class Solution {
    public int solution(String t, String p) {
    	int pLen = p.length();
    	int tLen = t.length();
    	StringBuilder sb = new StringBuilder();
    	sb.append(t.substring(0, pLen));
    	int answer = 0;
    	
    	for(int i = pLen; i <= tLen; i++)
    	{
    		if(sb.toString().compareTo(p) <= 0)
    		{
    			answer++;
    		}
    		
    		if(i < tLen)
    		{
    			sb.append(t.charAt(i));
    			sb.deleteCharAt(0);
    		}
    	}
        
        return answer;
    }
}
