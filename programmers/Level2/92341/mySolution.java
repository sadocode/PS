import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
    	
    	int recordLen = records.length;
    	int defaultTime = fees[0];
    	int defaultFee = fees[1];
    	int unitTime = fees[2];
    	int unitFee = fees[3];
    	
    	// 차량의 이용시간을 저장하는 map
    	Map<String, Integer> totalMap = new TreeMap<>();
    	// 차량의 입차 시간을 저장하는 map
    	Map<String, String> tempMap = new HashMap<>();
    	String[] temp = null;
    	
    	for(int i = 0; i < recordLen; i++)
    	{
    		temp = records[i].split(" ");
    		if(tempMap.containsKey(temp[1]))
    		{
    			addTime(totalMap, temp[1], getMin(tempMap.get(temp[1]), temp[0]));
    			tempMap.remove(temp[1]);
    		}
    		else
    		{
    			tempMap.put(temp[1], temp[0]);
    		}
    	}
    	
    	if(tempMap.size() != 0)
    	{
    		for(String key : tempMap.keySet())
    		{
    			addTime(totalMap, key, getMin(tempMap.get(key), "23:59"));
    		}
    	}
    	
    	double ceilTime = 0;
    	for(String key : totalMap.keySet())
    	{
    		int time = totalMap.get(key);
    		if(defaultTime >= time)
    		{
    			totalMap.put(key, defaultFee);
    		}
    		else
    		{
    			ceilTime = Math.ceil((double)(time - defaultTime) / (double)unitTime);
    			totalMap.put(key, defaultFee + (int)Math.round(ceilTime) * unitFee);
    		}
    	}
    	
    	int[] answer = new int[totalMap.size()];
    	int i = 0;
    	for(String key : totalMap.keySet())
    	{
    		answer[i++] = totalMap.get(key);
    	}
    	
        return answer;
    }
    private static int getMin(String start, String end)
    {
    	int startHour = Integer.parseInt(start.split(":")[0]);
    	int startMin = Integer.parseInt(start.split(":")[1]);
    	int endHour = Integer.parseInt(end.split(":")[0]);
    	int endMin = Integer.parseInt(end.split(":")[1]);
    	
    	int result = 0;
    	if(endMin < startMin)
    	{
    		result = 60 - startMin + endMin;
    		result += (endHour - startHour - 1) * 60;
    	}
    	else
    	{
    		result = endMin - startMin + (endHour - startHour) * 60; 
    	}
    	return result;
    }
    private static void addTime(Map<String, Integer> map, String key, int time)
    {
    	if(map.containsKey(key))
    		map.put(key, map.get(key) + time);
    	else
    		map.put(key, time);
    }
}
