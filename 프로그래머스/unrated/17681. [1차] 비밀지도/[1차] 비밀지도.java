/*
26.06.10

비밀지도 - 숫자로 암호화됨
한 변의 길이가 n인 정사각형 배열 형태
  각 칸은 " " 또는 #(벽) 두 종류로 이루어짐
전체지도는 두 장의 지도를 겹쳐서 얻을 수 있음.
  어느 하나라도 벽이면 벽임
  모두 공백은 모두 공백
지도는 정수 배열로 암호화됨
암호화된 배열은 벽=1 공백=0으로 부호화 했을 때 얻어지는 이진수에 해당하는 값의 배열임

비밀지도의 암호를 해독하는 작업을 도와줄 프로그램 작성하기
> # " "으로 구성된 문자열 배열로 출력

I: int n, int[] arr1, int[] arr2
O: String[]
C: 1 <= n <= 6
    arr1, arr2 길이는 n인 정수 배열
    정수 배열의 각 원소 x를 이진수로 변환했을때의 길이는 n 이하이다.
      0 <= x <= 2^n-1
E:

길이가 n인 결과배열 생성
n*n의 비밀지도(이차원배열) 생성
arr1 - 지도1, arr2 - 지도2 > 이진수로 변경
  Integer.toBinaryString()
이진수를 벽(1)과 공백(0)으로 보기
이차원 배열에서 벽이 있다면 #, 없다면 냅두기 >> 비밀지도 완성
이차원배열 값 읽어서 문자열로 만들고 그걸 결과배열에 넣기

solution:
결과 배열 생성 String[] = new String[n]
arr1, arr2 순회
    StringBuilder 생성
    n1, n2를 이진수로 변경 > Integer.toBinaryString()
    n1 n2를 인덱스끼리 비교
        하나라도 "1" > "#"
        아니라면 > " "
        sb에 append
    sb를 결과 배열에 넣기

time: O(N^2)
space: O(N)
*/
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            
            // 이진수 문자열로 변경
            String s1 = Integer.toBinaryString(arr1[i]);
            String s2 = Integer.toBinaryString(arr2[i]);
            
            //자릿수 맞춰주기 작업 필요
            s1 = makeSameLength(s1, n);
            s2 = makeSameLength(s2, n);
            
            for (int j = 0; j < n; j++) {
                String curS = (s1.charAt(j) == '1' || s2.charAt(j) == '1') ? "#": " ";
                sb.append(curS);
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
    
    public String makeSameLength(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n - s.length(); i++) {
            sb.append("0");
        }
        sb.append(s);
        
        return sb.toString();
    }
}
