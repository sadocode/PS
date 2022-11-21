날짜 : 2022-11-21  
  
링크 : https://programmers.co.kr/learn/courses/30/lessons/42627  
  
풀이 :  
우선순위큐를 이용해서 풂.  
Arrays.sort(), PriorityQueue 의 우선순위 변경에 대해서 기억해둘 것!!!  
Arrays.sort()
~~~
Arrays.sort(arr, new Comparator<Integer>() {
    public int compare(Integer x, Integer y) {
        if(x > y)
            return 1;	// x > y 이면 뒤로. 양수를 리턴하면 우선순위를 뒤로 한다는 거
        else
            return -1;	// x <= y 이면 앞으로. 음수를 리턴하면 우선순위를 앞으로 한다는 거
    }
});
~~~
  
PriorityQueue
~~~
PriorityQueue<String> queue = new PriorityQueue<>((x, y) -> {
    if(x.compareTo(y) > 1)
        return -1;	// x.compareTo(y) > 1 : y가 사전식으로 더 앞에 있을 경우 우선순위 앞으로.
    else
        return 1;	// y가 사전식으로 뒤에 있을 경우, 우선순위 뒤로.
});
~~~
