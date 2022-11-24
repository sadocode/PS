import java.util.LinkedList;
import java.util.List;

class Solution {
    public int solution(int[] ingredient) {
    	List<Integer> stack = new LinkedList<>();
    	int len = ingredient.length;
    	int answer = 0;
    	
    	for(int i = 0; i < len; i++)
    	{
    		stack.add(ingredient[i]);
    		if(ingredient[i] == 1)
    			answer += remove(stack);
    	}
        
        return answer;
    }
    private static int remove(List<Integer> list)
    {
    	int result = 0;
    	int len = 0;
    	while(list.size() >= 4)
    	{
    		len = list.size();
    		if(list.get(len - 1) == 1 && list.get(len - 2) == 3 && list.get(len - 3) == 2 && list.get(len - 4) == 1)
    		{
    			list.remove(len - 1);
    			list.remove(len - 2);
    			list.remove(len - 3);
    			list.remove(len - 4);
    			result++;
    		}
    		else
    			break;
    	}
    	return result;
    }
}
