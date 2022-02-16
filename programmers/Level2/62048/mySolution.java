class Solution {
	public long solution(int w, int h) {
		// 두 변이 같을 경우
		if(w == h && w != 1)
		{
			return ((long)w *(long)w) - w;
		}
		// 1변이 1일 경우
		else if(w == 1 || h == 1)
		{
			return 0;
		}
		
		// 긴 변과 짧은 변으로 설정
        long longSide = 0;
        long shortSide = 0;
		if(w > h)
        {
        	longSide = w;
        	shortSide = h;
        }
		else
		{
			longSide = h;
			shortSide = w;
		}
		
		// 온전한 사각형 값
		long check = 0;
		
		// 긴 변의 가운데
		int half = (int)longSide / 2;
		
		// 짧은 변 / 긴 변
		double value = (double)shortSide / (double)longSide;
		
		// 비교용 변수
		long tempValue = 0;

		// 비교용 플래그 
		int tempHeight = (int)shortSide - 1;
		
		// 1 ~ half
		for(int i = 1; i < half; i++)
		{
			tempValue = (long)(value * (longSide - i));
			for(int j = tempHeight; j > 0; j--)
			{
				if(j <= tempValue)
				{
					check += j;
					tempHeight = j;
					break;
				}				
			}
		}
		
		// half ~ longSide
		tempHeight = (int)shortSide / 2;
		for(int i = half; i < longSide; i++)
		{
			tempValue = (long)(value * (longSide - i));
			for(int j = tempHeight; j > 0; j--)
			{
				if(j <= tempValue)
				{
					check += j;
					tempHeight = j;
					break;
				}
			}
		}

		return 2 * check;
    }
}
