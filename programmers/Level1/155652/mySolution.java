class Solution {
    public String solution(String s, String skip, int index) {
    	boolean[] arr = new boolean[26];
    	for(int i = 0; i < skip.length(); i++)
    		arr[skip.charAt(i) - 97] = true;

    	StringBuilder sb = new StringBuilder();
    	int j = 0;
    	char c;
    	for(int i = 0; i < s.length(); i++)
    	{
    		j = index;
    		c = s.charAt(i);
    		while(j > 0)
    		{
    			if(c == 'z')
    				c = 'a';
    			else
    				c += 1;
    			
    			if(arr[c - 97])
    				continue;
    			else
    				j--;
    		}
    		sb.append(c);
    	}
    	return sb.toString();
    }
}
