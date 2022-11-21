package com.yna.test2021;

class Solution {
    public int[] solution(long begin, long end) {
    	int len = (int)(end - begin) + 1;
        int[] answer = new int[len];

        int idx = 0;
        long divisor = 0;
        long j = 0;
        long tempJ = 0;
        
        for(long i = begin; i <= end; i++)
        {
        	if(i != 1)
        		answer[idx] = 1; 
        	else 
        	{
        		idx++;
        		continue;
        	}
        	
        	divisor = 2;
        	j = i / divisor;
        	if(j > 10000000)
        	{
        		j = 10000000;
        		divisor = i / j;
        	}

        	while(j > 1)
        	{
        		if(i % j == 0)
        		{
        			answer[idx] = (int)j;
        			break;
        		}
        		else
        		{
        			tempJ = j;
        			j = i / (++divisor);
        			if(tempJ == j)
        			{
        				j--;
        				divisor = i / j - 1;
        			}
        		}
        	}
        	
        	idx++;
        }
        
        return answer;
    }
}
