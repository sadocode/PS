import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        Map<String, Boolean> map = new HashMap<>();
        int wordsLength = words.length;
        String firstWord = null;
        for(int i = 0; i < wordsLength; i++)
        {
        	// 끝말, 첫말 문자
        	if(i != 0 && !words[i].startsWith(firstWord))
        	{
        		answer[1] = i / n + 1;
        		answer[0] = i % n + 1;
        		break;
        	}
        	firstWord = words[i].substring(words[i].length() - 1, words[i].length());

        	if(map.containsKey(words[i]))
        	{
        		answer[1] = i / n + 1;
        		answer[0] = i % n + 1;
        		break;
        	}	
        	map.put(words[i], true);
        }

        return answer;
    }
}
