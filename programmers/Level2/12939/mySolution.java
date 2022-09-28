class Solution {
    public String solution(String s) {
    	String[] result = s.split(" ");
    	int max = 0;
    	int min = 0;
    	int sLength = result.length;
    	
    	int temp = 0;
    	for(int i = 0; i < sLength; i++)
    	{
    		temp = Integer.parseInt(result[i]);
    		if(i == 0)
    		{
    			min = temp;
    			max = temp;
    			continue;
    		}
    		
    		if(max < temp)
    			max = temp;
    		if(min > temp)
    			min = temp;
    	}
    	
    	StringBuilder answer = new StringBuilder().append(min).append(" ").append(max);
    	return answer.toString();
    }
}
