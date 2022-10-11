import java.util.LinkedList;
import java.util.List;

class Solution {
    public int solution(int cacheSize, String[] cities) {
    	if(cacheSize == 0)
    		return cities.length * 5;
    	
    	int answer = 0;
    	List<String> list = new LinkedList<>();
    	int cityLen = cities.length;
    	
    	for(int i = 0; i < cityLen; i++)
    	{
    		answer += getTime(cacheSize, list, cities[i].toLowerCase());
    	}
    	
        return answer;
    }
    private static int getTime(int cacheSize, List list, String city)
    {
    	int i = list.indexOf(city);
    	
    	if(i == -1)
    	{
    		if(cacheSize == list.size())
    			list.remove(0);
    		list.add(city);
    		return 5;
    	}
    	else
    	{
    		list.remove(i);
    		list.add(city);
    		return 1;
    	}
    }
}
