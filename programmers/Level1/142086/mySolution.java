class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] word = new int[26];	// -97
        
        for(int i = 0; i < 26; i++)
        	word[i] = -1;
        
        for(int i = 0; i < answer.length; i++)
        {
        	if(word[s.charAt(i) - 97] == -1)
        		answer[i] = -1;
        	else
        		answer[i] = i - word[s.charAt(i) - 97];
        	word[s.charAt(i) - 97] = i;
        }
        
        return answer;
    }
}
