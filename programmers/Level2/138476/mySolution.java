import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(int k, int[] tangerine) {
    	// value로 값을 분류해야해. key가 아니고. value순 정렬
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int i = 0; i < tangerine.length; i++)
    	{
    		if(map.containsKey(tangerine[i]))
    			map.put(tangerine[i], map.get(tangerine[i]) + 1);
    		else
    			map.put(tangerine[i], 1);
    	}
    	
    	List<Map.Entry<Integer, Integer>> list= new LinkedList<>();
    	for(Map.Entry<Integer, Integer> entry : map.entrySet())
    		list.add(entry);

    	list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
    		public int compare(Map.Entry<Integer, Integer> x, Map.Entry<Integer, Integer> y)
    		{
    			return y.getValue() - x.getValue();
    		}
    	});
    	int count = 0;
    	for(Map.Entry<Integer, Integer> entry : list)
    	{
    		k -= entry.getValue();
    		count++;
    		if(k <= 0)
    			break;
    	}
        return count;
    }
}
