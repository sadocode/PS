class Solution {
	private static int min = 10000;
    public int solution(int[][] maps) {
    	boolean[][] check = new boolean[maps.length][maps[0].length];
    	check[0][0] = true;

    	for(int i = 0; i < maps.length; i++)
    	{
    		for(int j = 0; j < maps[i].length; j++)
    		{
    			if(maps[i][j] == 0)
    				check[i][j] = true;
    		}
    	}
    	
    	dfs(maps, check, 0, 0, 1);
        return min == 10000 ? -1 : min;
    }
    private static void dfs(int[][] maps, boolean[][] check, int x, int y, int count)
    {
    	if(x == maps.length - 1 && y == maps[0].length - 1)
    	{
    		if(min > count)
    			min = count;
    		
    		return;
    	}
    	
    	if(min < count || min == maps.length + maps[0].length - 1)
    	{
    		return;
    	}
    	
    	boolean[] path = new boolean[4];
    	
    	
    	if(x != maps.length - 1 && !check[x + 1][y]) // down
   			path[0] = true;
    	if(y != maps[0].length - 1 && !check[x][y + 1]) // right
    		path[1] = true;
    	if(x != 0 && !check[x - 1][y]) // up
   			path[2] = true;
    	if(y != 0 && !check[x][y - 1]) // left
    		path[3] = true;
    	
    	
    	for(int i = 0; i < 4; i++)
    	{
    		if(path[i])
    		{
    			if(i == 0) // down
    			{
    				check[x + 1][y] = true;
    				dfs(maps, check, x + 1, y, count + 1);
    				check[x + 1][y] = false;
    			}
    			else if(i == 1) // right
    			{
    				check[x][y + 1] = true;
    				dfs(maps, check, x, y + 1, count + 1);
    				check[x][y + 1] = false;
    			}
    			else if(i == 2) // up
    			{
    				check[x - 1][y] = true;
    				dfs(maps, check, x - 1, y, count + 1);
    				check[x - 1][y] = false;
    			}
    			else // left
    			{
    				check[x][y - 1] = true;
    				dfs(maps, check, x, y - 1, count + 1);
    				check[x][y - 1] = false;
    			}
    		}
    		
    	}
    }
}
