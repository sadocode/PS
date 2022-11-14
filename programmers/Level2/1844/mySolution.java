import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(int[][] maps) {
    	List<Node> queue = new LinkedList<>();
    	Map<Node, Integer> map = new HashMap<>();
    	boolean[][] check = new boolean[maps.length][maps[0].length];
    	
    	for(int i = 0; i < maps.length; i++)
    	{
    		for(int j = 0; j < maps[i].length; j++)
    		{
    			if(maps[i][j] == 1)
    				check[i][j] = true;
    		}
    	}
    	check[0][0] = false;
    	
    	int min = 10000;
    	Node node = new Node(0, 0);
    	queue.add(node);
    	map.put(node, 1);
    	
    	Node temp;
    	int tempX = 0;
    	int tempY = 0;
    	while(!queue.isEmpty())
    	{
    		tempX = queue.get(0).getX();
    		tempY = queue.get(0).getY();
    		if(tempX == maps.length - 1 && tempY == maps[0].length - 1)
    			break;
    		
    		if(tempX < maps.length - 1 && check[tempX + 1][tempY])
    		{
    			temp = new Node(tempX + 1, tempY);
    			queue.add(temp);
    			map.put(temp, map.get(queue.get(0)) + 1);
    			check[tempX + 1][tempY] = false;
    		}
    		
    		if(tempY < maps[0].length - 1 && check[tempX][tempY + 1])
    		{
    			temp = new Node(tempX, tempY + 1);
    			queue.add(temp);
    			map.put(temp, map.get(queue.get(0)) + 1);
    			check[tempX][tempY + 1] = false;
    		}
    		
    		if(tempX > 0 && check[tempX - 1][tempY])
    		{
    			temp = new Node(tempX - 1, tempY);
    			queue.add(temp);
    			map.put(temp, map.get(queue.get(0)) + 1);
    			check[tempX - 1][tempY] = false;
    		}
    		
    		if(tempY > 0 && check[tempX][tempY - 1])
    		{
    			temp = new Node(tempX, tempY - 1);
    			queue.add(temp);
    			map.put(temp, map.get(queue.get(0)) + 1);
    			check[tempX][tempY - 1] = false;
    		}
    		
    		queue.remove(0);
    	}

    	tempX = maps.length - 1;
    	tempY = maps[0].length - 1;
    	
    	for(Node n : map.keySet())
    	{
    		if(n.isNode(tempX, tempY))
    			return map.get(n);
    	}
    	
    	return -1;
    }
    class Node
    {
    	private int x = 0;
    	private int y = 0;
    	Node(int x, int y)
    	{
    		this.x = x;
    		this.y = y;
    	}
    	public boolean isNode(int x, int y)
    	{
    		if(this.x == x && this.y == y)
    			return true;
    		else
    			return false;
    	}
    	public int getX()
    	{
    		return this.x;
    	}
    	public int getY()
    	{
    		return this.y;
    	}
    }
}
