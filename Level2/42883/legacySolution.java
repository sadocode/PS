class Solution {
    // 무조건 마지막 수를 제거하는지 여부 
    private boolean isLessCase;
    
    public String solution(String number, int k) {
        for(int i = 0; i < k; i++)
        {
            number = this.getResult(number);
        }
        return number;
    }
    // 숫자 1개 뺀 값을 리턴하는 메소드
    private String getResult(String number)
    {
        int numberLength = number.length();
        StringBuilder result = null;
        
        // 무조건 마지막 수만 제거
        if(this.isLessCase)
        {
            return number.substring(0, numberLength - 1);
        }
    
        for(int i = 0; i < numberLength - 1; i++)
        {   
       		// 다음 수가 더 클 경우
            if(number.charAt(i) < number.charAt(i + 1))
            {   
                result = new StringBuilder(numberLength - 1);
                return result.append(number.substring(0, i)).append(number.substring(i + 1, numberLength)).toString();
            }
            
            // 마지막 수
            if(i == numberLength - 2 && number.charAt(i) >= number.charAt(i + 1))
            {
                this.isLessCase = true;
                return number.substring(0, i + 1);
            }
        }
        return number.substring(1, numberLength);
    }
}
