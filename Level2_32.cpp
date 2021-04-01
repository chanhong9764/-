#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    int count = 0;
    int temp = n;
    int temp2 = 0;
    
    while(temp != 0)            // n 2진수 변환 후 1 갯수 카운트
    {
        if(temp % 2 == 1)
            count++;
        temp /= 2;
    }
    
    while(1)
    {
        temp2 = ++n;            // n보다 큰 수이므로 하나씩 증가시켜 찾기
        int count2 = 0;         // 큰 수를 2진 변환하여 1 개수 카운트
        while(temp2 != 0)
        {
            if(temp2 % 2 == 1)
                count2++;
            temp2 /= 2;
        }
        if(count == count2){    // 큰 수와 n의 1의 개수가 같으면 종료
            answer = n;
            break;
        }
    }
    return answer;
}
