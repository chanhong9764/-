#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    int temp = 1;                   // 더하기 시작하는 수                           
    
    while(temp != n+1)              // n보다 크면 안됨          
    {
        int t = temp;               // t는 더하는 수       
        int total = temp;           // total은 모든 t를 더한 수
        while(total < n)            // total이 n보다 크면 안됨
        {
             total += ++t;
        }
        if(total == n)              // total이 n과 같으면 답 +1
            answer++;
        temp++;                     // 1부터 n까지 계속해서 확인
    }
    return answer;
}
