import java.util.ArrayList;
import java.util.List;

class Solution {
    public double[] solution(int k, int[][] ranges) {
    	List<Integer> list = new ArrayList<>();
    	
    	while(k >= 1)
    	{
    		list.add(k);
    		if(k == 1)
    			break;
    		else if(k % 2 == 0)
    			k /= 2;
    		else
    			k = 3 * k + 1;
    	}
        
    	// 너비 값 
    	double[] size = new double[list.size() - 1];
    	int value = list.get(0);
    	double tempSize = 0;
    	for(int i = 1; i < list.size(); i++)
    	{
    		tempSize = 0;
    		if(value > list.get(i))
    		{
    			tempSize += ((double)value - (double)list.get(i)) / 2;
    			tempSize += list.get(i);
    		}
    		else
    		{
    			tempSize += ((double)list.get(i) - (double)value) / 2;
    			tempSize += value;
    		}
    		size[i - 1] = tempSize;
    		value = list.get(i);
    	}
    	
    	// 적분 값
    	double[] answer = new double[ranges.length];
    	for(int i = 0; i < ranges.length; i++)
    	{
    		if(list.size() + ranges[i][1] == ranges[i][0] + 1)
    			answer[i] = 0.0;
    		else if(list.size() + ranges[i][1] < ranges[i][0] + 1)
    			answer[i] = -1.0;
    		else
    		{
    			tempSize = 0;
    			for(int j = ranges[i][0]; j < list.size() + ranges[i][1] - 1; j++)
    				tempSize += size[j];
    			answer[i] = tempSize;
    		}
    	}
    	
        return answer;
    }
}
