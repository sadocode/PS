import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
    	Map<String, Integer> idMap = new HashMap<>();
    	for(int i = 0; i < id_list.length; i++)
    		idMap.put(id_list[i], i);
    			
    	Map<String, Map<String, Boolean>> reportMap = new HashMap<>();
    	Map<String, Boolean> temp = null;
    	String[] arr;
    	for(int i = 0; i < report.length; i++)
    	{
    		arr = report[i].split(" ");
    		if(reportMap.containsKey(arr[1]))
    		{
    			temp = reportMap.get(arr[1]);
    			temp.put(arr[0], true);
    		}
    		else
    		{
    			temp = new HashMap<>();
    			temp.put(arr[0], true);
    			reportMap.put(arr[1], temp);
    		}
    	}
    	
    	int[] answer = new int[id_list.length];
    	for(String reportedUser : reportMap.keySet())
    	{
    		if(reportMap.get(reportedUser).size() >= k)
    		{
    			for(String user : reportMap.get(reportedUser).keySet())
    			{
    				answer[idMap.get(user)]++;
    			}
    		}
    	}
    	
        return answer;
    }
}
