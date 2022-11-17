class Solution {
	public int solution(int m, int n, int[][] puddles) {
    	int[][] path = new int[m][n];
    	path[0][0] = 1;
    	int num = 1000000007;
    	
    	for(int i = 0; i < puddles.length; i++)
    		path[puddles[i][0] - 1][puddles[i][1] - 1] = -1;
    	
    	boolean isFirstLineEnd = false;
    	for(int i = 0; i < m ; i++)
    	{
    		for(int j = 0; j < n; j++)
    		{
    			if(i == 0)
    			{
    				if(path[i][j] == -1)
    					isFirstLineEnd = true;
    				
    				if(!isFirstLineEnd && path[i][j] != -1)
    					path[i][j] = 1;
    				
    				continue;
    			}
    			
    			if(path[i][j] == -1)
    				continue;
    			
  				if(path[i - 1][j] != -1)
   					path[i][j] = path[i - 1][j];
  				
  				if(j > 0 && path[i][j - 1] != -1)
  					path[i][j] = (path[i][j] + path[i][j - 1]) % num;
    		}
    	}
    	
        return path[m - 1][n - 1];
    }
}
