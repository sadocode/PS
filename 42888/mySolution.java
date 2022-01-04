import java.util.Map;
import java.util.HashMap;

class Solution {
    // 채팅 문자열 배열
    private static final String[] CHAT_WORD = {"님이 ", "들어왔습니다.", "나갔습니다."};
    
    public String[] solution(String[] record) {
        int recordLength = record.length;
        
        // user 정보를 담는 Map
        Map<String, String> userInfo = new HashMap<String, String>();
        
        // 임시
        String[] tempArr = new String[3];
        StringBuilder tempSB = null;
        
        // Leave 문자열 제외 개수 
        int answerLength = 0;
        for(int i = 0; i < recordLength; i++)
        {
            tempArr = record[i].split(" ");
            
            // uid - nickname 저장
            switch(tempArr[0].charAt(0))
            {
                case 'C':
                    userInfo.put(tempArr[1], tempArr[2]);
                    break;
                case 'E':
                    userInfo.put(tempArr[1], tempArr[2]);
                case 'L':
                    answerLength++;
            }
        }
        
        // 정답 배열
        String[] answer = new String[answerLength];
        
        // 정답 배열에 넣을 주소
        int address = answerLength;
        
        // answer add
        for(int i = recordLength - 1; i >= 0; i--)
        {
            tempArr = record[i].split(" ");
            tempSB = new StringBuilder(userInfo.get(tempArr[1])).append(CHAT_WORD[0]);
            
            if(tempArr[0].startsWith("E"))
                tempSB.append(CHAT_WORD[1]);
            else if(tempArr[0].startsWith("L"))
                tempSB.append(CHAT_WORD[2]);
            else
                continue;
            
            answer[--address] = tempSB.toString();
        }
        
       return answer;
    }
}
