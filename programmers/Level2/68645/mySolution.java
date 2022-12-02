class Solution {
    public int[] solution(int n) {
    	int len = (n * (n + 1)) / 2;
        int[] answer = new int[len];
        
        if(n == 1)
        {
        	answer[0] = 1;
        	return answer;
        }
        
        int[][] arr = new int[n][n];
        
        for(int i = 0; i < n; i++)
        {
        	for(int j = n - 1; j >= 0; j--)
        	{
        		if(i >= j)
        			break;
        		arr[i][j] = -1;
        	}
        }
        
        int value = 1;
        int x = 0;
        int y = 0;
        int moveType = 1;	// 1 : 아래. 2 : 오른쪽. 3 : 위쪽
        while(value <= len)
        {
        	if(value == 1)
        	{
        		arr[x][y] = value++;
        		continue;
        	}
        	
        	// moveType 보고 변수값 변환.
    		// 갈 수 있는지 체크. 갈 수 있으면 값 넣음.
    		// 갈 수 없으면 변수값 원복 후, moveType 변경
        	switch(moveType)
        	{
        	case 1:
        		x++;
        		if(x < n && arr[x][y] == 0)
        		{
        			arr[x][y] = value++;
        		}
        		else
        		{
        			x--;
        			moveType = 2;
        		}
        		break;
        	case 2:
        		y++;
        		if(y < n && arr[x][y] == 0)
        		{
        			arr[x][y] = value++;
        		}
        		else
        		{
        			y--;
        			moveType = 3;
        		}
        		break;
        	case 3:
        		x--;
        		y--;
        		if(x >= 0 && y >= 0 && arr[x][y] == 0)
        		{
        			arr[x][y] = value++;
        		}
        		else
        		{
        			x++;
        			y++;
        			moveType = 1;
        		}
        		break;
        	}
        }
        
        int idx = 0;
        for(int i = 0; i < n; i++)
        {
        	for(int j = 0; j < n; j++)
        	{
        		if(i < j)
        			break;
        		answer[idx] = arr[i][j];
        		idx++;
        	}
        }
        return answer;
    }
}
