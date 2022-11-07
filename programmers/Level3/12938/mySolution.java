class Solution {
	private int[] answer;
    public int[] solution(int n, int s) {
    	int q = s / n;
    	int r = s % n;
    	
    	if(q == 0)
    	{
    		this.answer = new int[1];
    		this.answer[0] = -1;
    		return this.answer;
    	}

    	this.answer = new int[n];
    	for(int i = 0; i < n - r; i++)
    		this.answer[i] = q;
    	for(int i = n - r; i < n; i++)
    		this.answer[i] = q + 1;
    	
        return this.answer;
    }
}
