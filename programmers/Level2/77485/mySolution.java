class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
    	int[][] arr = new int[rows][columns];
    	for(int i = 0; i < rows; i++)
    	{
    		for(int j = 0; j < columns; j++)
    		{
    			arr[i][j] = (i  * columns + (j + 1));
    		}
    	}
    	
        int[] answer = new int[queries.length];
        int tempValue = 0;
        int tempMin = 0;
        int aX = 0;
        int aY = 0;
        int bX = 0;
        int bY = 0;
        for(int i = 0; i < answer.length; i++)
        {
        	aX = queries[i][0] - 1;
        	aY = queries[i][1] - 1;
        	bX = queries[i][2] - 1;
        	bY = queries[i][3] - 1;
        	tempMin = arr[aX][aY];
        	tempValue = arr[aX][bY];
        	// 윗변
        	for(int j = bY; j > aY; j--)
        	{
        		arr[aX][j] = arr[aX][j - 1];
        		if(arr[aX][j - 1] < tempMin)
        			tempMin = arr[aX][j - 1];
	       	}
        	// 좌변
        	for(int j = aX; j < bX; j++)
        	{
        		arr[j][aY] = arr[j + 1][aY];
        		if(arr[j + 1][aY] < tempMin)
        			tempMin = arr[j + 1][aY];
        	}
        	// 밑변
        	for(int j = aY; j < bY; j++)
        	{
        		arr[bX][j] = arr[bX][j + 1];
        		if(arr[bX][j + 1] < tempMin)
        			tempMin = arr[bX][j + 1];
        	}
        	// 우변
        	for(int j = bX; j > aX; j--)
        	{
        		if(j - 1 != aX)
        			arr[j][bY] = arr[j - 1][bY];
        		else
        			arr[j][bY] = tempValue;
        		
        		if(arr[j - 1][bY] < tempMin)
        			tempMin = arr[j - 1][bY];
        		if(tempValue < tempMin)
        			tempMin = tempValue;
        	}
        	
        	answer[i] = tempMin;
        }
        
        return answer;
    }
}
