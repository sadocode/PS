class Solution {
    public int solution(int[][] sizes) {

    	int max1 = 0;
    	int max2 = 0;
    	int bigger = 0;
    	int smaller = 0;
    	for(int i = 0; i < sizes.length; i++)
    	{
    		bigger = sizes[i][0] > sizes[i][1] ? sizes[i][0] : sizes[i][1];
    		smaller = sizes[i][0] > sizes[i][1] ? sizes[i][1] : sizes[i][0];
    		
    		if(bigger > max1)
    			max1 = bigger;
    		if(smaller > max2)
    			max2 = smaller;
    	}
    
    	return max1 * max2;
    }
}
