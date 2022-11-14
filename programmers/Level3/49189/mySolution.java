import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
	
    public int solution(int n, int[][] edge) {
    	Map<Integer, Integer> map = new HashMap<>();
    	List<Integer> queue = new LinkedList<>();
    	boolean[] check = new boolean[n];
    	
    	// first node
    	map.put(1, 0);
    	queue.add(1);
    	check[0] = true;
    	
    	int tempX = 0;
    	int tempY = 0;
    	while(!queue.isEmpty())
    	{
    		for(int i = 0; i < edge.length; i++)
    		{
    			tempX = edge[i][0];
    			tempY = edge[i][1];
    			if(tempX == queue.get(0) && !check[tempY - 1])
    			{
    				check[tempY - 1] = true;
    				queue.add(tempY);
    				map.put(tempY, map.get(tempX) + 1);
    			}
    			else if(tempY == queue.get(0) && !check[tempX - 1])
    			{
    				check[tempX - 1] = true;
    				queue.add(tempX);
    				map.put(tempX, map.get(tempY) + 1);
    			}
    		}
    		queue.remove(0);
    	}
    	
    	int max = 0;
    	int count = 0;
    	for(Integer node : map.keySet())
    	{
    		if(map.get(node) > max)
    		{
    			max = map.get(node);
    			count = 1;
    		}
    		else if(map.get(node) == max)
    		{
    			count++;
    		}
    	}
    	return count;
    }
}
