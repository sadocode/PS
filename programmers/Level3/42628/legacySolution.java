import java.util.ArrayList;
import java.util.List;

class Solution {
	private static final String DEQUEUE_MIN = "D -1";
	private static final String DEQUEUE_MAX = "D 1";
	
    public int[] solution(String[] operations) {
    	List<Integer> heap = new ArrayList<>();
    	// 0번째
    	heap.add(0);
    	
    	for(int i = 0; i < operations.length; i++)
    	{
    		if(operations[i].equals(DEQUEUE_MIN))
    		{
    			if(heap.size() == 1)
    				continue;
    			
    			dequeueMin(heap);
    		}
    		else if(operations[i].equals(DEQUEUE_MAX))
    		{
    			if(heap.size() == 1)
    				continue;
    			
    			dequeueMax(heap);
    		}
    		else
    		{
    			heap.add(Integer.parseInt(operations[i].substring(2)));
    			swap(heap, heap.size() - 1);
    		}
    	}

//    	for(int j = 0; j < heap.size(); j++)
//    		System.out.print("   #" + heap.get(j));
//    	System.out.println();
    	
        int[] answer = new int[2];
        if(heap.size() == 1)
        {
        	answer[0] = 0;
        	answer[1] = 0;
        }
        else
        {
        	answer[0] = heap.get(1);
        	answer[1] = dequeueMin(heap);
        }
        return answer;
    }
    private static void swap(List<Integer> list, int pos)
    {
    	int a = 0;
    	int b = 0;
    	
    	if(pos / 2 > 0 && list.get(pos) > list.get(pos / 2))
    	{
    		a = list.get(pos / 2);
    		b = list.get(pos);
    		list.remove(pos / 2);
    		list.add(pos / 2, b);
    		list.remove(pos);
    		list.add(pos, a);
    		swap(list, pos / 2);
    	}
    	int target = -1;
    	if(list.size() -1 == pos * 2)
    	{
    		target = pos * 2;
    	}
    	else if(list.size() - 1 >= pos * 2 + 1)
    	{
    		target = list.get(pos * 2) > list.get(pos * 2 + 1) ? pos * 2 : pos * 2 + 1;
    	}
    	
    	if(target != -1 && list.get(pos) < list.get(target))
    	{
    		a = list.get(pos);
    		b = list.get(target);
    		list.remove(pos);
    		list.add(pos, b);
    		list.remove(target);
    		list.add(target, a);
    		swap(list, target);
    	}
    }
    private static void dequeueMax(List<Integer> list)
    {
    	list.remove(1);
    	list.add(1, list.get(list.size() - 1));
    	list.remove(list.size() - 1);
    	swap(list, 1);
    }	
    private static int dequeueMin(List<Integer> list)
    {
    	int result = 0;
    	if(list.size() == 2)
    	{
    		result = list.get(1);
    		list.remove(1);
    		return result;
    	}
    		
    	int depth = (list.size() - 1) / 2;
    	int value = 1;
    	int min = 0;
    	int minPos = -1;
    	for(int i = 0; i < depth; i++)
    		value *= 2;

    	for(int i = value; i < list.size(); i++)
    	{
    		if(minPos == -1)
    		{
    			minPos = i;
    			min = list.get(i);
    			continue;
    		}
    			
    		if(min > list.get(i))
    		{
    			minPos = i;
    			min = list.get(i);
    		}
    	}
    	result = min;
    	list.remove(minPos);
    	return result;
    }
}
