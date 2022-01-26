class Solution {
    public int solution(int n, int[] stations, int w) {
        int sLength = stations.length;
        int result = 0;
        
        int tempIdx = 1;
        int tempLength = 0;
        int tempR = 0;
        int tempQ = 0;
        
        for(int i = 0; i < sLength; i++)
        {
            tempLength = stations[i] - w - tempIdx;
            
            // 각 항목의 앞 쪽
            if(tempLength > 0)
            {
                tempQ = tempLength / (2 * w + 1);
                tempR = tempLength % (2 * w + 1);
                
                if(tempR != 0)
                    result += tempQ + 1;
                else
                    result += tempQ;
            }
            
            // 마지막일 경우, 뒷 부분도 계산
            if(i == sLength - 1)
            {
                tempLength = n - stations[i] - w;
                
                if(tempLength > 0)
                {
                    tempQ = tempLength / (2 * w + 1);
                    tempR = tempLength % (2 * w + 1);
                    
                    if(tempR != 0)
                        result += tempQ + 1;
                    else
                        result += tempQ;
                }
            }
            
            // 전파가 안 닿는 곳의 idx
            tempIdx = stations[i] + w + 1;
        }
        
        return result;
    }
}
