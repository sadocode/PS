import java.util.LinkedList;
import java.util.List;

class Solution {
	private static List<Integer> list = new LinkedList<>();
	public int solution(String begin, String target, String[] words) {
    	int targetIndex = -1;
    	for(int i = 0; i < words.length; i++)
    	{
    		if(target.equals(words[i]))
    		{
    			targetIndex = i;
    			break;
    		}
    	}
    	
    	if(targetIndex == -1)
    		return 0;
    	
    	boolean[] check = new boolean[words.length];
    	dfs(words, check, target, begin, 0);
    	
    	int min = 52;
    	for(int i = 0; i < list.size(); i++)
    	{
    		if(list.get(i) > 0 && list.get(i) < min)
    			min = list.get(i);
    	}
    	
    	if(min == 52)
    		return 0;
    	else
    		return min;
    }
	// 첨에 t = target. 계속 바뀌도록 처리.
	private static void dfs(String[] words, boolean[] check, String t, String b, int count)
	{
		if(isOneDiff(b, t))
		{
			list.add(count + 1);
			return;
		}
		
		for(int i = 0; i < words.length; i++)
		{
			if(check[i])
				continue;
			if(isOneDiff(words[i], t))
			{
				check[i] = true;
				dfs(words, check, words[i], b, count + 1);
			}
			check[i] = false;
		}
	}
	private static boolean isOneDiff(String a, String b)
	{
		int diffCount = 0;
		for(int i = 0; i < a.length(); i++)
		{
			if(a.charAt(i) != b.charAt(i))
				diffCount++;
		}
		
		if(diffCount == 1)
			return true;
		else
			return false;
	}
}
