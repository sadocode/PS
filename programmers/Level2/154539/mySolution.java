import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(int[] numbers) {
    	
    	// 오름차순 list
    	List<Node> list = new LinkedList<>();
    	int[] answer = new int[numbers.length];
    	
    	for(int i = 0; i < numbers.length; i++)
    	{
    		if(list.isEmpty())
    		{
    			this.addNewNode(list, numbers[i], i);
				continue;
    		}
    		
    		while(!list.isEmpty())
    		{
    			if(numbers[i] > list.get(0).key)
    			{
    				for(Integer idx : list.get(0).getMap().keySet())
    					answer[idx] = numbers[i];
    				list.remove(0);
    				if(list.isEmpty())
    					this.addNewNode(list, numbers[i], i);
    			}
    			else if(numbers[i] == list.get(0).key)
    			{
    				list.get(0).addIdx(i);
    				break;
    			}
    			else
    			{
    				this.addNewNode(list, numbers[i], i);
    				break;
    			}
    		}
    	}
    	
    	while(!list.isEmpty())
    	{
    		for(Integer idx : list.get(0).getMap().keySet())
    			answer[idx] = -1;
    		list.remove(0);
    	}
        return answer;
    }
    private void addNewNode(List<Node> list, int key, int idx)
    {
    	Node n = new Node(key);
    	n.addIdx(idx);
    	list.add(0, n);
    }
    private class Node {
    	int key;
    	Map<Integer, Boolean> map;
    	Node(int key)
    	{
    		this.map = new HashMap<>();
    		this.key = key;
    	}
    	public Map<Integer, Boolean> getMap()
    	{
    		return this.map;
    	}
    	public void addIdx(int idx)
    	{
    		this.map.put(idx, true);
    	}
    }
}
