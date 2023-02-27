class Solution {
    public int[] solution(String[] keymap, String[] targets) {
    	int[] arr = new int[26];
    	char c;
    	for(int i = 0; i < keymap.length; i++)
    	{
    		for(int j = 0; j < keymap[i].length(); j++)
    		{
    			c = keymap[i].charAt(j);
    			
    			if(arr[c - 65] == 0)
    				arr[c - 65] = j + 1;
    			else if(arr[c - 65] > j + 1)
    				arr[c - 65] = j + 1;
    		}
    	}
    	
    	int[] answer = new int[targets.length];
    	for(int i = 0; i < targets.length; i++)
    	{
    		for(int j = 0; j < targets[i].length(); j++)
    		{
    			c = targets[i].charAt(j);
    			if(arr[c - 65] == 0)
    			{
    				answer[i] = -1;
    				break;
    			}
    			answer[i] += arr[c - 65];
    		}
    	}
        return answer;
    }
}
