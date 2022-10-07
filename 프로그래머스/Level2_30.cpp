#include <iostream>

using namespace std;

int solution(int n, int a, int b)
{
    int answer = 0;

    while(a != b)                   // 만났을 때 각 숫자를 2로 나누게 되면 같아지므로 조건을 다음과 같이 걸음
    {
        if(a % 2 == 0)              // 짝수일 경우 그대로 나누어준다
            a /= 2;
        else
            a = (a+1) / 2;          // 홀수는 그대로 나눌 경우 잘못된 라운드로 가므로 +1을 해준다 
        
        if(b % 2 == 0)
            b /= 2;
        else
            b = (b+1) / 2;

        answer++;
    }

    return answer;
}
