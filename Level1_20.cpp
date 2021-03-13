#include <string>
#include <vector>

using namespace std;

// 에라토스테네스의 체 이용
int solution(int n) {
    int answer = 0;
    int array[n+1];
    
    for(int i = 2; i <= n; i++)
        array[i] = i;
    
    for(int i=2; i <= n; i++)
    {
        if(array[i] == 0) continue;
        
        for(int j = 2*i; j <= n; j += i)
            array[j] = 0;
    }
    for(int i=2; i <= n; i++)
    {
        if(array[i] != 0)
            answer++;
    }
    return answer;
}
