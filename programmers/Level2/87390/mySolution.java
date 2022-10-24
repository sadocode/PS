class Solution {
    public int[] solution(int n, long left, long right) {
    	int count = Long.valueOf(right - left).intValue() + 1;
        int[] answer = new int[count];
        
        int leftRow = Long.valueOf(left / n).intValue();
        int leftColumn = Long.valueOf(left % n).intValue();
        
        int rowIndex = leftRow;
        int columnIndex = leftColumn;
        
        while(count > 0)
        {
        	answer[answer.length - count] = rowIndex > columnIndex ? rowIndex + 1: columnIndex + 1;
        	
        	if(columnIndex + 1 != n)
        		columnIndex++;
        	else
        	{
        		columnIndex = 0;
        		rowIndex++;
        	}
        	
        	count--;
        }
        
        return answer;
    }
}
