import java.util.LinkedList;
import java.util.List;

class Solution {
	private static List<List<String>> list = new LinkedList<>();
	
    public String[] solution(String[][] tickets) {
    	int tLen = tickets.length;
    	boolean[] check = new boolean[tLen + 1];
    	List<String> checkList = new LinkedList<String>();
    	checkList.add("ICN");
    	dfs(tickets, check, checkList, "ICN", 0);
    	
    	List<String> temp = list.get(0);
    	for(int i = 1; i < list.size(); i++)
    	{
    		for(int j = 0; j <= tLen; j++)
    		{
    			if(temp.get(j).compareTo(list.get(i).get(j)) > 0)
    			{
    				temp = list.get(i);
    				break;
    			}
    			else if(temp.get(j).compareTo(list.get(i).get(j)) < 0)
    			{
    				break;
    			}
    		}
    	}

    	String[] answer = temp.toArray(new String[tLen + 1]);
        return answer;
    }
    
    private static void dfs(String[][] tickets, boolean[] check, List<String> checkList, String start, int depth)
    {
    	if(checkList.size() == tickets.length + 1)
    	{
    		List<String> finList = new LinkedList<>();
    		finList.addAll(checkList);
    		list.add(finList);
    		return;
    	}
    	
    	for(int i = 0; i < tickets.length; i++)
    	{
    		if(!check[i] && tickets[i][0].equals(start))
    		{
    			check[i] = true;
    			checkList.add(tickets[i][1]);
    			dfs(tickets, check, checkList, tickets[i][1], depth + 1);
    			check[i] = false;
    			checkList.remove(checkList.size() - 1);
    		}
    	}
    }
}
