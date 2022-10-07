#include <string>
#include <vector>
#include <cmath>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    long long tmp=sqrt(n);
    if(tmp*tmp == n)
        answer = (tmp+1)*(tmp+1);
    else
        answer = -1;
    return answer;
}
