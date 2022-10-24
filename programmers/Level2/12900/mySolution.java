class Solution {
	private static int DIVISOR = 1000000007;
    public int solution(int n) {
    	int answer = 0;
    	int a = 1;
    	int b = 2;
    	
    	for(int i = 3; i <= n; i++)
    	{
    		answer = (a + b) % DIVISOR;
    		a = b;
    		b = answer;
    	}
        return answer;
    }
}
