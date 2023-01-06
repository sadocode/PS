import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
    	// 오늘 날짜 저장
    	String[] temp = today.split("\\.");
    	int[] date = new int[3];
    	for(int i = 0; i < 3; i++)
    		date[i] = Integer.parseInt(temp[i]);
    	
    	// 약관 저장
    	Map<String, String> tMap = new HashMap<>();
    	String term = null;
    	int termPeriod = 0;
    	int[] termArr;
    	StringBuilder termResult;
    	for(int i = 0; i < terms.length; i++)
    	{
    		temp = terms[i].split(" ");
    		term = temp[0];
    		termPeriod = Integer.parseInt(temp[1]);
    		termArr = new int[3];
    		if(date[2] == 28)
    		{
    			termArr[2] = 1;
    			termArr[1] = date[1];
    		}
    		else
    		{
    			termArr[2] = date[2] + 1;
    			termArr[1] = date[1] - 1;
    		}
    		
    		termArr[1] -= (termPeriod % 12 - 1);
    		if(termArr[1] < 1)
    		{
    			termArr[1] += 12;
    			termArr[0] = date[0] - 1;
    		}
    		else
    			termArr[0] = date[0];
    		termArr[0] -= (termPeriod / 12);
    		
    		termResult = new StringBuilder();
    		termResult.append(termArr[0]).append(".");
    		if(termArr[1] < 10)
    			termResult.append(0);
    		termResult.append(termArr[1]).append(".");
    		if(termArr[2] < 10)
    			termResult.append(0);
    		termResult.append(termArr[2]);
    		tMap.put(term, termResult.toString());
    	}
    	
    	// privacies 체크
    	String tempP;
    	List<Integer> list = new ArrayList<>();
    	for(int i = 0; i < privacies.length; i++)
    	{
    		temp = privacies[i].split(" ");
    		tempP = temp[1];
    		
    		if(temp[0].compareTo(tMap.get(tempP)) < 0)
    			list.add(i + 1);
    	}
    	
        return list.stream().mapToInt(i->i).toArray();
    }
}
