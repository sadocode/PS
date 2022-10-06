class Solution {
    public int solution(int n) {
    	
    	int count = Integer.bitCount(n);
    	int num = n + 1;
    	while(num <= 1000000)
    	{
    		if(count == Integer.bitCount(num))
    			return num;
    		else
    			num++;
    	}
    	return 1000000;
    }
}
