import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] solution(String[] maps) {
    	int line = maps.length;
    	int col = maps[0].length();
    	boolean[][] check = new boolean[line][col];
    	List<Integer> list = new LinkedList<>();
    	int temp = 0;
    	for(int i = 0; i < line; i++)
    	{
    		for(int j = 0; j < col; j++)
    		{
    			temp = dfs(check, maps, i, j, 0);
    			if(temp > 0)
    				list.add(temp);
    		}
    	}
    	int[] arr = null;
    	if(list.isEmpty())
    	{
    		arr = new int[1];
    		arr[0] = -1;
    	}
    	else
    	{
    		arr = list.stream().mapToInt(i -> i).toArray();
    		Arrays.sort(arr);
    	}
    	return arr;
    }
    private static int dfs(boolean[][] check, String[] maps, int x, int y, int count)
    {
    	if(check[x][y] || maps[x].charAt(y) == 'X')
    		return count;
    	
    	int result = count + Integer.parseInt("" + (maps[x].charAt(y) - 48));
    	check[x][y] = true;
    	
    	if(x > 0)
    		result = dfs(check, maps, x - 1, y, result);
    	if(y > 0)
    		result = dfs(check, maps, x, y - 1, result);
    	if(x + 1 < check.length)
    		result = dfs(check, maps, x + 1, y, result);
    	if(y + 1 < check[0].length)
    		result = dfs(check, maps, x, y + 1, result);
    	
    	return result;
    }
}
