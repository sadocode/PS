class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
    	int answer = 0;
    	boolean isOk = false;
    	int[] count = new int[number.length];
    	
    	String tempString = discount[0];
    	int tempValue = 0;
    	
    	// 처음 10개 count
    	for(int i = 0; i <= 9; i++)
    	{
    		tempValue = getPos(discount[i], want);
			if(tempValue != -1)
				count[tempValue]++;
    	}
    	
    	// 비교
    	for(int i = 0; i <= discount.length - 10; i++)
    	{
    		if(i == 0)
    		{
    			if(isSame(count, number))
    			{
    				answer++;
    				isOk = true;
    			}
    			continue;
    		}
    		
    		// 방금전에 성공했을 경우, 다음턴은 isOk = true임.
    		if(isOk)
    		{
    			// tempString 방금전 첫번째 날의 물건 == 새로운 날의 마지막날 물건
    			if(tempString.equals(discount[i + 9]))
    			{
    				answer++;
    			}
    			else
    			{
    				isOk = false;
    				count[getPos(tempString, want)]--;
    				tempValue = getPos(discount[i + 9], want);
    				if(tempValue != -1)
    					count[tempValue]++;
    			}
    		}
    		else
    		{
    			tempValue = getPos(tempString, want);
    			if(tempValue != -1)
    				count[tempValue]--;
    			
    			tempValue = getPos(discount[i + 9], want);
    			if(tempValue != -1)
    				count[tempValue]++;
				
				if(isSame(count, number))
				{
					answer++;
					isOk = true;
				}
    		}
    		tempString = discount[i];
    	}
    	
        return answer;
    }
    private static int getPos(String s, String[] arr)
    {
    	for(int i = 0; i < arr.length; i++)
    	{
    		if(s.equals(arr[i]))
    			return i;
    	}
    	return -1;
    }
    private static boolean isSame(int[] a, int[] b)
    {
    	for(int i = 0; i < a.length; i++)
    	{
    		if(a[i] != b[i])
    			return false;
    	}
    	return true;
    }
}
