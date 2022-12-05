class Solution {
    public long solution(int k, int d) {
    	double d_k = (double)d / (double)k;
    	int max = (int)Math.floor(d_k);
    	double z = Math.pow((double)d / (double)k, 2);
        long answer = 0;
        
        double value = 0;
        int j = 0;
        for(int i = max; i > 0; i--)
        {
        	value = Math.sqrt(z - Math.pow(i, 2));
        	j = (int)Math.floor(value);
        	if(j > i)
        		j = i;
        	answer += 2 * (j + 1);
        	if(i == j)
        		answer--;
        }
        return answer + 1;
    }
}
