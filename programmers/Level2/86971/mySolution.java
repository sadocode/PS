import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(int n, int[][] wires) {
        
    	Map<Integer, Boolean> map1 = null;
    	Map<Integer, Boolean> map2 = null;
    	List<int[]> list = new LinkedList<>();
    	int[] temp = null;
    	int min = n - 1;
    	int subtract = 0;
    	
    	// 몇 번째 선을 끊을 건지 선택
    	for(int i = 0; i < n - 1; i++)
    	{
    		map1 = new HashMap<>();
    		map2 = new HashMap<>();
    		map1.put(wires[i][0], true);
    		map2.put(wires[i][1], true);
    		
    		for(int j = 0; j < n - 1; j++)
    		{
    			if(i == j)
    				continue;
    			temp = wires[j];
    			if(map1.containsKey(temp[0]) || map1.containsKey(temp[1]))
    			{
    				map1.put(temp[0], true);
    				map1.put(temp[1], true);
    			}
    			else if(map2.containsKey(temp[0]) || map2.containsKey(temp[1]))
    			{
    				map2.put(temp[0], true);
    				map2.put(temp[1], true);
    			}
    			else
    			{
    				list.add(temp);
    			}
    		}
    		
    		int idx = 0;
    		int[] t;
    		while(!list.isEmpty())
    		{
    			t = list.get(idx);
    			if(map1.containsKey(t[0]) || map1.containsKey(t[1]))
    			{
    				map1.put(t[0], true);
    				map1.put(t[1], true);
    				list.remove(idx);
    			}
    			else if(map2.containsKey(t[0]) || map2.containsKey(t[1]))
    			{
    				map2.put(t[0], true);
    				map2.put(t[1], true);
    				list.remove(idx);
    			}
    			
    			idx++;
    			if(idx >= list.size())
    				idx = 0;
    		}
    		
    		subtract = map1.size() > map2.size() ? map1.size() - map2.size() : map2.size() - map1.size();
    		
    		if(min > subtract)
    			min = subtract;
    	}
    	return min;
    }
}
