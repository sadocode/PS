class Solution {
	public int solution(String word) {
		int answer = 0;
		char[] arr = {'A', 'E', 'I', 'O', 'U'};
		int[] index = new int[5];
		int wordLen = word.length();

		for(int i = wordLen; i < 5; i++)
			word = word + 'A';

		StringBuilder temp = null;
		while(true)
		{
			temp = new StringBuilder().append(arr[index[0]]).append(arr[index[1]]).append(arr[index[2]]).append(arr[index[3]]).append(arr[index[4]]);
		
			if(word.equals(temp.toString()))
			{
				answer = answer + getCount(word) - 6 + wordLen;
				break;
			}
			else
			{
				answer += getCount(temp.toString());
				
				for(int i = 4; i >= 0; i--)
				{
					if(index[i] != 4)
					{
						index[i]++;
						break;
					}
					else
					{
						index[i] = 0;
					}
				}
			}
		}
		
		return answer;
	}
	private static int getCount(String word)
	{
		int count = 1;
		char target = word.charAt(4);
		if(target != 'A')
			return count;
		else
			count++;
		
		for(int i = 3; i >= 0; i--)
		{
			if(word.charAt(i) == 'A')
				count++;
			else
				break;
		}
		return count;
	}
}
