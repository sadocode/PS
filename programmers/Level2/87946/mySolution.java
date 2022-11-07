import java.util.LinkedList;
import java.util.List;

class Solution {
	private static List<String> list = new LinkedList<>();
    public int solution(int k, int[][] dungeons) {
    	int[] d = new int[dungeons.length];
    	boolean[] check = new boolean[d.length];
    	for(int i = 0; i < d.length; i++)
    		d[i] = i;

    	permutation(d.length, 0, d, check, "");
    	
    	int max = 0;
    	int count = 0;
    	for(int i = 0; i < list.size(); i++)
    	{
    		count = getCount(k, dungeons, list.get(i));
    		
    		if(count > max)
    			max = count;
    	}
    	return max;
    }
    private static void permutation(int len, int count, int[] d, boolean[] check, String result)
    {
    	if(len == count)
    	{
    		list.add(result);
    		return;
    	}
    	for(int i = 0; i < len; i++)
    	{
    		if(check[i])
    			continue;
    		check[i] = true;
    		permutation(len, count + 1, d, check, result + d[i]);
    		check[i] = false;
    	}
    }
    private static int getCount(int k, int[][] d, String order)
    {
    	int temp = 0;
    	int count = 0;
    	for(int i = 0; i < order.length(); i++)
    	{
    		temp = Integer.parseInt("" + order.charAt(i));
    		if(k >= d[temp][0])
    		{
    			k -= d[temp][1];
    			count++;
    		}
    	}
    	return count;
    }
}
