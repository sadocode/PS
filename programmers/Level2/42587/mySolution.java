import java.util.LinkedList;
import java.util.List;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        List<Value> list = new LinkedList<Value>();
        for(int i = 0; i < priorities.length; i++)
        {
        	if(i != location)
        		list.add(new Value(priorities[i]));
        	else
        		list.add(new Value(priorities[i], true));
        }
        
        Value temp = null;
        while(answer <= priorities.length)
        {
        	if(list.get(0).getValue() >= this.getMax(list))
        	{
        		answer++;
        		if(list.get(0).getIsChosen())
        			break;
        		list.remove(0);
        	}
        	else
        	{
        		temp = list.get(0);
        		list.remove(0);
        		list.add(temp);
        	}
        }
        
        return answer;
    }
    private int getMax(List<Value> list)
    {
    	int max = 0;
    	for(int i = 0; i < list.size(); i++)
    	{
    		if(list.get(i).getValue() >= max)
    			max = list.get(i).getValue();
    	}
    	return max;
    }
    class Value{
    	int value;
    	boolean isChosen;
    	Value(int value)
    	{
    		this.value = value;
    	}
    	Value(int value, boolean isChosen)
    	{
    		this.value = value;
    		this.isChosen = isChosen;
    	}
    	public int getValue()
    	{
    		return this.value;
    	}
    	public boolean getIsChosen()
    	{
    		return this.isChosen;
    	}
    }
}
