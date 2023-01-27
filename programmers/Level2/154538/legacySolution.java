class Solution {
	private static int[] arr;
	public int solution(int x, int y, int n) {
        if(x == y)
            return 0;
		arr = new int[y - x + 1];
		dp(0, x, y, n, 0);
		
		if(arr[y - x] == 0)
			return -1;
		else
			return arr[y - x];
    }
    private static void dp(int idx, int x, int y, int n, int count)
    {
    	if(idx == 0)
    	{
    		
    	}
    	else if(idx >= arr.length)
    	{
    		return;
    	}
    	else
    	{
    		if(arr[idx] == 0 || (arr[idx] > 0 && arr[idx] > count))
    			arr[idx] = count + 1;
    		else
    			return;
    	}
    	
    	dp(((idx + x) * 3) - x, x, y, n, arr[idx]);
    	dp(((idx + x) * 2) - x, x, y, n, arr[idx]);
    	dp(idx + n, x, y, n, arr[idx]);
    }
}
