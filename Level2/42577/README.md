날짜 : 2022-01-19

링크 : https://programmers.co.kr/learn/courses/30/lessons/42577

풀이 :
처음 짠 방식
> 전화번호 길이별로 HashSet 저장.
> 길이가 짧은 것과 긴 것을 startsWith으로 비교.

두 번째 방식
> HashSet에 싹다 저장.
> substring 해가면서 HashSet과 비교.

처음은 최적화를 많이했는데, Big-O : n^2. 테스트 케이스 수가 많아짐에 따라, 시간초과가 발생.
두 번째는 substring 때문에, 큰 비용 발생. 하지만 Big-O : n. 
아무리 최적화해도 물량 따지면... Big-O 작게 나오게 하는게 맞는 거 같음.
