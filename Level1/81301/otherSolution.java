class Solution {
    public int solution(String s) {
    	String[] value = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    	for (int i = 0; i < 10; i++)
    	{
    		s = s.replaceAll(value[i], Integer.toString(i));
    	}
    	return Integer.parseInt(s);
    }
}
