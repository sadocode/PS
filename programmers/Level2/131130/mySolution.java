class Solution {
	private static boolean[] visit;
    public int solution(int[] cards) {
    	int len = cards.length;
    	boolean[] v;
    	int answer = 0;
    	int countA = 0;
    	int countB = 0;
    	
    	// 1번째 카드
    	for(int i = 0; i < len; i++)
    	{
    		visit = new boolean[len];
    		countA = process(cards, visit, i, 0);
    		
    		// 2번째 카드
    		for(int j = 0; j < len; j++)
    		{
    			v = visit;
    			if(!v[j])
    			{
    				countB = process(cards, v, j, 0);
    				answer = countA * countB > answer ? countA * countB : answer;
    			}
    		}
    	}
        
        return answer;
    }
    
    private static int process(int[] c, boolean[] v, int idx, int count)
    {
    	if(!v[c[idx] - 1])
    	{
    		v[c[idx] - 1] = true;
    		count++;
    		count = process(c, v, c[idx] - 1, count);
    	}
    	
    	return count;
    }
}
