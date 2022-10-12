class Solution
{
    public int solution(int n, int a, int b)
    {
    	int temp = 0;
    	if(a > b)
    	{
    		temp = a;
    		a = b;
    		b = temp;
    	}

    	int time = 0;
    	while(n > 1)
    	{
    		n /= 2;
    		time++;
    	}

    	int answer = 0;
    	for(int i = 0; i < time; i++)
    	{
    		answer++;
    		a = a / 2 + a % 2;
    		b = b / 2 + b % 2;
    		
    		if(a == b)
    			break;
    	}

        return answer;
    }
}
