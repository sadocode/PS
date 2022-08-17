import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int []arr) {
    	List<Integer> list = new ArrayList<>();
    	
    	list.add(arr[0]);
    	int tempValue = arr[0];
    	int arrLength = arr.length;
    	
    	for(int i = 1; i < arrLength; i++)
    	{
    		if(tempValue != arr[i])
    		{
    			tempValue = arr[i];
    			list.add(tempValue);
    		}
    	}

    	return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
}
