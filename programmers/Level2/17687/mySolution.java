class Solution {
	private static char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int index = 0;
        int finalIndex = (t - 1) * m + p;
        String s = null;
        int num = 0;
        while(index <= finalIndex)
        {
        	s = getNum(num++, n);
        	for(int i = 0; i < s.length(); i++)
        	{
        		index++;
        		if(p == m && index % m == 0  ||  index % m == p)
        		{
        			t--;
        			answer.append(s.charAt(i));
        		}
        		if(t == 0)
        			break;
        	}
        	
        	if(t == 0)
        		break;
        }
    
        return answer.toString();
    }
    private static String getNum(int targetNum, int value)
    {
    	if(targetNum == 0)
    		return "0";
    	
    	StringBuilder result = new StringBuilder();
    	while(targetNum > 0)
    	{
    		result.append(nums[targetNum % value]);
    		targetNum /= value;
    	}
    	return result.reverse().toString();
    }
}
