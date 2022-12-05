class Solution {
    public String solution(int[] food) {
    	StringBuilder a = new StringBuilder();
    	
    	for(int i = 0; i < food.length; i++)
    	{
    		for(int j = 0; j < food[i] / 2; j++)
    		{
    			a.append(i);
    		}
    	}
    	return a.toString() + "0" + a.reverse().toString();
    }
}
