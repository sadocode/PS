import java.util.LinkedList;
import java.util.List;

class Solution {
	private static List<Integer> stack = new LinkedList<>();
    public int solution(int[] order) {
    	int answer = 0;
    	int len = order.length;
    	
    	int[] nums = new int[len];
    	for(int i = 0; i < len; i++)
    		nums[i] = i + 1;
    	
    	int numIndex = 0;
    	for(int i = 0; i < len; i++)
    	{
    		if(nums[numIndex] > order[i])
    		{
    			if(stack.get(stack.size() - 1) == order[i])
    			{
    				answer++;
    				stack.remove(stack.size() - 1);
    				continue;
    			}
    			else
    			{
    				return answer;
    			}
    		}
    		
    		while(nums[numIndex] <= order[i])
    		{
    			if(nums[numIndex] == order[i])
        		{
        			answer++;
        			if(numIndex + 1 != len)
        				numIndex++;
        			break;
        		}
    			
    			stack.add(nums[numIndex]);
    			if(numIndex + 1 != len)
    				numIndex++;
    			else
    				break;
    		}
    	}
    	
        return answer;
    }
}
