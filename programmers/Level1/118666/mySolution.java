class Solution {
    public String solution(String[] survey, int[] choices) {
    	StringBuilder answer = new StringBuilder();
    	int len = survey.length;
    	String type = "RTCFJMAN";
    	int[] surveyResult = new int[8];
    	
    	for(int i = 0; i < len; i++)
    	{
    		if(choices[i] == 4)
    		{
    			continue;
    		}
    		else if(choices[i] < 4)
    		{
    			surveyResult[type.indexOf(survey[i].charAt(0))] = surveyResult[type.indexOf(survey[i].charAt(0))] + 4 - choices[i];
    		}
    		else
    		{
    			surveyResult[type.indexOf(survey[i].charAt(1))] = surveyResult[type.indexOf(survey[i].charAt(1))] + choices[i] - 4;
    		}
    	}
    
    	int j = 0;
    	do
    	{
    		if(surveyResult[j] >= surveyResult[j + 1])
    			answer.append(type.charAt(j));
    		else
    			answer.append(type.charAt(j + 1));
    		
    		j += 2;
    	}while(j < 8);
    	
    	return answer.toString();
    }
}
