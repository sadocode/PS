class Solution {
    public int[] solution(String s) {
    	int[] answer = new int[2];
    	
    	while(!"1".equals(s))
    	{
    		for(int i = 0; i < s.length(); i++)
    		{
    			if(s.charAt(i) == '0')
    				answer[1]++;
    		}
    		s = s.replaceAll("0", "");
    		s = getBinaryNum(s.length());
    		answer[0]++;
    	}
    	
    	return answer;
    }
    private static String getBinaryNum(int num)
    {
    	StringBuilder result = new StringBuilder();
    	
    	while(num > 0)
    	{
    		result.append(num % 2);
    		num /= 2;
    	}
    	
    	return result.reverse().toString();
    }
}
