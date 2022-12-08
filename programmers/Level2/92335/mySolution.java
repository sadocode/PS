class Solution {
    public int solution(int n, int k) {
    	StringBuilder num = new StringBuilder();
    	
    	while(n > 0)
    	{
    		num.append(n % k);
    		n /= k;
    	}
    	num.reverse();
    	String[] arr = num.toString().split("0");
    	long t = 0;
    	int answer = 0;
    	
    	for(int i = 0; i < arr.length; i++)
    	{
    		if(arr[i].length() == 0 || "1".equals(arr[i]))
    			continue;
    		t = Long.parseLong(arr[i]);
    		if(isPrime(t))
    			answer++;
    	}
    	return answer == 0 ? -1 : answer;
    }
    private static boolean isPrime(long num)
    {
    	for(long i = 2; i <= (long)Math.sqrt(num); i++)
    	{
    		if(num % i == 0)
    			return false;
    	}
    	return true;
    }
}
