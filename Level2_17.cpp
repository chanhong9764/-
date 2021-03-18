#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(int n) {
    int answer = 0;
    
    int a = 0, b = 0, c = 1;
    
    if(n == 1)
        answer = 1;
    
    for(int i = 2; i <= n; i++)         // 피보나치 수열
    {
        a = b % 1234567;                // int형 범위를 넘지 않게
        b = c % 1234567;
        c = (a + b) % 1234567;         
    }
    answer = c;
    return answer;
}
