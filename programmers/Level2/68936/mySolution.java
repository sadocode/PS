class Solution {
	private static int[] answer = new int[2];
    public int[] solution(int[][] arr) {
    	check(arr, arr.length, 0, 0);
        return answer;
    }
    private static void check(int[][] arr, int len, int x, int y)
    {
    	if(len == 1)
    	{
    		answer[arr[x][y]]++;
    		return;
    	}
    	
    	int count0 = 0;
    	int count1 = 0;
    	for(int i = x; i < x + len; i++)
    	{
    		for(int j = y; j < y + len; j++)
    		{
    			if(arr[i][j] == 0)
    				count0++;
    			else
    				count1++;
    		}
    	}
    	
    	if(count0 == 0)
    	{
    		answer[1]++;
    		return;
    	}
    	else if(count1 == 0)
    	{
    		answer[0]++;
    		return;
    	}
    	else
    	{
    		check(arr, len / 2, x, y);
    		check(arr, len / 2, x + len / 2, y);
    		check(arr, len / 2, x, y + len / 2);
    		check(arr, len / 2, x + len / 2, y + len / 2);
    	}
    }
}
