import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
    	Arrays.sort(arrayA);
    	Arrays.sort(arrayB);
    	PriorityQueue<Integer> aList = getDivisorList(arrayA[0]);
    	PriorityQueue<Integer> bList = getDivisorList(arrayB[0]);
    	
    	boolean isAFin = false;
    	boolean isBFin = false;
    	int max = 0;
    	int a = 0;
    	int b = 0;
    	boolean isANext = false;
    	boolean isBNext = false;
    	while(!isAFin || !isBFin)
    	{
    		if(!aList.isEmpty())
    			a = aList.peek();
    		else
    			isAFin = true;
    		if(!bList.isEmpty())
    			b = bList.peek();
    		else 
    			isBFin = true;
    		
    		if(isAFin)
    			isANext = true;
    		else
    			isANext = false;
    		if(isBFin)
    			isBNext = true;
    		else
    			isBNext = false;

    		if(isAFin && max > b)
    			break;
    		else if(isBFin && max > a)
    			break;
    		
    		for(int i = 0; i < arrayA.length; i++)
    		{
    			if(!isANext)
    			{
    				if(arrayA[i] % a != 0)
    				{
    					aList.poll();
    					isANext = true;
    				}
    			}
    			
    			if(!isANext)
    			{
    				if(arrayB[i] % a == 0)
    				{
    					aList.poll();
    					isANext = true;
    				}
    			}
    			
    			if(!isBNext)
    			{
    				if(arrayB[i] % b != 0)
    				{
    					bList.poll();
    					isBNext = true;
    				}
    			}
    			
    			if(!isBNext)
    			{
    				if(arrayA[i] % b == 0)
    				{
    					bList.poll();
    					isBNext = true;
    				}
    			}
    			
    			if(i + 1 == arrayA.length)
    			{
    				if(!isANext)
    				{
    					if(max < a)
    						max = a;
    					isAFin = true;
    				}
    				
    				if(!isBNext)
    				{
    					if(max < b)
    						max = b;
    					isBFin = true;
    				}
    			}
    		}
    	}
    	
        return max;
    }
    private static PriorityQueue<Integer> getDivisorList(int num)
    {
    	PriorityQueue<Integer> list = new PriorityQueue<>(Collections.reverseOrder());
    	
    	for(int i = 2; i <= Math.sqrt(num); i++)
    	{
    		if(num % i == 0)
    		{
    			list.add(i);
    			if(i != num / i)
    				list.add(num / i);
    		}
    	}
    	
    	if(!list.contains(num))
    		list.add(num);
    	
    	return list;
    }
}
