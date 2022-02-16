import java.math.BigInteger;

public class Solution {

    public long solution(int w, int h) {
        long totalCount = (long) w * (long) h;
        long diagonalCount = w + h - BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();

        return totalCount - diagonalCount;
    }
}

-------------------------------------------------------


class Solution {
    public long solution(int w,int h) {
        long min=Math.min(w, h);
        long max=Math.max(w, h);
        long remain=1;
        while(remain>0) {
            remain=max%min;
            max=min;
            min=remain;
        }
        long answer = (long)w*(long)h-max*(w/max + h/max -1);
        return answer;
    }
}



-------------------------------------------------------

class Solution {

    public long solution(int w,int h) {

        long answer = 0L;

        long gcd = gcd(w, h);
        answer = (long)w * (long)h - ((long)w + (long)h - gcd);

        return answer;

    }//end of solution

    private long gcd(int w, int h){

        if(w == 0) return h;
        return gcd(h % w, w);

    }//end of gcd

}//end of solution


